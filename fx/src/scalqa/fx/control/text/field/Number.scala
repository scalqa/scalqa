package scalqa; package fx; package control; package text; package field; import language.implicitConversions

class Number protected (columns: Opt[Int] = \/, value: String.Opt = \/) extends Text.Field(columns, value):
  var negativeAllowed = true
  onChange(c => try { if (c.textAfter.toDouble < 0 && !negativeAllowed) c.text_=(\/) } catch { case _: Exception => c.text_=(\/) })

  @tn("int_Result")     def int_??    : Result[Int]    = text.trim.toInt_??
  @tn("double_Result")  def double_?? : Result[Double] = text.trim.toDouble_??

object Number:
  def apply(value: String)                                   : Number = new Number(\/, value)
  def apply(columns: Opt[Int] = \/, value: String.Opt = \/) : Number = new Number(columns, value)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
