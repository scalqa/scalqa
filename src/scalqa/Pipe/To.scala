package scalqa; package Pipe

import scala.language.higherKinds

abstract class To[CONTAINER[Any]](private[Pipe] val isResultView: Boolean, private[Pipe] val targetClass: Class[_]) {

  // Compiler fails if CONTAINER is AnyVal like Array, that is why 'opt' dancing is needed for such cases
  def apply[A](a: Flow[A], t: Tag[A]): CONTAINER[A] = opt(a, t).value

  private[scalqa] def opt[A](a: Flow[A], t: Tag[A]): Opt[CONTAINER[A]] = Fail("either method has to be overriden")

}

object To {

  implicit val Array: To[Array] = Z.transform.toArray
  implicit val Refs: To[Refs] = Z.transform.toArray.Refs

  implicit val Coll: To[scalqa.Coll] = Z.transform.toColl
  implicit val CollW: To[scalqa.Coll.W] = Z.transform.toColl.W
  implicit val CollWO: To[scalqa.Coll.WO] = Z.transform.toColl.WO
  implicit val CollVal: To[scalqa.Coll.Val] = Z.transform.toColl.Val

  implicit val Index: To[scalqa.Index] = Z.transform.toIndex
  implicit val IndexW: To[scalqa.Index.W] = Z.transform.toIndex.W
  implicit val IndexWO: To[scalqa.Index.WO] = Z.transform.toIndex.WO
  implicit val IndexVal: To[scalqa.Index.Val] = Z.transform.toIndex.Val

  implicit val ScalaList: To[scala.List] = Z.transform.toScala.List
  implicit val ScalaSeq: To[scala.Seq] = Z.transform.toScala.IndexedSeq.cast
  implicit val ScalaIndexedSeq: To[scala.IndexedSeq] = Z.transform.toScala.IndexedSeq
  implicit val ScalaIterator: To[scala.Iterator] = Z.transform.toScala.Iterator
  implicit val ScalaVector: To[scala.Vector] = Z.transform.toScala.Vector
  implicit val ScalaBuffer: To[scala.collection.mutable.Buffer] = Z.transform.toScala.Buffer

  implicit val JavaCollection: To[java.util.Collection] = Z.transform.toJava.List.cast
  implicit val JavaList: To[java.util.List] = Z.transform.toJava.List
  implicit val JavaIterator: To[java.util.Iterator] = Z.transform.toJava.Iterator
  implicit val JavaSpliterator: To[java.util.Spliterator] = Z.transform.toJava.Spliterator
  implicit val JavaStream: To[java.util.stream.Stream] = Z.transform.toJava.Stream

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class To ->
 *
 *    [[Pipe.To]] is a standard converter interface from [[Pipe]] to any other type
 *
 *    Once there is an implicit converter instance available in the scope, the [[Pipe._pump._transform.to  Pipe.to]] method will work
 *
 *    There are default converters [[Pipe.To$ available]] for major Java and Scala containers
 *
 *    {{{
 *       ("1" ~ "2" ~ "3").to[Index.Val]  // Returns: Index.Val[String]
 *
 *       ('A' <> 'D').all.to[List]        // Returns: scala.List[Char]
 *
 *       (1 <> 5).all.to[java.util.List]  // Returns: java.util.List[Int]
 *    }}}
 */
