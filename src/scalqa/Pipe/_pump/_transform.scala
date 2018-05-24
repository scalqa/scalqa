package scalqa; package Pipe; package _pump

import scala.language.higherKinds

trait _transform[A] extends Flow._pump._transform[A] with __[A] {

  def nonEmptyOpt: Opt[~[A]] = Z.transform.nonEmptyOpt(This)

  def iterator: Iterator[A] = This.I.as(classOf[Pipe.Iterator[A]], new Z.Iterator(_))

  def toLookup[KEY](f: A => KEY): Lookup[KEY, A] = Z.transform.toLookup(This, f)

  final def as[TARGET[A]](implicit cnv: To[TARGET], tag: Tag[A] = \/): TARGET[A] = toTarget(false)

  final override def to[TARGET[A]](implicit cnv: To[TARGET], tag: Tag[A] = \/): TARGET[A] = toTarget(true)

  protected def toTarget[TARGET[A]](fullyDetached: Boolean)(implicit cnv: To[TARGET], tag: Tag[A] = \/): TARGET[A] = {
    if (cnv.targetClass.isAssignableFrom(This.Class.real) && (!fullyDetached || !This.isMutable)) This.cast
    else if (fullyDetached && cnv.isResultView) cnv(Z.transform.toIndex(This, tag).all, tag)
    else cnv(This, tag)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _transform -> '''Conversion interface'''
 *
 *      '''as''' method might create a 'view' to the underlying data structures, so changing the original source might change the returned data
 *
 *      '''to''' method, on the other hand, might be more expensive, but it guarantees independence of returned data
 *
 * @def toLookup -> Create Lookup
 *
 *       Creates a [[Lookup]] collection out of [[Pipe]] elements
 *
 *       @param f function to create lookup keys
 *
 *       {{{
 *          val l: Lookup[Int, Char] = ('A' <> 'Z').all.toLookup(_.toInt)
 *
 *          l(65).lp   // Prints: A
 *          l(77).lp   // Prints: M
 *          l(90).lp   // Prints: Z
 *       }}}
 *
 * @def nonEmptyOpt -> Non empty option
 *
 *       Optionally returns non empty pipe
 *
 *       If the pipeline has no elements, Opt.Void is returned
 *
 *       {{{
 *         ('A' <> 'D').all.nonEmptyOpt.lp              // Prints: Opt(~(A, B, C, D))
 *
 *         ('A' <> 'D').all.let(NONE).nonEmptyOpt.lp    // Prints: Opt.Void
 *       }}}
 *
 * @def iterator -> As iterator
 *
 *      Returns interface to access pipeline as iterator
 *
 *      Unlike [[Pipe]], all [[Iterator]] methods can be called many times
 *
 *      {{{
 *         val it = ('A' <> 'D').all.iterator
 *
 *         it.nextOpt.lp // Prints: Opt(A)
 *         it.nextOpt.lp // Prints: Opt(B)
 *         it.nextOpt.lp // Prints: Opt(C)
 *         it.nextOpt.lp // Prints: Opt(D)
 *         it.nextOpt.lp // Prints: Opt.Void
 *         it.nextOpt.lp // Prints: Opt.Void
 *         it.nextOpt.lp // Prints: Opt.Void
 *      }}}
 *
 * @def as -> Convert as type
 *
 *     Converts pipeline elements to the specified target type
 *
 *     Implemented conversions are defined in [[Pipe.To]]
 *
 *        - [[Array]]
 *        - [[Array.View.Refs]]
 *        - [[Coll]]
 *        - [[Coll.W]]
 *        - [[Coll.WO]]
 *        - [[Coll.Val]]
 *        - [[Index]]
 *        - [[Index.W]]
 *        - [[Index.WO]]
 *        - [[Index.Val]]
 *        - scala.List
 *        - scala.Seq
 *        - scala.IndexedSeq
 *        - scala.Iterator
 *        - scala.Vector
 *        - scala.collection.mutable.Buffer
 *        - java.util.Collection
 *        - java.util.List
 *        - java.util.Iterator
 *        - java.util.Spliterator
 *        - java.util.stream.Stream
 *
 *     New conversions can easily be implemented by creating implicit object extending [[Pipe.To]]
 *
 *     This operation is similar with 'to' method, with one caveat: it does not guarantee to break the possible link with pipeline source
 *
 *     If source is immutable, then 'no problem'
 *
 *     If target type is immutable, then 'no problem'
 *
 *     Otherwise, there is a possibility that a view of the original source will be created, which is much faster and efficient, however this must be understood
 *
 *     @example {{{
 *         val source: Index.W[Char] = ('a' <> 'z').all.to[Index.W]
 *
 *         val as = source.all.letAt(10 <> 15).as[Index]
 *         val to = source.all.letAt(10 <> 15).to[Index]
 *
 *         source(10) = 'X'
 *         source(11) = 'Y'
 *         source(12) = 'Z'
 *
 *         as.all.lp // Prints: ~(X, Y, Z, n, o, p)  // as is affected by the source change
 *         to.all.lp // Prints: ~(k, l, m, n, o, p)
 *     }}}
 *
 *     @note  Generally if the source is created on the same thread, then the situation is under control and using 'as' is justified
 */
