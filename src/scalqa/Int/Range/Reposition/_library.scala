package scalqa; package Int; package Range; package Reposition

class _library private[Reposition] (protected val This: Reposition) extends AnyVal {

  def apply(i: Int) = This.range.I.to(r => if (!r.contains(i)) i else This.indexes(i - r.start))

  def allPairs: ~[(Int, Int)] = This.indexes.all.mapIdx((_, _), This.range.start).let(_.to(_ != _))

  def extend(r: Range): Reposition = Z.extend(This, r)

  def validate: Unit = Z.validate(This)

  def apply[T](l: Index.W[T]): Unit = apply(l, l.replaceAt)

  def apply[T](l: Index[T], update: (Int, T) => Any): Unit = l.all.letAt(This.range).to[Index].I.to(l => This.indexes.all.applyIdx((i, j) => update(j, l(i))))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
