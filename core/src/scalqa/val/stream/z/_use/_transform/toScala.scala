package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions

object toScala:

  def List[A](x: Stream[A]): List[A] =
    var l: List[A] = Nil
    x.FOREACH(v => l = l :+ v)
    l

  def Vector[A](x: Stream[A]): Vector[A] =
    var b = new scala.collection.immutable.VectorBuilder[A]()
    x.FOREACH(b += _)
    b.result

  def Product[A](x: Stream[A]): Product = x.pack.toProductView

  class Seq[A](s: Stream[A]) extends scala.collection.AbstractSeq[A] with scala.collection.immutable.IndexedSeq[A]:
    private val b = s.toBuffer
    def apply(i: Int) = b(i)
    val length = b.size

  class Iterator[A](s: Stream[A]) extends scala.collection.AbstractIterator[A]:
    private  var cv : Opt[A] = \/
    /**/     def hasNext                                  = cv.nonEmpty || { cv = s.readOpt; cv.nonEmpty}
    /**/     def next                                     = if (hasNext) { val v = cv.get; cv = \/; v} else throw ZZ.EO()
    override def knownSize                                = s.sizeOpt or -1
    override def toList                                   = {var l: scala.List[A] = Nil; s.foreach(v => l = l :+ v); l }
    override def toArray[B >: A]   (using t: ClassTag[B]) = s.cast[Stream[B]].toArray
    override def toSeq                                    = new Seq(s)
    override def toIndexedSeq                             = new Seq(s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
