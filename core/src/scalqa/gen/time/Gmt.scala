package scalqa; package gen; package time; import language.implicitConversions

import Time.Gmt

object Gmt extends Long.Custom.Data[Gmt]("Time.Gmt") with time.x.Base[Gmt] with time.x.Millis[Gmt]:
  inline   def fromMillis(inline v: Long): Gmt     = v.asOpaque[Gmt]
  inline   def apply()                   : Gmt     = System.currentTimeMillis.asOpaque[Gmt]
  override def tag(v: Gmt)               : String  = v.day.tag + ' ' + v.dayTime.tag

  implicit inline def implicitRequestCurrent(inline v: CURRENT) : Gmt     = apply()

  extension(x: Gmt)
    @tn("millisTotal") inline    def millisTotal: Long    = x.real
    @tn("day")         override  def day        : Day     = Day.byIndex((x.millisTotal / X.Millis.InOneDay).Int)
    @tn("dayTime")     override  def dayTime    : DayTime = (x.millisTotal % X.Millis.InOneDay).Int.Millis
    @tn("general")        inline def general    : Time    = Time.fromMillis(x.real)

  object opaque:
    opaque type `type` <: Opaque.Long = Opaque.Long

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Greenwich Mean Time

      [[Time.Gmt]] is an opaque Long value same as [[Time]], but not localized for printing

      ```
        val time = Time()
        val gmt  = Time.Gmt()

        time.dayTime.toBrief.TP // Prints: 13:34

        gmt.dayTime.toBrief.TP  // Prints: 17:34

        // Nevertheless they are data equal

        (time.real == gmt.real).TP       // Prints: true
   ```

*/
