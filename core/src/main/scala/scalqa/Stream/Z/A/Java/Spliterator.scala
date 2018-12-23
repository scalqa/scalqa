package scalqa; package Stream; package Z; package A; package Java

import java.{ util => J }

private[scalqa] class Spliterator[A](protected val all: ~[A], protected val splitSize: Int) extends J.Spliterator[A] {

  def characteristics = J.Spliterator.SUBSIZED | all.sizeOpt.map(_ => J.Spliterator.SIZED).or(0)

  def estimateSize = all.sizeOpt.map(_.toLong) or scala.Long.MaxValue

  @inline final def tryAdvance(f: J.function.Consumer[_ >: A]): Boolean = if (all.prime) { f.accept(all.pump); true } else false

  def trySplit = if (splitSize <= 0) null else {
    val s = all.take(splitSize)
    if (s.prime) new Spliterator(s, 0) else null
  }
}

private[scalqa] object Spliterator {

  def toStream[A](src: J.Spliterator[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream.A.Base[A] with J.function.Consumer[A] with Any.Able.Stream[A] {
    protected var has = false
    protected var value: A = _

    @inline final def prime = has || { has = src.tryAdvance(this); has }

    @inline final def pump = { has = false; value }

    override def foreach(c: Consumer[A]) = if (prime) { c.accept(pump); while (src.tryAdvance(this)) c.accept(value) }

    override def ilkOpt = i.ilkOpt

    @inline final def accept(v: A): Unit = value = v

    @inline final def all = this
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
