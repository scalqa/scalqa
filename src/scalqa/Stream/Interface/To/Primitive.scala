package scalqa; package Stream; package Interface; package To

object Primitive {

  abstract class Converter[A, TRGT] protected {

    def make: Flow[A] => TRGT

  }

  implicit val Bytes: Converter[Byte, Bytes] = new Base(_.toPrimitive[Bytes])
  implicit val Chars: Converter[Char, Chars] = new Base(_.toPrimitive[Chars])
  implicit val Shorts: Converter[Short, Shorts] = new Base(_.toPrimitive[Shorts])
  implicit val Ints: Converter[Int, Ints] = new Base(_.toPrimitive[Ints])
  implicit val Longs: Converter[Long, Longs] = new Base(_.toPrimitive[Longs])
  implicit val Floats: Converter[Float, Floats] = new Base(_.toPrimitive[Floats])
  implicit val Doubles: Converter[Double, Doubles] = new Base(_.toPrimitive[Doubles])
  implicit val Booleans: Converter[Boolean, Booleans] = new Base(_.toPrimitive[Booleans])

  private class Base[A, T](c: scalqa.Idx.I[A] => T) extends Converter[A, T] {
    def make = f => c(f.to[scalqa.Idx.I])
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Primitive ->
 *
 *    [[Primitive]] is a standard interface from [[Stream]] to primitive collections: Booleans, Bytes, Chars, Shorts, Ints, Longs, Floats and Doubles
 *
 */
