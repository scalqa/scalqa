package scalqa.Util.Z.Include

import scala.language.implicitConversions

private[scalqa] trait Library extends _library.Secondary {

  implicit def zzLibrary_Byte(v: Byte) = new scalqa.Custom.Byte._library(v)
  implicit def zzLibrary_Char(v: Char) = new scalqa.Custom.Char._library(v)
  implicit def zzLibrary_Short(v: Short) = new scalqa.Custom.Short._library(v)
  implicit def zzLibrary_Int(v: Int) = new scalqa.Custom.Int._library(v)
  implicit def zzLibrary_Long(v: Long) = new scalqa.Custom.Long._library(v)
  implicit def zzLibrary_Float(v: Float) = new scalqa.Custom.Float._library(v)
  implicit def zzLibrary_Double(v: Double) = new scalqa.Custom.Double._library(v)
  implicit def zzLibrary_Boolean(v: Boolean) = new scalqa.Custom.Boolean._library(v)
  implicit def zzLibrary_Array[A](v: Array[A]) = new scalqa.Custom.Array._library[A](v)
  implicit def zzLibrary_String(s: String) = new scalqa.Custom.String._library._Class(s)

  implicit def zzLibrary_Number(v: Number) = new scalqa.Custom.Number._library(v)
  implicit def zzLibrary_Numeric[A](v: Numeric[A]) = new scalqa.Custom.Numeric._library(v)
  implicit def zzLibrary_Ordering[A](v: Ordering[A]) = new scalqa.Custom.Ordering._library(v)
  implicit def zzLibrary_Tuple2[A, B](v: (A, B)) = new scalqa.Custom.Tuple._library2(v)
  implicit def zzLibrary_Tuple3[A, B, C](v: (A, B, C)) = new scalqa.Custom.Tuple._library3(v)
  implicit def zzLibrary_Tuple4[A, B, C, D](v: (A, B, C, D)) = new scalqa.Custom.Tuple._library4(v)
}

private[scalqa] object _library {

  trait Secondary extends DefaultWhenEverythingElseFails
  trait DefaultWhenEverythingElseFails {

    implicit def zzLibrary_Any[A](v: A) = new scalqa.Any._library[A](v)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzLibrary_Any -> Attaches Universal library to every possible type
 *
 *       All library methods are implicitly attached and available on `Any` object
 *
 * @def zzLibrary_Array -> Attaches library to Array type
 *
 *       All library methods are implicitly attached and available on `Array` object
 *
 * @def zzLibrary_Numeric -> Attaches library to Numeric type
 *
 *       All library methods are implicitly attached and available on `Numeric` object
 *
 * @def zzLibrary_Number -> Attaches library to Number type
 *
 *       All library methods are implicitly attached and available on `Number` object
 *
 * @def zzLibrary_Ordering -> Attaches library to Ordering type
 *
 *       All library methods are implicitly attached and available on `Ordering` object
 *
 * @def zzLibrary_Byte -> Attaches library to Byte type
 *
 *       All library methods are implicitly attached and available on any instance of `Byte` type
 *
 * @def zzLibrary_Char -> Attaches library to Char type
 *
 *       All library methods are implicitly attached and available on any instance of `Char` type
 *
 * @def zzLibrary_Boolean -> Attaches library to Boolean type
 *
 *       All library methods are implicitly attached and available on any instance of `Boolean` type
 *
 * @def zzLibrary_Short -> Attaches library to Short type
 *
 *       All library methods are implicitly attached and available on any instance of `Short` type
 *
 * @def zzLibrary_Int  -> Attaches library to Int type
 *
 *       All library methods are implicitly attached and available on any instance of `Int` type
 *
 * @def zzLibrary_Long  -> Attaches library to Long type
 *
 *       All library methods are implicitly attached and available on any instance of `Long` type
 *
 * @def zzLibrary_Float  -> Attaches library to Float type
 *
 *       All library methods are implicitly attached and available on any instance of `Float` type
 *
 * @def zzLibrary_Double  -> Attaches library to Double type
 *
 *       All library methods are implicitly attached and available on any instance of `Double` type
 *
 * @def zzLibrary_String  -> Attaches library to String type
 *
 *       All library methods are implicitly attached and available on any instance of `String` type
 *
 * @def zzLibrary_Tuple2-> Attaches Tuple2 custom library
 *
 *    All library methods are implicitly attached and available on any instance of `Tuple2` type
 *
 * @def zzLibrary_Tuple3-> Attaches Tuple3 custom library
 *
 *    All library methods are implicitly attached and available on any instance of `Tuple3` type
 *
 * @def zzLibrary_Tuple4-> Attaches Tuple4 custom library
 *
 *    All library methods are implicitly attached and available on any instance of `Tuple4` type
 *
 */
