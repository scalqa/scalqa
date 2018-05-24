package scalqa; package Array; package Z

private[Array] trait Implicits {

  import scala.language.implicitConversions

  implicit def zzLibrary_Boolean(a: Array[Boolean]) = new _library._Boolean(a.raw.cast)

  implicit def zzLibrary_Char(a: Array[Char]) = new _library._Char(a.raw.cast)

  implicit def zzLibrary_Byte(a: Array[Byte]) = new _library._Byte(a.raw.cast)

  implicit def zzLibrary_Long(a: Array[Long]) = new _library._Long(a.raw.cast)

  implicit def zzLibrary_Int(a: Array[Int]) = new _library._Int(a.raw.cast)

  implicit def zzLibrary_Double(a: Array[Double]) = new _library._Double(a.raw.cast)

  implicit def zzLibrary_Short(a: Array[Short]) = new _library._Short(a.raw.cast)

  implicit def zzLibrary_Float(a: Array[Float]) = new _library._Float(a.raw.cast)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
