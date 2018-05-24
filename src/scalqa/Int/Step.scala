package scalqa; package Int

trait Step[-A] {

  def apply[B](steps: Int, a: A): B

}

object Step {

  implicit object Sequence extends Step[Able.Sequence] { def apply[A](steps: Int, v: Able.Sequence) = (v + steps).cast[A] }

  implicit object Bytes extends Step[Byte] { ; ; def apply[A](steps: Int, v: Byte) = ((v + steps).toByte).cast[A] }
  implicit object Chars extends Step[Char] { ; ; def apply[A](steps: Int, v: Char) = ((v + steps).toChar).cast[A] }
  implicit object Shorts extends Step[Short] { ; def apply[A](steps: Int, v: Short) = ((v + steps).toShort).cast[A] }
  implicit object Ints extends Step[Int] { ; ; ; def apply[A](steps: Int, v: Int) = (v + steps).cast[A] }
  implicit object Longs extends Step[Long] { ; ; def apply[A](steps: Int, v: Long) = (v + steps).cast[A] }
  implicit object Floats extends Step[Float] { ; def apply[A](steps: Int, v: Float) = (v + steps).cast[A] }
  implicit object Doubles extends Step[Double] { def apply[A](steps: Int, v: Double) = (v + steps).cast[A] }

  implicit object ByteValue extends Step[Byte.Like] { ; ; def apply[A](steps: Int, v: Byte.Like) = v.kin.map((v._real + steps).toByte).cast[A] }
  implicit object CharValue extends Step[Char.Like] { ; ; def apply[A](steps: Int, v: Char.Like) = v.kin.map((v._real + steps).toChar).cast[A] }
  implicit object ShortValue extends Step[Short.Like] { ; def apply[A](steps: Int, v: Short.Like) = v.kin.map((v._real + steps).toShort).cast[A] }
  implicit object IntValue extends Step[Int.Like] { ; ; ; def apply[A](steps: Int, v: Int.Like) = v.kin.map(v._real + steps).cast[A] }
  implicit object LongValue extends Step[Long.Like] { ; ; def apply[A](steps: Int, v: Long.Like) = v.kin.map(v._real + steps).cast[A] }
  implicit object FloatValue extends Step[Float.Like] { ; def apply[A](steps: Int, v: Float.Like) = v.kin.map(v._real + steps).cast[A] }
  implicit object DoubleValue extends Step[Double.Like] { def apply[A](steps: Int, v: Double.Like) = v.kin.map(v._real + steps).cast[A] }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
