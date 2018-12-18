package scalqa; package Idx; package Range; package Reposition

class _library private[Reposition] (protected val real: Reposition) extends AnyVal {

  def apply(i: Int) = { val r = real.range; if (!r.contains(i)) i else real.indexes(i - r.start) }

  def allPairs: ~[(Int, Int)] = real.indexes.all.mapIdx((_, _), real.range.start).let(_.to(_ != _))

  def extend(r: Idx.Range): Reposition = Z.extend(real, r)

  def validate: Unit = Z.validate(real)

  def apply[T](l: Idx.M[T]): Unit = apply(l, l.update)

  def apply[T](l: Idx[T], update: (Int, T) => Any): Unit = {
    val nl = l.all.letAt(real.range).to[Idx]
    real.indexes.all.foreachIdx((i, j) => update(j, nl(i)))
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
