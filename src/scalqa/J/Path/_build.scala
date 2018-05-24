package scalqa; package J; package Path

trait _build extends Any with __ with Able.Plus[Any] {
  protected type TARGET = Path
  protected def _target = This

  protected def _plus(v: Any): Path = _plusAny(This, v)

  protected def _plusAll(a: ~[Any], size: Int): Path = a.foldAs[Path](This, _plusAny)

  private def _plusAny(t: Path, a: Any): Path = a.I.as(classOf[Path], v => get(v.toString)).I.to(p =>
    if (t.isVoid) p
    else if (p.rootOpt) Fail("Cannot extend with root: " + p)
    else t.real.resolve(p.real))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _build ->
 *
 *  A String can be implicitly converted to simple [[Path]], so building with Strings is valid:
 *
 *  {{{
 *    val path: J.Path = "aaa" ~ "bbb"
 *
 *    path lp                                          // Prints: aaa\bbb
 *
 *    path + "ccc" + "ddd" lp                          // Prints: aaa\bbb\ccc\ddd
 *
 *    path +~ ('c' <> 'f').all.map(_.toString * 3) lp  // Prints: aaa\bbb\ccc\ddd\eee\fff
 *  }}}
 */
