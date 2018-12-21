package scalqa; package Idx; package M

trait _library[A, IdxW <: M[A]] extends Any with Idx._library[A] with Any.Able.Sort[A, IdxW] with Any.Wrap[IdxW] {

  def asBiMappedView[B](m: BiMap[A, B]): M[B] = new Z.A.BiMappedView[A, B](real, m)

  def asBiMappedView[B](m: A => B, u: B => A): M[B] = asBiMappedView(BiMap(m, u))

  def sort(implicit o: Ordering[A]) = { real.order(o); real }

  def update(i: Int, v: A) = real.update(i, v)

  def replaceFor(filter: Stream.Filter[A], value: A): Int = { var cnt = 0; real.all.foreachIdx((i, v) => if (filter.allow(v)) { cnt += 1; real.update(i, value) }); cnt }

  def replaceForOrElseAdd(filter: Stream.Filter[A], value: A): Int = replaceFor(filter, value).I(c => if (c == 0) real.add(value))

  def removeFor(filter: Stream.Filter[A]): Int = { var cnt = 0; real.size.all.reverse.foreach(i => if (filter.allow(real(i))) { cnt += 1; real.removeAt(i) }); cnt }

  override def asSynchronizedView(lockOpt: Opt[AnyRef] = \/): M[A] = new Z.A.Synchronized(real, lockOpt)

}
object _library {

  class _Class[A, IndexW <: M[A]] private[M] (protected val real: IndexW) extends AnyVal with _library[A, IndexW]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
