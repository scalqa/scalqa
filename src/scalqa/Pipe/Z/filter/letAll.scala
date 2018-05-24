package scalqa; package Pipe; package Z; package filter

private[Pipe] object letAll {

  def apply[A](src: Pipe[A], filter: Pipe[A])(implicit srt: Sorting[A]): Pipe[A] = applyBy[A, A](src, src.sortingOpt, a => a, filter)

  def by[A, B](src: Pipe[A], map: A => B, filter: Pipe[B])(implicit srt: Sorting[B]): Pipe[A] = applyBy[A, B](src, src.sortingByOpt[B].map(_._1), map, filter)

  private def applyBy[A, B](src: Pipe[A], ssOpt: Opt[Sorting[B]], fun: A => B, filter: Pipe[B])(implicit srt: Sorting[B]): Pipe[A] =
    if (filter.sizeOpt.contains(0)) \/
    else if (ssOpt.contains(srt)) {
      // ****************************************************************************
      object SortedMerge extends The.Build[A] {
        def real = src
        var oo: Opt[Opt[B]] = \/
        override def pumpOpt(f: A ⇒ Boolean): Opt[A] = {
          if (!oo) oo = filter.pumpOpt(EVERY)
          var fo: Opt[B] = oo.value
          fo.letMap(_ => src.pumpOpt(a => {
            val v = fun(a)
            if (srt(fo.value, v).isAsIs) { fo = filter.pumpOpt(srt(v, _).isNotInverse); oo = fo }
            !fo || fo.contains(v) && f(a)
          }).letIf(fo))
        }
        override def sortingOpt = src.sortingOpt
        override def sizeOpt = \/
      }
      SortedMerge
    } else filter.as[Array].I.to(a =>
      if (a.size < 5 || srt.isVoid) {
        // ****************************************************************************
        object SimpleSearch extends let[A](src, v => a.contains(fun(v)))
        SimpleSearch
      } else {
        val sa = a.sort(srt);
        // ****************************************************************************
        object OrderedSearch extends let[A](src, v => sa.searchOrdered(fun(v)).size > 0)
        OrderedSearch
      })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
