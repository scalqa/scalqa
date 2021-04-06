package dotty.tools.scaladoc

import java.util.ServiceLoader
import java.io.File
import java.util.jar._
import collection.JavaConverters._
import collection.immutable.ArraySeq

import java.nio.file.Files

import dotty.tools.dotc.config.Settings._
import dotty.tools.dotc.config.CommonScalaSettings
import dotty.tools.dotc.reporting.Reporter
import dotty.tools.dotc.core.Contexts._

object Scaladoc:
  enum CommentSyntax:
    case Wiki
    case Markdown

  object CommentSyntax:
    def parse(str: String) = str match
        case "wiki" => Some(CommentSyntax.Wiki)
        case "markdown" => Some(CommentSyntax.Markdown)
        case _ => None

    val default = CommentSyntax.Markdown

  case class Args(
    name: String,
    tastyDirs: Seq[File] = Nil,
    tastyFiles: Seq[File] = Nil,
    classpath: String = "",
    output: File,
    docsRoot: Option[String] = None,
    projectVersion: Option[String] = None,
    projectLogo: Option[String] = None,
    defaultSyntax: CommentSyntax = CommentSyntax.Markdown,
    sourceLinks: List[String] = Nil,
    revision: Option[String] = None,
    externalMappings: List[ExternalDocLink] = Nil,
    socialLinks: List[SocialLinks] = Nil,
    identifiersToSkip: List[String] = Nil,
    regexesToSkip: List[String] = Nil,
    rootDocPath: Option[String] = None,
    documentSyntheticTypes: Boolean = false,
  )

  def run(args: Array[String], rootContext: CompilerContext): Reporter =
    val (parsedArgsOrNone, ctx) = extract(args, rootContext)

    parsedArgsOrNone.map { parsedArgs =>
      given CompilerContext = ctx

      def listTastyFiles(f: File): Seq[File] =
        val (files, dirs) = Option(f.listFiles()).toArray.flatten.partition(_.isFile)
        ArraySeq.unsafeWrapArray(
          files.filter(_.getName.endsWith(".tasty")) ++ dirs.flatMap(listTastyFiles)
        )
      val tastyFiles = parsedArgs.tastyFiles ++ parsedArgs.tastyDirs.flatMap(listTastyFiles)

      if !ctx.reporter.hasErrors then
        val updatedArgs = parsedArgs.copy(tastyDirs = Nil, tastyFiles = tastyFiles)

        if (parsedArgs.output.exists()) util.IO.delete(parsedArgs.output)

        run(updatedArgs)
        report.inform("Done")
      else report.error("Failure")

    }
    ctx.reporter


  def extract(args: Array[String], rootCtx: CompilerContext): (Option[Scaladoc.Args], CompilerContext) =
    val newContext = rootCtx.fresh
    given CompilerContext = newContext
    val ss = ScaladocSettings()
    import ss._
    val summary = ScaladocCommand.distill(args, ss)()
    val argumentFilesOrNone = ScaladocCommand.checkUsage(summary, true)(using ss)(using summary.sstate)

    extension[T](arg: Setting[T])
      def get = arg.valueIn(summary.sstate)
      def withDefault(default: => T) =
        if arg.get == arg.default then default else arg.get
      def nonDefault =
        if arg.get == arg.default then None else Some(arg.get)

    def setInGlobal[T](s: Setting[T]) =
      s.nonDefault.foreach { newValue =>
        newContext.settings.allSettings.find(_ == s).fold(
          report.warning(s"Unable to set ${s.name} in global context")
        )(s => newContext.setSetting(s.asInstanceOf[Setting[T]], newValue))
      }

    allSettings.filterNot(scaladocSpecificSettings.contains).foreach(setInGlobal)

    def parseTastyRoots(roots: String) =
      roots.split(File.pathSeparatorChar).toList.map(new File(_))

    argumentFilesOrNone.fold((None, newContext)) { argumentFiles =>
      val inFiles = argumentFiles.map(File(_)).filter(_.getName != "___fake___.scala")
      val (existing, nonExisting) = inFiles.partition(_.exists)

      if nonExisting.nonEmpty then report.warning(
        s"scaladoc will ignore following non-existent paths: ${nonExisting.mkString(", ")}"
      )

      val (dirs, files) = existing.partition(_.isDirectory)
      val (validFiles, other) = files.partition(f =>
        f.getName.endsWith(".tasty") || f.getName.endsWith(".jar")
      )

      if other.nonEmpty then report.warning(
        s"scaladoc suports only .tasty and .jar files, following files will be ignored: ${other.mkString(", ")}"
      )

      def defaultDest(): File =
        report.warning("Destination is not provided, please provide '-d' parameter pointing to directory where docs should be created")
        File("output")

      val parseSyntax: CommentSyntax = syntax.nonDefault.fold(CommentSyntax.default){ str =>
        CommentSyntax.parse(str).getOrElse{
          report.error(s"unrecognized value for -syntax option: $str")
          CommentSyntax.default
        }
      }
      val externalMappings =
        externalDocumentationMappings.get.flatMap( s =>
            ExternalDocLink.parse(s).fold(left => {
              report.warning(left)
              None
            }, right => Some(right)
          )
        )

      val socialLinksParsed =
        socialLinks.get.flatMap { s =>
          SocialLinks.parse(s).fold(left => {
            report.warning(left)
            None
          },right => Some(right))
        }

      unsupportedSettings.filter(s => s.get != s.default).foreach { s =>
        report.warning(s"Setting ${s.name} is currently not supported.")
      }
      val destFile = outputDir.nonDefault.fold(defaultDest())(_.file)
      val printableProjectName = projectName.nonDefault.fold("")("for " + _ )
      report.inform(
        s"Generating documenation $printableProjectName in $destFile")

      if deprecatedSkipPackages.get.nonEmpty then report.warning(deprecatedSkipPackages.description)

      val docArgs = Args(
        projectName.withDefault("root"),
        dirs,
        validFiles,
        classpath.get,
        destFile,
        siteRoot.nonDefault,
        projectVersion.nonDefault,
        projectLogo.nonDefault,
        parseSyntax,
        sourceLinks.get,
        revision.nonDefault,
        externalMappings,
        socialLinksParsed,
        skipById.get ++ deprecatedSkipPackages.get,
        skipByRegex.get,
        docRootContent.nonDefault,
        YdocumentSyntheticTypes.get
      )
      (Some(docArgs), newContext)
    }

  private [scaladoc] def run(args: Args)(using ctx: CompilerContext): DocContext =
    given docContext: DocContext = new DocContext(args, ctx)
    val module = ScalaModuleProvider.mkModule()

    new dotty.tools.scaladoc.renderers.HtmlRenderer(module.rootPackage, module.members).render()
    report.inform("generation completed successfully")
    docContext
