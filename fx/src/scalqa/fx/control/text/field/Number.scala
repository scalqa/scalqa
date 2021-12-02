package scalqa; package fx; package control; package text; package field; import language.implicitConversions

class Number protected (columns: Opt[Int]=VOID, value: Opt[String]=VOID) extends Text.Field(columns, value):
  var negativeAllowed = true
  onChange(c => try { if (c.textAfter.toDouble < 0 && !negativeAllowed) c.text_=(VOID) } catch { case _ : Exception => c.text_=(VOID) })

  def intResult    : Result[Int]    = text.trim.toIntResult
  def doubleResult : Result[Double] = text.trim.toDoubleResult

object Number:
  def apply(value: String)                                  : Number = new Number(VOID, value)
  def apply(columns: Opt[Int]=VOID, value: Opt[String]=VOID) : Number = new Number(columns, value)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
