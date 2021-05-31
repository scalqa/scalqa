package dotty.tools.scaladoc

import java.nio.file.{Path, Paths}

case class PathBased[T](entries: List[PathBased.Entry[T]], projectRoot: Path):
  def get(path: Path): Option[PathBased.Result[T]] =
    if path.isAbsolute then
      if path.startsWith(projectRoot) then get(projectRoot.relativize(path))
      else None
    else entries.find(_.path.forall(p => path.startsWith(p))).map(entry =>
      PathBased.Result(entry.path.fold(path)(_.relativize(path)), entry.elem)
    )

trait ArgParser[T]:
  def parse(s: String): Either[String, T]

object PathBased:
  case class Entry[T](path: Option[Path], elem: T)
  case class ParsingResult[T](errors: List[String], result: PathBased[T])
  case class Result[T](path: Path, elem: T)

  private val PathExtractor = "([^=]+)=(.+)".r


  def parse[T](args: Seq[String], projectRoot: Path = Paths.get("").toAbsolutePath())(using parser: ArgParser[T]): ParsingResult[T] = {
    val parsed = args.map {
      case PathExtractor(path, arg) => parser.parse(arg).map(elem => Entry(Some(Paths.get(path)), elem))
      case arg => parser.parse(arg).map(elem => Entry(None, elem))
    }
    val errors = parsed.collect {
      case Left(error) => error
    }.toList

    val entries = parsed.collect {
      case Right(entry) => entry
    }.toList

    ParsingResult(errors, PathBased(entries, projectRoot))
  }