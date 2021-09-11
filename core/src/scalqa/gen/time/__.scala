package scalqa; package gen; import time.*; import language.implicitConversions

import Gen.Time

object Time extends Long.Opaque.Data.Ordered[Time]("Time") with time.x.Base[Time] with time.x.Millis.Base:
  /**/           inline def fromIndex(epochMillis: Long)    : Time        = epochMillis.toOpaque
  /**/           inline def current                         : Time        = System.currentTimeMillis.toOpaque
  /**/                  def apply(d:Day,l:Length,ls:Length*): Time        = (d.start.real + {if (ls.isEmpty) l.millisTotal else ls.~.map(_.nanosTotal).fold(l.nanosTotal)(_ + _) / 1_000_000L}).toOpaque
  /**/                  def apply(i: java.time.Instant)     : Time        = (i.getEpochSecond * 1000 + i.getNano / 1_000_000L).toOpaque
  @tn("current_Pro")    def current_*(changeEvery:Length)   : Time.Pro.O  = z.CurrentProperty(changeEvery)
  override              def value_isVoid(v: Time)           : Boolean     = v.real == voidValue
  override              def value_tag(v: Time)              : String      = v.day.tag + ' ' + v.dayTime.tag
  private        inline val voidValue                    /* : Long */     = -62167201438000L  // 0000-01-01 00:00:00

  implicit       inline def implicitFrom(v: CURRENT)        : Time        = current
  implicit       inline def implicitFrom(v: \/)             : Time        = voidValue.toOpaque

  extension(x: Time)
    protected           def genTime                         : Time        = x
    /**/                def age                             : Length      = { val cm = System.currentTimeMillis; val m = x.real; if (cm <= m) \/ else (cm - m).Millis }
    /**/                def lengthTo(that: Time)            : Length      = (that.real - x.real).abs.Millis
    /**/                def format(pattern: String)         : String      = new java.text.SimpleDateFormat(pattern).format(new java.util.Date(x.real))
    /**/                def skipTo(dt: DayTime)             : Time        = x + { val l = dt.millisTotal - x.dayTime.millisTotal; { if (l >= 0) l else l + X.Millis.InOneDay}.Millis}
    override            def day                             : Day         = Day.fromIndex(Z.zonedDateTime(x).toLocalDate.toEpochDay.toInt)
    override            def dayTime                         : DayTime     = Z.zonedDateTime(x).^.to(dt => dt.getHour.Hours + dt.getMinute.Minutes + dt.getSecond.Seconds + dt.getNano.Nanos)
  extension(inline x: Time)
    /**/         inline def toGmt                           : Gmt         = Gmt.fromIndex(x.real)
    /**/         inline def toInstant                       : Instant     = Instant.fromNanos(x.real * 1_000_000L)
    @tn("plus")  inline def +(inline l: Length)             : Time        = (x.real + l.millisTotal).toOpaque
    @tn("minus") inline def -(inline l: Length)             : Time        = (x.real - l.millisTotal).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def DayTime  = time.DayTime;             type DayTime = time.DayTime.TYPE.DEF
  transparent inline def Gmt      = time.Gmt;                 type Gmt     = time.Gmt.TYPE.DEF
  transparent inline def Instant  = time.Instant;             type Instant = time.Instant.TYPE.DEF
  transparent inline def Length   = time.Length;              type Length  = time.Length.TYPE.DEF
  transparent inline def Period   = time.Period;              type Period  = time.Period
  transparent inline def Zone     = time.Zone
  transparent inline def X        = time.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

    [[Time]] is an opaque Long value, holding milliseconds since start of 1970

@def format -> Format

     Formats time with given `pattern`

     See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for details
     ```
       val t: Time = \/

       t.format("hh 'o`clock' a, z z z z").TP      // Prints: 07 o'clock PM, Eastern Standard Time

       t.format("yyyy.MM.dd G 'at' HH:mm:ss z").TP // Prints: 1969.12.31 AD at 19:00:00 EST

       t.format("EEE, MMM d, `yy").TP             // Prints: Wed, Dec 31, '69

       t.format("h:mm a").TP                      // Prints: 7:00 PM
     ```


@def toGmt -> GMT Time

       Built-in constructor to create [[Time.Gmt]]


@def skipTo -> Skip to next

       Finds next greater instance of time with given [[DayTime]]

       Note: The result may skip to next day

       ```
         val time = 2018.Year.start

         time.TP                                   // Prints: 2018-01-01 0:00:00

         time.skipTo(16.Hours).TP                  // Prints: 2018-01-01 16:00:00

         time.skipTo(16.Hours).skipTo(10.Hours).TP // Prints: 2018-01-02 10:00:00
       ```



@def age -> [[Length]] to current.

       Returns [[Length]] from `this` time to current time.

       If `this` is in future, void [[Length]] is returned.

@def lengthTo -> Range duration

       Returns [[Length]] between `this` and `that`.

*/
