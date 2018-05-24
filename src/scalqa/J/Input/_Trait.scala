package scalqa; package J; package Input

trait _Trait extends Able.Close {

  def asBytes: Bytes

  def asText: Text

  def asData: Data

  def close: Unit

}
object _Trait {

  import scala.language.implicitConversions

  implicit def zzGet(is: java.io.InputStream): Input = new Z.Bytes(is)

  implicit def zzLibrary(i: Input) = new _library(i)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
