package scalqa; package Range

trait _evaluate[A] extends Any with __[A] {

  def contains(a: A): Boolean = startContains(a) && endContains(a)

  // Checking endContains first for the benefit of (A <>>!) ranges
  def contains(that: Range[A]): Boolean = endContains(that.end, that.endExclusive) && startContains(that.start, that.startExclusive)

  def overlapOpt(that: Range[A]): Opt[THIS] =
    if (this.isVoid || that.isVoid)
      \/
    else if (this.startContains(that.start, that.startExclusive))
      if (!this.endContains(that.start, that.startExclusive)) \/
      else if (this.endContains(that.end, that.endExclusive)) _get(that)
      else _get(that.start, that.startExclusive, this.end, this.endExclusive)
    else {
      if (!that._endContains(this.start, this.startExclusive)) \/
      else if (that._endContains(this.end, this.endExclusive)) This
      else _get(this.start, this.startExclusive, that.end, that.endExclusive)
    }

  def join(that: Range[A]): THIS =
    if (that.isVoid) This
    else if (this.isVoid) _get(that)
    else if (this.startContains(that.start, that.startExclusive))
      if (this.endContains(that.end, that.endExclusive)) This
      else this._get(this.start, this.startExclusive, that.end, that.endExclusive)
    else if (that._endContains(this.end, this.endExclusive)) _get(that)
    else this._get(that.start, that.startExclusive, this.end, this.endExclusive)

  def extendTo(a: A): THIS =
    if (a.isVoid) This
    else if (this.isVoid) _get(a, false, a, false).cast
    else if (!_startContains(a)) _get(a, false, end, endExclusive)
    else if (!_endContains(a)) _get(start, startExclusive, a, false)
    else This

  def map[B](m: A => B)(implicit s: Sorting[B], t: Tag[B] = \/) = Range.getGeneral[B](m(start), startExclusive, m(end), endExclusive)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def map -> Mapped Range
 *
 *   Creates range with mapped values
 *   {{{
 *     (1 <>> 5) map (_ * 100) lp  // Prints: 100 <>> 500
 *   }}}
 *
 * @def contains(a -> Check if within
 *
 *   Returns true if ''this'' range contains specified value
 *   {{{
 *     1 <> 9 contains 3 lp // Prints: true
 *   }}}
 *
 * @def contains(that -> Check if within
 *
 *   Returns true if ''this'' range contains ''that'' range
 *   {{{
 *     1 <> 9 contains 3 <> 7 lp // Prints: true
 *
 *     1 <> 5 contains 3 <> 7 lp // Prints: false
 *   }}}
 *
 * @def overlapOpt -> Optional intersection
 *
 *   Optionally returns common intersection of ''this'' and ''that''
 *   {{{
 *     1 <> 6 overlapOpt 3 <> 9 lp  // Prints: Opt(3 <>> 7)
 *
 *     1 <> 3 overlapOpt 6 <> 9 lp  // Prints: Opt.Void
 *   }}}
 *
 * @def join -> Union
 *
 *   Returns range with out-most reaches of ''this'' and ''that''
 *   {{{
 *     'A' <> 'C' join 'X' <> 'Z'.lp  // Prints: A <> Z
 *   }}}
 *
 * @def extendTo -> Expand
 *
 *   ''This'' range is extended to contain the specified value
 *   {{{
 *     'A' <> 'C' extendTo 'G' lp // Prints: A <> G
 *
 *     'A' <> 'C' extendTo 'B' lp // Prints: A <> C
 *   }}}
 */
