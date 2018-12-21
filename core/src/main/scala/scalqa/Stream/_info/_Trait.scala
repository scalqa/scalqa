package scalqa; package Stream; package _info

trait _Trait[A] extends Flow._info._Trait[A] { self: Stream[A] =>

  final def isParallel = false

  def chainDepth: Int = 1

  def sortedOpt: Opt[Ordering[A]]

  def sortedByOpt[B]: Opt[(Ordering[B], A => B)]

  def toInfoTree: Pro.Info.Tree = new Pro.Info.Tree(toInfo)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Metadata Interface`
 *
 *    Metadata is a static knowledge about data to be delivered
 *
 *    Metadata methods can be called many times, they do not trigger any data movements
 *
 *
 * @def toInfoTree -> Metadata for all transformations
 *
 *     {{{
 *         ('a' <> 'z').all.let(_ > 'X').map(_.toUpper).toInfoTree.lp
 *
 *         // Output
 *         Stream.Z.extend.map.toChar\$Default\$4{ilk=Chars,chainDepth=3,preIterate=333}
 *             Stream.Z.extend.filter.apply\$\$anon\$3{ilk=Chars,chainDepth=2,preIterate=500}
 *                 Number.Z.Range\$mcC\$sp\$\$anon\$2{ilk=Chars,size=26,indexed,chainDepth=1,preIterate=ALL}
 *     }}}
 *
 * @def chainDepth -> Depth of transformations
 *
 *     The original [[Stream]] to the source returns 1, each transformation adds 1 more
 *
 *     {{{
 *       ('a' <> 'z').all.let(_ > 'X').map(_.toUpper).chainDepth.lp // Prints 3
 *     }}}
 *
 *     Note. Some transformations can be optimized, so the returned depth can be lower than expected
 *     {{{
 *       ('a' <> 'z').all.dropNext(3).map(_.toUpper).chainDepth.lp  // Prints 2
 *
 *       // Note: dropNext(3) is a simple cursor movement on indexed stream without additional depth
 *     }}}
 *
 * @def sortedOpt -> Data [Ordering]
 *
 *     Data [Ordering] if elements are sorted
 *
 * @def sortedByOpt -> Data [Ordering]
 *
 *     Data [Ordering]  and transition function if elements are sorted
 */
