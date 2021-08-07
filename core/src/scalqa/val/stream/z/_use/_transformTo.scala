package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

import java.{ util as J }

object _transformTo:

  class Seq[A](s: ~[A]) extends scala.collection.AbstractSeq[A] with scala.collection.immutable.IndexedSeq[A]:
    private val b = s.toBuffer
    def apply(i: Int) = b(i)
    val length = b.size

  private[scalqa] class Iterator[A](s: ~[A]) extends scala.collection.AbstractIterator[A]:
    private  var cv : Opt[A] = \/
    /**/     def hasNext                                  = cv.nonEmpty || { cv = s.read_?; cv.nonEmpty}
    /**/     def next                                     = if (hasNext) { val v = cv.get; cv = \/; v} else throw ZZ.EO()
    override def knownSize                                = s.size_? or -1
    override def toList                                   = {var l: scala.List[A] = Nil; s.foreach(v => l = l :+ v); l }
    override def toArray[B >: A]   (using t: ClassTag[B]) = s.cast[~[B]].toArray
    override def toSeq                                    = new Seq(s)
    override def toIndexedSeq                             = new Seq(s)

  class JavaIterator[A](v: ~[A]) extends J.Iterator[A]:
    var o: Opt[A] = \/
    def hasNext = o.nonEmpty || { o = v.read_?; o.nonEmpty }
    def next    = if (hasNext) { val v = o.get; o = \/; v } else throw ZZ.EO()

  class JavaEnumeration[A](v: ~[A]) extends J.Enumeration[A]:
    var o : Opt[A] = \/
    def hasMoreElements = o.nonEmpty || { o = v.read_?; o.nonEmpty}
    def nextElement     = if (hasMoreElements) { val v = o.get; o = \/; v} else throw ZZ.EO()

  class JavaSpliterator[A](s: ~[A], protected val splitSize: Int) extends J.Spliterator[A]:
    def characteristics                            : Int              = J.Spliterator.SUBSIZED | s.sizeLong_?.map(_ => J.Spliterator.SIZED).or(0)
    def estimateSize                               : Long             = s.sizeLong_? or MAX
    def tryAdvance(f: J.function.Consumer[_ >: A]) : Boolean          = s.read_?.forval(f.accept)
    def trySplit                                   : J.Spliterator[A] = if (splitSize <= 0) null else { val p = s.read_~(splitSize); if (p.isEmpty) null else new JavaSpliterator(p, 0) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
