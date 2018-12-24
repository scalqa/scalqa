package scalqa; package Fx; package Text; package Field

class Number(columns: Opt[Int] = \/, value: Opt[String] = \/) extends Field(columns, value) {
  def this(value: String) = this(\/, value)

  var negativeAllowed = true;

  onObservableChange(c => try { if (c.textAfter.toDouble < 0 && !negativeAllowed) c.text = \/ } catch { case _: Exception => c.text = \/ })

  def intOut: Out[Int] = text.trim.toIntOut

  def doubleOut: Out[Double] = text.trim.toDoubleOut

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
