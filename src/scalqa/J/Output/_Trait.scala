package scalqa; package J; package Output

trait _Trait extends Z.Like {

  def asPrinter: Printer = asText.asPrinter

  def asText: Text

  def asBytes: Bytes

  def asData: Data

}
object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary(o: Output) = new _library(o)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
