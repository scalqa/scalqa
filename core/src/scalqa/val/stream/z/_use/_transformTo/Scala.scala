package scalqa; package `val`; package stream; package z; package _use; package _transformTo; import language.implicitConversions

object Scala:

  def Array[A](x: ~[A])(using ClassTag[A]) : Array[A] =
    val b = Buffer.accessible(x.size_? or J.initSize).^(_ ++= x)
    var a: Array[A] = b.access
    if(a.length!=b.size) a = a.copySize(b.size)
    a.cast[Array[A]]

  def List[A](x: ~[A]): List[A] =
    var l: List[A] = Nil
    x.FOREACH(v => l = l :+ v)
    l

  def Vector[A](x: ~[A]): Vector[A] =
    var b = new scala.collection.immutable.VectorBuilder[A]()
    x.FOREACH(b += _)
    b.result

  def Product[A](x: ~[A]): Product = x.><.toProduct_^

  class Seq[A](s: ~[A]) extends scala.collection.AbstractSeq[A] with scala.collection.immutable.IndexedSeq[A]:
    private val b = s.toBuffer
    def apply(i: Int) = b(i)
    val length = b.size

  class Iterator[A](s: ~[A]) extends scala.collection.AbstractIterator[A]:
    private  var cv : Opt[A] = \/
    /**/     def hasNext                                  = cv.nonEmpty || { cv = s.read_?; cv.nonEmpty}
    /**/     def next                                     = if (hasNext) { val v = cv.get; cv = \/; v} else throw ZZ.EO()
    override def knownSize                                = s.size_? or -1
    override def toList                                   = {var l: scala.List[A] = Nil; s.foreach(v => l = l :+ v); l }
    override def toArray[B >: A]   (using t: ClassTag[B]) = s.cast[~[B]].toArray
    override def toSeq                                    = new Seq(s)
    override def toIndexedSeq                             = new Seq(s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
