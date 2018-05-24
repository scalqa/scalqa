package scalqa; package General

private[scalqa] trait _include extends Value._include with Tool._include {

  import scala.language.higherKinds
  import scala.language.implicitConversions

  implicit def zzAny_library[A](v: A) = new Any._library._Class[A](v)

  implicit def zzPipe[A](a: ~[A]): Pipe[A] = a match { case v: Pipe[A] => v; case null => \/; case a => new Pipe.Z.transform.asPipe(a) }

  implicit def zzTraversable_all_method[A](v: scala.TraversableOnce[A]) = new Pipe.From.AllMethod[scala.TraversableOnce, A](v)
  implicit def zzArray_all_method[A](v: scala.Array[A]) = new Pipe.From.AllMethod[scala.Array, A](v)
  implicit def zzIterable_all_method[A](v: java.lang.Iterable[A]) = new Pipe.From.AllMethod[java.lang.Iterable, A](v)
  implicit def zzIterator_all_method[A](v: java.util.Iterator[A]) = new Pipe.From.AllMethod[java.util.Iterator, A](v)

  implicit def byteWrapper(v: Byte) = new Byte._library._Class(v)
  implicit def charWrapper(v: Char) = new Char._library._Class(v)
  implicit def booleanWrapper(v: Boolean) = new Boolean._library._Class(v)
  implicit def shortWrapper(v: Short) = new Short._library._Class(v)
  implicit def intWrapper(v: Int) = new Int._library._Class(v)
  implicit def longWrapper(v: Long) = new Long._library._Class(v)
  implicit def floatWrapper(v: Float) = new Float._library._Class(v)
  implicit def doubleWrapper(v: Double) = new Double._library._Class(v)
  implicit def augmentString(s: String) = new String._library._Class(s)
  implicit def wrapString(s: String): Any = \/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzAny_library -> Attaches General library to every possible type
 *
 *       All library methods are implicitly attached and available on ''Any'' object
 *
 * @def zzPipe[ -> Interface to Pipe
 *
 *       Globally converts any [[Pipe.Interface]] to [[Pipe]]
 *
 *       zzPipe must be in global scope, because it competes for piping methods with zzAny_library
 *
 * @def zzTraversable_all_method -> Attaches ''all'' method
 *
 *       Attaches ''all'' elements as pipe method to every scala.TraversableOnce
 *
 * @def zzArray_all_method -> Attaches ''all'' method
 *
 *       Attaches ''all'' elements as pipe method to every scala.Array
 *
 * @def zzIterable_all_method -> Attaches ''all'' method
 *
 *       Attaches ''all'' elements as pipe method to every java.lang.Iterable
 *
 * @def zzIterator_all_method -> Attaches ''all'' method
 *
 *       Attaches ''all'' elements as pipe method to every java.util.Iterator
 *
 * @def byteWrapper -> Attaches library to Byte type
 *
 *       All library methods are implicitly attached and available on any instance of ''Byte'' type
 *
 *       Note. Scala RichByte attachment is overridden, but it is available under method [[Byte._library._constructor.Rich Rich]] in new library
 *
 * @def charWrapper -> Attaches library to Char type
 *
 *       All library methods are implicitly attached and available on any instance of ''Char'' type
 *
 *       Note. Scala RichChar attachment is overridden, but it is available under method [[Char._library._constructor.Rich Rich]] in new library
 *
 * @def booleanWrapper -> Attaches library to Boolean type
 *
 *       All library methods are implicitly attached and available on any instance of ''Boolean'' type
 *
 *       Note. Scala RichBoolean attachment is overridden, but it is available under method [[Boolean._library._constructor.Rich Rich]] in new library
 *
 * @def shortWrapper -> Attaches library to Short type
 *
 *       All library methods are implicitly attached and available on any instance of ''Short'' type
 *
 *       Note. Scala RichShort attachment is overridden, but it is available under method [[Short._library._constructor.Rich Rich]] in new library
 *
 * @def intWrapper  -> Attaches library to Int type
 *
 *       All library methods are implicitly attached and available on any instance of ''Int'' type
 *
 *       Note. Scala RichInt attachment is overridden, but it is available under method [[Int._library._constructor.Rich Rich]] in new library
 *
 * @def longWrapper  -> Attaches library to Long type
 *
 *       All library methods are implicitly attached and available on any instance of ''Long'' type
 *
 *       Note. Scala RichLong attachment is overridden, but it is available under method [[Long._library._constructor.Rich Rich]] in new library
 *
 * @def floatWrapper  -> Attaches library to Float type
 *
 *       All library methods are implicitly attached and available on any instance of ''Float'' type
 *
 *       Note. Scala RichFloat attachment is overridden, but it is available under method [[Float._library._constructor.Rich Rich]] in new library
 *
 * @def doubleWrapper  -> Attaches library to Double type
 *
 *       All library methods are implicitly attached and available on any instance of ''Double'' type
 *
 *       Note. Scala RichDouble attachment is overridden, but it is available under method [[Double._library._constructor.Rich Rich]] in new library
 *
 * @def augmentString  -> Attaches library to String type
 *
 *       All library methods are implicitly attached and available on any instance of ''String'' type
 *
 *       Note. Scala StringOps attachment is overridden, but it is available under method [[String._library._constructor.Ops Ops]] in new library
 *
 * @def wrapString  -> Cancels direct access to Scala WrappedString functionality
 *
 *       Note. Scala WrappedString attachment is overridden, but it is available under method [[String._library._constructor.Wrap Wrap]] in new library
 */
