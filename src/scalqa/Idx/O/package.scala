package scalqa; package Idx

package object O {
  type Change[A] = Change._Trait[A]

  private[scalqa] def projectRangeOpt[A](c: Idx[Change[A]], r: Idx.Range): Opt[Idx[Change[A]]] = Z.projectRangeOpt(c, r)

  def transform[A](c: Change[A], range: Idx.Range => Idx.Range, items: Idx[A] => Idx[A] = (l: Idx[A]) => l, repositionIndexes: Ints => Ints = i => i): Change[A] =
    Z.transform(c, range, items, repositionIndexes)

  def transformIdx[A](c: Idx[Change[A]], range: Idx.Range => Idx.Range, items: Idx[A] => Idx[A] = (l: Idx[A]) => l, repositionIndexes: Ints => Ints = i => i): Idx[Change[A]] =
    c.all.map(transform(_, range, items, repositionIndexes)).to[Idx]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
