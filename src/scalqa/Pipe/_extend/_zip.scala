package scalqa; package Pipe; package _extend

trait _zip[A] extends __[A] {

  def zip[B](that: ~[B], thisDflt: Opt[A] = \/, thatDflt: Opt[B] = \/): Pipe[(A, B)] = new Z.zip._Class(This, that, thisDflt, thatDflt)

  def zipIdx: Pipe[(Int, A)] = new Z.zip.Idx(This, 0)

  def zipIdx(start: Int): Pipe[(Int, A)] = new Z.zip.Idx(This, start)

  def zipOnly[B](that: ~[B]): Pipe[(A, B)] = new Z.zip.Only[A, B](This, that)

  def zipMap[B](f: A => B): Pipe[(A, B)] = new Z.zip.Map[A, B](This, f)

  def zipNext: Pipe[(A, Opt[A])] = new Z.zip.Next(This)

  def zipPrior: Pipe[(Opt[A], A)] = new Z.zip.Prior(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _zip -> '''Merge Interface'''
 *
 * @def zip[ -> Merge pipe
 *
 *   Merges ''this'' and ''that'' pipes, creating ''Tuples'' for corresponding elements
 *
 *   @param  that the pipe to merge with ''this''
 *   @param  thisDflt if ''this'' [[Pipe]] has fewer elements,  ''thisDflt'' will be used to fill the voids. Fails if ''thisDflt'' is required, but not available
 *   @param  thatDflt if ''that'' [[Pipe]] has fewer elements,  ''thatDflt'' will be used to fill the voids. Fails if ''thatDflt'' is required, but not available
 *
 *   @example
 *   {{{
 *      ('a' <> 'f').all.zip('A' <> 'H', '?', '?').lp
 *
 *      // Output
 *      ~((a,A), (b,B), (c,C), (d,D), (e,E), (f,F), (?,G), (?,H))
 *   }}}
 *
 * @def zipIdx: -> Merge index
 *
 *   Creates a new [[Pipe]] with elements paired with their sequential index, starting at 0
 *
 *   Note:  Index is the first element in the resulting tuples
 *
 *   @example
 *   {{{
 *      ('A' <> 'F').all.zipIdx.lp
 *
 *      // Output
 *      ~((0,A), (1,B), (2,C), (3,D), (4,E), (5,F))
 *   }}}
 *
 * @def zipIdx( -> Merge index
 *
 *   Creates a new [[Pipe]] with elements paired with their sequential index
 *
 *   Note:  Index is the first element in the resulting tuples.
 *
 *   @param start index initial value
 *   @example
 *   {{{
 *       ('A' <> 'F').all.zipIdx('A'.toInt) lp
 *
 *      // Output
 *      ~((65,A), (66,B), (67,C), (68,D), (69,E), (70,F))
 *   }}}
 *
 *
 * @def zipOnly -> Zip only that
 *
 *   Merges ''this'' and ''that'' pipes, creating ''Tuples'' for corresponding elements
 *
 *   If ''that'' pipe runs out of elements to merge, the rest of ''this'' pipe will be discarded too
 *
 *   @example
 *   {{{
 *      (1 <> 100).all.zipOnly('A' <> 'D').lp
 *
 *      // Output
 *      ~((1,A), (2,B), (3,C), (4,D))
 *   }}}
 *
 * @def zipMap -> Merge property
 *
 *   Creates a new [[Pipe]] with elements paired with their property, defined by given function
 *
 *   @example
 *   {{{
 *      ('A' <> 'F').all.zipMap(_.toInt).lp
 *
 *      // Output
 *      ~((A,65), (B,66), (C,67), (D,68), (E,69), (F,70))
 *   }}}
 *
 *
 * @def zipPrior -> Merge with prior
 *
 *   Creates new [[Pipe]] with elements paired with the optional prior element
 *
 *   @example
 *   {{{
 *      (1 <> 5).all.zipPrior.lp
 *
 *      // Output
 *      ~((Void,1), (Opt(1),2), (Opt(2),3), (Opt(3),4), (Opt(4),5))
 *   }}}
 *
 * @def zipNext -> Merge with next
 *
 *   Creates new [[Pipe]] with elements paired with the optional next element
 *
 *   @example
 *   {{{
 *      (1 <> 5).all.zipNext.lp
 *
 *      // Output
 *      ~((1,Opt(2)), (2,Opt(3)), (3,Opt(4)), (4,Opt(5)), (5,Void))
 *   }}}
 */
