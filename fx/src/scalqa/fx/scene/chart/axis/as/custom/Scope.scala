package scalqa; package fx; package scene; package chart; package axis; package as; package custom; import language.implicitConversions

class Scope[A] (val start: A, val end: A, val unit: Double, val format: String, private[custom] val scale: Double = 0) extends Able.Doc:

  def transform[B](m: A => B) : Scope[B] = new Scope(m(start), m(end), unit, format, scale)
  def isSingularity           : Boolean  = start == end
  def doc                    : Doc     = Doc(this) += ("start", start) += ("end", end) += ("unit", unit) += ("format", format) += ("scale", scale) += ("class", start.getClass)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
