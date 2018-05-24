package scalqa; package J; package Path

trait _subpath extends Any with Able.Copy.Range[_Class] with __ {

  def parent: Path = real.getParent

  def copyFrom(that: Path, default: Path = \/): Path = indexOpt(that).map(copyFrom) orOpt default.Opt or This

  def copyAfter(that: Path, default: Path = \/): Path = indexOpt(that).map(_ + that.size).map(copyFrom) orOpt default.Opt or This

  def copyBefore(that: Path, default: Path = \/): Path = indexOpt(that).map(copyFirst) orOpt default.Opt or This

  protected def _copy(r: Int.Range): Path = if (rootOpt.isVoid || r.start > 0) real.subpath(r.start, r.end) else (size - r.end).all.foldAs[java.nio.file.Path](real, (that, i) => that.getParent)

  protected def _copyDrop(r: Int.Range): Path = copyFirst(r.start) + copyFrom(r.end)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def copyAfter -> Sub-path after
 *
 *     Returns sub-path after ''that''
 *
 *     @param that sub-path to copy after
 *     @param default path if ''that'' is not found. If not specified, default is the original path
 *     {{{
 *       val p: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd" ~ "eee" ~ "fff"
 *
 *       p lp                                           // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyAfter "ccc" ~ "ddd" lp                   // Prints: eee\fff
 *
 *       p copyAfter "ddd" ~ "ccc" lp                   // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyAfter ("ddd" ~ "ccc", "xyz" ~ "bbc") lp  // Prints: xyz\bbc
 *    }}}
 *
 * @def copyBefore -> Sub-path before
 *
 *     Returns sub-path from start to ''that''
 *
 *     @param that sub-path to copy up to
 *     @param default path if ''that'' is not found. If not specified, default is the original path
 *
 *     {{{
 *       val p: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd" ~ "eee" ~ "fff"
 *
 *       p lp                                            // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyBefore "ccc" ~ "ddd" lp                   // Prints: aaa\bbb
 *
 *       p copyBefore "ddd" ~ "ccc" lp                   // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyBefore ("ddd" ~ "ccc", "xyz" ~ "bbc") lp  // Prints: xyz\bbc
 *    }}}
 *
 * @def copyFrom -> Sub-path from
 *
 *     Returns sub-path starting from specified [[Path]]
 *
 *     @param that sub-path to copy from
 *     @param default path if ''that'' is not found. If not specified, default is the original path
 *
 *     {{{
 *       val p: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd" ~ "eee" ~ "fff"
 *
 *       p lp                                         // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyFrom "ccc" ~ "ddd" lp                  // Prints: ccc\ddd\eee\fff
 *
 *       p copyFrom "ddd" ~ "ccc" lp                  // Prints: aaa\bbb\ccc\ddd\eee\fff
 *
 *       p copyFrom ("ddd" ~ "ccc", "xyz" ~ "bbc") lp // Prints: xyz\bbc
 *    }}}
 *
 * @def parent -> Parent [[Path]]
 *
 *     Returns parent [[Path]] of ''this'' [[Path]]
 *
 *     {{{
 *        val p: J.Path = "aaa" ~ "bbb" ~ "ccc"
 *
 *        p.parent lp  // Prints: aaa\bbb
 *     }}}
 */
