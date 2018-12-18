package scalqa.Util.Z.Include

import scalqa.{ DATA, Custom, Ilk, ~ }
import scalqa.Any.Able.{ Stream => All }
import scalqa.Stream.Z

private[scalqa] trait Streaming {

  @inline implicit def zzStream_Interface[@specialized(DATA) A](v: ~[A]) = v.asInstanceOf[scalqa.Stream._Class[A]]

  @inline implicit def zzStream_Java_Iterable[@specialized(DATA) A: Ilk](v: java.lang.Iterable[A]): ~[A] with All[A] = Z.A.Java.Iterable.toStream[A](v)

  @inline implicit def zzStream_Java_Iterator[@specialized(DATA) A: Ilk](v: java.util.Iterator[A]): ~[A] with All[A] = Z.A.Scala.Iterator.toStream[A](v)

  @inline implicit def zzStream_Java_Stream[@specialized(DATA) A](v: java.util.stream.Stream[A]): ~[A] with All[A] = zzStream_Java_Iterator(v.iterator)

  @inline implicit def zzStream_Scala_Array[@specialized(DATA) A](v: scala.Array[A]): ~[A] with All[A] = Custom.Array.Z.stream(v)

  @inline implicit def zzStream_Scala_Traversable[@specialized(DATA) A: Ilk](v: collection.GenTraversableOnce[A]): ~[A] with All[A] = Z.A.Scala.GenTraversableOnce.toStream[A](v)

  @inline implicit def zzStream_Scala_IndexedSeq[@specialized(DATA) A: Ilk](v: collection.IndexedSeq[A]): ~[A] with All[A] = Z.A.Scala.IndexedSeq.toStream[A](v)

  @inline implicit def zzStream_Scala_LinearSeq[@specialized(DATA) A: Ilk](v: collection.LinearSeq[A]): ~[A] with All[A] = Z.A.Scala.LinearSeq.toStream[A](v)

  @inline implicit def zzStream_Scala_Range(v: scala.Range): ~[Int] with All[Int] = scalqa.Idx.Range.Z.stream(v.start, v.size)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def zzStream_Scala_Array -> Array to Stream
 *
 *       Globally provides implicit conversion from Array to [[Stream]]
 *
 *  @def zzStream_Scala_Traversable -> Traversable to Stream
 *
 *       Globally provides implicit conversion from scala.collection.TraversableOnce to [[Stream]]
 *
 *  @def zzStream_Scala_IndexedSeq -> IndexedSeq to Stream
 *
 *       Globally provides implicit conversion from scala.collection.IndexedSeq to [[Stream]]
 *
 *  @def zzStream_Scala_LinearSeq -> LinearSeq to Stream
 *
 *       Globally provides implicit conversion from scala.collection.zzStream_Scala_LinearSeq to [[Stream]]
 *
 *  @def zzStream_Scala_Range -> scala.Range to Stream
 *
 *       Globally provides implicit conversion from scala.Range to [[Stream]]
 *
 *  @def zzStream_Interface -> Interface to Stream
 *
 *       Globally converts any [[Stream.Interface]] to [[Stream]]
 *
 *       This method must be in global scope, because it competes for piping methods with zzLibrary_Any
 *
 *  @def zzStream_Java_Iterable -> Java Iterable to Stream
 *
 *       Globally provides implicit conversion from java.lang.Iterable to [[Stream]]
 *
 *  @def zzStream_Java_Iterator -> Java Iterator to Stream
 *
 *       Globally provides implicit conversion from java.util.Iterator to [[Stream]]
 *
 *  @def zzStream_Java_Stream -> Java Stream to Stream
 *
 *       Globally provides implicit conversion from java.util.stream.Stream to [[Stream]]
 *
 */
