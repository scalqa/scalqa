package scalqa; package J; package Path

class _Class private[Path] (val real: java.nio.file.Path) extends AnyVal with _root with _names with _fileOrDirectory with _io with _subpath with _evaluate with _build with _rest with Able.Void {

  protected override def isVoid = size == 0 && !rootOpt

}

object _Class extends Able.Void.Companion[_Class](new _Class(java.nio.file.FileSystems.getDefault.getPath(""))) {

  import scala.language.implicitConversions

  implicit def zzGet(v: java.nio.file.Path): Path = new Path(v)

  implicit def zzGet(v: String): Path = get(v)

  implicit def zzGet(v: ~[String]): Path = get(v)

  implicit def zzGet(v: J.File): Path = v.path

  implicit def zzGet(v: J.File.Directory): Path = v.path

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   [[J.Path]] represents a directory or file in the [[File.System]], which may or may not exist
 *
 *   [[Path]] implements [[Index Index[String]]], representing directory names hierarchy. The last name may be a name of file, if [[Path]] is for file
 *
 *   [[Path]] may or may not have root (like C:\). This may be checked with [[_root.rootOpt rootOpt]]
 *
 *   A void [[Path]] has no root and zero directories
 *
 *   Naturally, a 'rootless' path can be added to another path in order to extend it
 *
 *   Path with a root can only be extended itself
 *
 *   {{{
 *       val p1 = J.Path.get("aaa", "bbb").rootMake
 *
 *       val p2 = J.Path.get("ccc", "ddd")
 *
 *       p1 lp               // Prints: C:\aaa\bbb
 *
 *       p2 lp               // Prints: ccc\ddd
 *
 *       p1 + p2 + "xyz" lp  // Prints: C:\aaa\bbb\ccc\ddd\xyz
 *
 *       p2 + p1             // Fail\$Message: Cannot extend with root: C:\aaa\bbb
 *   }}}
 *
 */
