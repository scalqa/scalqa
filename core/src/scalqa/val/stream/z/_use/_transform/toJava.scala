package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions

import java.{ util as J }

object toJava:

  class Iterator[A](v: Stream[A]) extends J.Iterator[A]:
    private var o: Opt[A]=VOID
    def hasNext           = o || { o = v.readOpt; o }
    def next              = if (hasNext) { val v = o.get; o=VOID; v } else throw ZZ.EO()

  class Enumeration[A](v: Stream[A]) extends J.Enumeration[A]:
    private var o: Opt[A]=VOID
    def hasMoreElements   = o || { o = v.readOpt; o}
    def nextElement       = if (hasMoreElements) { val v = o.get; o=VOID; v} else throw ZZ.EO()

  class Spliterator[A](s: Stream[A], protected val splitSize: Int) extends J.Spliterator[A]:
    def characteristics                            : Int              = J.Spliterator.SUBSIZED | s.sizeLongOpt.map(_ => J.Spliterator.SIZED).or(0)
    def estimateSize                               : Long             = s.sizeLongOpt or MAX
    def tryAdvance(f: J.function.Consumer[_ >: A]) : Boolean          = s.readOpt.forval(f.accept)
    def trySplit                                   : J.Spliterator[A] = if (splitSize <= 0) null else { val p = s.readStream(splitSize); if (p.isEmpty) null else new Spliterator(p, 0) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
