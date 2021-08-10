package scalqa; package gen; package time; import language.implicitConversions

import Time.Gmt

object Gmt extends Long.Opaque.Data[Gmt]("Time.Gmt") with time.x.Base[Gmt] with time.x.Millis.Base:
  /**/           inline def fromIndex(inline v: Long)  : Gmt     = v.opaque
  /**/           inline def current                    : Gmt     = System.currentTimeMillis.opaque
  override              def value_tag(v: Gmt)          : String  = v.day.tag + ' ' + v.dayTime.tag

  implicit       inline def implicitRequest(v: CURRENT): Gmt     = current

  extension(x: Gmt)
    /**/         inline def genTime                    : Time    = Time.fromIndex(x.real)
    override            def day                        : Day     = Day.fromIndex((x.real / X.Millis.InOneDay).toInt)
    override            def dayTime                    : DayTime = (x.real % X.Millis.InOneDay).toInt.Millis
  extension(inline x: Gmt)
    @tn("plus")  inline def +(inline l: Time.Length)   : Gmt     = (x.real + l.millisTotal).opaque
    @tn("minus") inline def -(inline l: Time.Length)   : Gmt     = (x.real - l.millisTotal).opaque

  object OPAQUE:
    opaque type TYPE <: Long.Opaque = Long.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ### Greenwich Mean Time

      [[Time.Gmt]] is an opaque Long value same as [[Time]], but not localized for printing

      ```
        val time = Time.current
        val gmt  = Time.Gmt.current

        time.dayTime.tagBrief.TP // Prints: 13:34

        gmt.dayTime.tagBrief.TP  // Prints: 17:34

        // Nevertheless they are data equal

        (time.real == gmt.real).TP       // Prints: true
   ```

*/
