package scalqa; package Pipe; package Z; package flow

import java.util.{ function => JF }
import java.util.{ stream => J }

private[scalqa] class ParallelJavaStream[A] private (
    private var java: J.Stream[A],
    private var _sizeOpt: Opt[Int],
    override val tagOpt: Opt[Tag[A]],
    override val isMutable: Boolean) extends Pipe.Flow[A] with Z.FlowWithMetadata[A] {

  override def sizeOpt = _sizeOpt

  def let(f: A ⇒ Boolean): Flow[A] = { _sizeOpt = \/; java = java.filter(new JF.Predicate[A] { def test(a: A) = f(a) }); this }

  def map[B](f: A => B): Flow[B] = new ParallelJavaStream[B](java.map[B](new JF.Function[A, B] { def apply(a: A) = f(a) }), sizeOpt, \/, isMutable)

  def flatMap[B](f: A => ~[B]): Flow[B] = new ParallelJavaStream[B](java.flatMap[B](new JF.Function[A, J.Stream[B]] { def apply(a: A) = f(a).as[J.Stream] }), \/, \/, isMutable)

  def peek(f: A => Any): Flow[A] = { java = java.peek(new JF.Consumer[A] { def accept(a: A) = f(a) }); this }

  def apply(f: A => Any) = java.forEach(new JF.Consumer[A] { def accept(a: A) = f(a) })

  def parallelFindOpt(f: A ⇒ Boolean): Opt[A] = { let(f); java.findAny }

  override def size: Int = metadata.sizeOpt or java.count.toInt

  def foldOpt(f: (A, A) ⇒ A): Opt[A] = java.reduce(new JF.BinaryOperator[A] { def apply(x: A, y: A) = f(x, y) })

  def foldAsOpt[B](start: B, op: (B, A) ⇒ B, f: (B, B) => B): Opt[B] = {
    var bool = false
    val v = java.reduce(start, new JF.BiFunction[B, A, B] { def apply(b: B, a: A) = { bool = true; op(b, a) } }, new JF.BinaryOperator[B] { def apply(x: B, y: B) = f(x, y) })
    if (bool) v else \/
  }
}

private[scalqa] object ParallelJavaStream {

  def get[A](all: Pipe[A], splitSize: Int) = new ParallelJavaStream(J.StreamSupport.stream(new transform.toJava.Spliterator(all, splitSize, false), true), all.sizeOpt, all.tagOpt, all.isMutable)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
