package scalqa; package J; package Path

trait _root extends Any with __ {

  def rootOpt: Opt[Path] = real.getRoot.Opt.map(new Path(_))

  def root: Path = rootOpt.value

  def rootMake: Path = rootOpt.swap(This) or get.root + This

  def rootDrop: Path = rootOpt.swap[Path](real.subpath(0, real.getNameCount)) or This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def rootOpt -> Optional root
 *
 *     Optionally returns root [[Path]] if available
 *     {{{
 *       val p = J.Path.get("aaa" ~ "bbb").rootMake
 *
 *       p.rootOpt lp          // May Print: Opt(C:\)
 *
 *       p.rootDrop.rootOpt lp //    Prints: Opt.Void
 *     }}}
 *
 * @def root: -> Root path
 *
 *     Returns root [[Path]]
 *
 *     Note: Fails if no root available
 *     {{{
 *        J.Path.get.root lp // May Print: C:\
 *     }}}
 *
 * @def rootMake -> Makes root if none
 *
 *     If ''this'' [[Path]] has no root, new [[Path]] with current root is returned
 *
 *     Otherwise ''this'' [[Path]] is returned as is
 *     {{{
 *       val p: J.Path = "aaa" ~ "bbb"
 *
 *       p lp           // May Print: aaa\bbb
 *
 *       p.rootMake lp  // May Print: C:\aaa\bbb
 *     }}}
 *
 * @def rootDrop -> Looses root if any
 *
 *     If ''this'' [[Path]] has a root, new [[Path]] without root is returned
 *
 *     Otherwise ''this'' [[Path]] is returned as is
 *     {{{
 *       val p = J.Path.get("aaa" ~ "bbb").rootMake
 *
 *       p lp           // May Print: C:\aaa\bbb
 *
 *       p.rootDrop lp  // May Print: aaa\bbb
 *    }}}
 */
