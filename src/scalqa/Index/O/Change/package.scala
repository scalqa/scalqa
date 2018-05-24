package scalqa; package Index; package O

package object Change {

  private[scalqa] def projectRangeOpt[A](c: Coll[Change[A]], r: Int.Range): Opt[Coll[Change[A]]] = Z.projectRange.opt(c, r)

  private[scalqa] def transform[A](c: Change[A], range: Int.Range => Int.Range, items: Index[A] => Index[A] = (l: Index[A]) => l, repositionIndexes: Ints => Ints = i => i): Change[A] =
    Z.transform(c, range, items, repositionIndexes)

  private[scalqa] def transformColl[A](c: Coll[Change[A]], range: Int.Range => Int.Range, items: Index[A] => Index[A] = (l: Index[A]) => l, repositionIndexes: Ints => Ints = i => i): Coll[Change[A]] =
    c.all.map(transform(_, range, items, repositionIndexes)).as[Coll]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Change ->
 *
 *     There is no new type for [[Index.O.Change]], it is just a shotcut to [[Coll.O.Change]]
 *
 */
