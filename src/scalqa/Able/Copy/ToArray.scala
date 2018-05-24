package scalqa; package Able; package Copy

trait ToArray[A] extends Any {

  def copyToArray[B >: A](dest: Array[B], destPos: Int = 0, sourceRangeOpt: Opt[Int.Range] = \/): Unit

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait ToArray -> '''Generic Copy to Array'''
 *
 * @def copyToArray -> Efficient copy
 *
 *     Container specific, efficient way to copy its elements to array
 *
 *     @param dest destination [[Array]]
 *     @param destPos destination [[Array]] position to copy to
 *     @param srcRangeOpt  optional ''this'' range to copy. If void, full range of ''this'' is copied.
 *     @example
 *     {{{
 *       // Generic example
 *       val src:  Array[Char] = ('A' <> 'Z').all.to[Array]
 *       val dest: Array[Char] = Array.get(26)
 *
 *       src.copyToArray(dest, 20, 0 <>> 6)
 *       src.copyToArray(dest, 0, 20 <>> 26)
 *
 *       dest.all.lp
 *       // Output
 *       ~(U, V, W, X, Y, Z,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , A, B, C, D, E, F)
 *     }}}
 */
