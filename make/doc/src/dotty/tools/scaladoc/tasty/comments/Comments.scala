package dotty.tools.scaladoc
package tasty.comments

import scala.collection.immutable.SortedMap
import scala.util.Try

import com.vladsch.flexmark.util.{ast => mdu}
import com.vladsch.flexmark.{ast => mda}
import com.vladsch.flexmark.formatter.Formatter
import com.vladsch.flexmark.util.options.MutableDataSet

import scala.quoted._
import dotty.tools.scaladoc.tasty.comments.wiki.Paragraph
import dotty.tools.scaladoc.DocPart
import dotty.tools.scaladoc.tasty.SymOps
import collection.JavaConverters._

class Repr(val qctx: Quotes)(val sym: qctx.reflect.Symbol)

case class Comment (
  body:                    DocPart,
  short:                   Option[DocPart],
  authors:                 List[DocPart],
  see:                     List[DocPart],
  result:                  Option[DocPart],
  throws:                  SortedMap[String, DocPart],
  valueParams:             SortedMap[String, DocPart],
  typeParams:              SortedMap[String, DocPart],
  version:                 Option[DocPart],
  since:                   Option[DocPart],
  todo:                    List[DocPart],
  deprecated:              Option[DocPart],
  note:                    List[DocPart],
  example:                 List[DocPart],
  constructor:             Option[DocPart],
  group:                   Option[String],
  // see comment in PreparsedComment below regarding these
  groupDesc:               SortedMap[String, DocPart],
  groupNames:              SortedMap[String, DocPart],
  groupPrio:               SortedMap[String, Int],
  /** List of conversions to hide - containing e.g: `scala.Predef.FloatArrayOps` */
  hideImplicitConversions: List[DocPart]
)

case class PreparsedComment(
  body:                    String,
  authors:                 List[String],
  see:                     List[String],
  result:                  List[String],
  throws:                  SortedMap[String, String],
  valueParams:             SortedMap[String, String],
  typeParams:              SortedMap[String, String],
  version:                 List[String],
  since:                   List[String],
  todo:                    List[String],
  deprecated:              List[String],
  note:                    List[String],
  example:                 List[String],
  constructor:             List[String],
  group:                   List[String],
  // NOTE these don't need to be sorted in principle, but code is nicer if they are
  groupDesc:               SortedMap[String, String],
  groupNames:              SortedMap[String, String],
  groupPrio:               SortedMap[String, Int],
  hideImplicitConversions: List[String],
  shortDescription:        List[String],
  syntax:                  List[String],
)

case class DokkaCommentBody(summary: Option[DocPart], body: DocPart)

abstract class MarkupConversion[T](val repr: Repr)(using DocContext) {
  protected def stringToMarkup(str: String): T
  protected def markupToDokka(t: T): DocPart
  protected def markupToString(t: T): String
  protected def markupToDokkaCommentBody(t: T): DokkaCommentBody
  protected def filterEmpty(xs: List[String]): List[T]
  protected def filterEmpty(xs: SortedMap[String, String]): SortedMap[String, T]

  val qctx: repr.qctx.type = if repr == null then null else repr.qctx // TODO why we do need null?
  val owner: qctx.reflect.Symbol =
    if repr == null then null.asInstanceOf[qctx.reflect.Symbol] else repr.sym

  object SymOps extends SymOps[qctx.type](qctx)
  export SymOps.dri
  export SymOps.driInContextOfInheritingParent

  def resolveLink(queryStr: String): DocLink =
    if SchemeUri.matches(queryStr) then DocLink.ToURL(queryStr)
    else QueryParser(queryStr).tryReadQuery() match
      case Left(err) =>
        // TODO convert owner.pos to get to the comment, add stack trace
        report.warning(s"Unable to parse query `$queryStr`: ${err.getMessage}")
        val msg = s"Unable to parse query: ${err.getMessage}"
        DocLink.UnresolvedDRI(queryStr, msg)
      case Right(query) =>
        MemberLookup.lookup(using qctx)(query, owner) match
          case Some((sym, targetText, inheritingParent)) =>
            var dri = inheritingParent match
              case Some(parent) => sym.driInContextOfInheritingParent(parent)
              case None => sym.dri
            DocLink.ToDRI(dri, targetText)
          case None =>
            val txt = s"No DRI found for query"
            val msg = s"$txt: $queryStr"
            // TODO change to the commented-out version when we'll get rid of the warnings in stdlib
            // report.warning(
            //   msg,
            //   owner.pos.get.asInstanceOf[dotty.tools.dotc.util.SrcPos],
            // )
            report.inform(msg)
            DocLink.UnresolvedDRI(queryStr, txt)

  private val SchemeUri = """[a-z]+:.*""".r

  private def single(annot: String, xs: List[String], filter: Boolean = true): Option[T] =
    (if (filter) filterEmpty(xs) else xs.map(stringToMarkup)) match {
      case x :: xs =>
        Some(x)
      case _ => None
    }

  final def parse(preparsed: PreparsedComment): Comment =
    val body = markupToDokkaCommentBody(stringToMarkup(preparsed.body))
    Comment(
      body                    = body.body,
      short                   = body.summary,
      authors                 = filterEmpty(preparsed.authors).map(markupToDokka),
      see                     = filterEmpty(preparsed.see).map(markupToDokka),
      result                  = single("@result", preparsed.result).map(markupToDokka),
      throws                  = filterEmpty(preparsed.throws).view.mapValues(markupToDokka).to(SortedMap),
      valueParams             = filterEmpty(preparsed.valueParams).view.mapValues(markupToDokka).to(SortedMap),
      typeParams              = filterEmpty(preparsed.typeParams).view.mapValues(markupToDokka).to(SortedMap),
      version                 = single("@version", preparsed.version).map(markupToDokka),
      since                   = single("@since", preparsed.since).map(markupToDokka),
      todo                    = filterEmpty(preparsed.todo).map(markupToDokka),
      deprecated              = single("@deprecated", preparsed.deprecated, filter = false).map(markupToDokka),
      note                    = filterEmpty(preparsed.note).map(markupToDokka),
      example                 = filterEmpty(preparsed.example).map(markupToDokka),
      constructor             = single("@constructor", preparsed.constructor).map(markupToDokka),
      group                   = single("@group", preparsed.group).map(markupToString),
      groupDesc               = filterEmpty(preparsed.groupDesc).view.mapValues(markupToDokka).to(SortedMap),
      groupNames              = filterEmpty(preparsed.groupNames).view.mapValues(markupToDokka).to(SortedMap),
      groupPrio               = preparsed.groupPrio,
      hideImplicitConversions = filterEmpty(preparsed.hideImplicitConversions).map(markupToDokka)
    )
}

class MarkdownCommentParser(repr: Repr)(using DocContext)
    extends MarkupConversion[mdu.Node](repr) {

  def stringToMarkup(str: String) =
    MarkdownParser.parseToMarkdown(str, markdown.DocFlexmarkParser(resolveLink))

  def markupToString(t: mdu.Node): String = t.toString()

  def markupToDokka(md: mdu.Node): DocPart = md

  def markupToDokkaCommentBody(md: mdu.Node) =
    val summary =
      md.getChildIterator.asScala.collectFirst { case p: mda.Paragraph => p }

    DokkaCommentBody(summary, md)

  def filterEmpty(xs: List[String]) = {
    xs.map(_.trim)
      .filterNot(_.isEmpty)
      .map(stringToMarkup)
  }

  def filterEmpty(xs: SortedMap[String,String]) =
    xs.view.mapValues(_.trim)
      .filterNot { case (_, v) => v.isEmpty }
      .mapValues(stringToMarkup).to(SortedMap)
}

class WikiCommentParser(repr: Repr)(using DocContext)
    extends MarkupConversion[wiki.Body](repr):

  def stringToMarkup(str: String) = wiki.Parser(str, resolverLink).document()

  def resolverLink(queryStr: String, bodyOpt: Option[wiki.Inline]): wiki.Inline =
    val link = resolveLink(queryStr)
    wiki.Link(link, bodyOpt)

  // Do we need those?
  private def flatten(b: wiki.Inline): String = b match
    case wiki.Text(t) => t
    case wiki.Italic(t) => flatten(t)
    case wiki.Bold(t) =>flatten(t)
    case wiki.Underline(t) => flatten(t)
    case wiki.Superscript(t) => flatten(t)
    case wiki.Subscript(t) => flatten(t)
    case wiki.Link(_, t) => t.fold("")(flatten)
    case wiki.Monospace(t) => flatten(t)
    case wiki.RepresentationLink(t, _) => flatten(t)
    case wiki.Chain(elems) => elems.headOption.fold("")(flatten)
    case wiki.HtmlTag(t) => t
    case wiki.Summary(t) => flatten(t)

  private def flatten(b: wiki.Block): String = b match
    case wiki.Paragraph(text) => flatten(text)
    case wiki.Title(text, _) => flatten(text)
    case wiki.Code(text) => text
    case wiki.UnorderedList(elems) => elems.headOption.fold("")(flatten)
    case wiki.OrderedList(elems, _) => elems.headOption.fold("")(flatten)
    case wiki.DefinitionList(items) => items.headOption.fold("")(e => flatten(e._1))
    case wiki.HorizontalRule => ""

  def markupToString(str: wiki.Body) = str.blocks.headOption.fold("")(flatten)

  def markupToDokka(body: wiki.Body) = parseBlocks(body.blocks) // TODO

  def parseBlocks(blocks: Seq[wiki.WikiDocElement]) = blocks

  def markupToDokkaCommentBody(body: wiki.Body) =
     DokkaCommentBody(
      summary = body.summary.map(s => parseBlocks(s.blocks)),
      body = parseBlocks(body.blocks),
    )

  def filterEmpty(xs: List[String]) =
    xs.map(stringToMarkup)

  def filterEmpty(xs: SortedMap[String,String]) =
    xs.view.mapValues(stringToMarkup).to(SortedMap)
      .filterNot { case (_, v) => v.blocks.isEmpty }
