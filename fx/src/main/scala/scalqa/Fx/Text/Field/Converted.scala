package scalqa; package Fx.Text; package Field

class Converted[VAL](protected val converter: String => Out[VAL], columns: Opt[Int] = \/, value: Opt[String] = \/) extends Field(columns, value) {

  //  protected def converter: String => Opt.orError[VAL]

  def valueOut: Out[VAL] = converter(text)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
