package scalqa; package Stream; package Z; package A

import java.util.{ stream => J }
import java.util.{ function => JF }

private class ParallelJavaStream[A](private var java: J.Stream[A], var sizeOpt: Opt.Int, var ilkOpt: Opt[Any.Class.Ilk]) extends Flow[A] {

  def isParallel = true

  def let(f: Filter[A]) = { sizeOpt = \/; java = java.filter(new JF.Predicate[A] { def test(a: A) = f.allow(a) }); this }

  def map[B](f: Mapping[A, B])(implicit i: Ilk[B]) = new ParallelJavaStream[B](java.map[B](new JF.Function[A, B] { def apply(a: A) = f(a) }), sizeOpt, i.ilkOpt)

  def flatMap[B](f: Mapping[A, ~[B]])(implicit i: Ilk[B]) = new ParallelJavaStream[B](java.flatMap[B](new JF.Function[A, J.Stream[B]] { def apply(a: A) = f(a).to[J.Stream] }), \/, i.ilkOpt)

  def peek(c: Consumer[A]) = { java = java.peek(new JF.Consumer[A] { def accept(a: A) = c.accept(a) }); this }

  def foreach(c: Consumer[A]) = java.forEach(new JF.Consumer[A] { def accept(a: A) = c.accept(a) })

  def reduceOpt(f: Folding[A]): Opt[A] = java.reduce(new JF.BinaryOperator[A] { def apply(x: A, y: A) = f(x, y) })

  def foldFlowAs[B: Ilk](start: B)(op: Folding.As[B, A], f: Folding[B]): B = java.reduce(
    start,
    new JF.BiFunction[B, A, B] { def apply(b: B, a: A) = { op(b, a) } },
    new JF.BinaryOperator[B] { def apply(x: B, y: B) = f(x, y) })

  def findAnyOpt: Opt[A] = Opt.fromOptional(java.findAny)

  def count: Int = java.count.toInt

}

private[scalqa] object ParallelJavaStream extends (Stream[Any] => Flow[Any]) {

  def apply(stream: Stream[Any]): Flow[Any] = {
    val javaStream: J.Stream[Any] = J.StreamSupport.stream(new Z.A.Java.Spliterator(stream, 1), true)
    new ParallelJavaStream[Any](javaStream, stream.sizeOpt, stream.ilkOpt)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
