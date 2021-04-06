package scalqa; package gen; import time.*; import language.implicitConversions

import Gen.Time

object Time extends Long.Custom.Data.Ordered[Time]("Time") with time.x.Base[Time] with time.x.Millis[Time]:
  /**/           inline def fromMillis(inline v: Long)              : Time        = v.asOpaque[Time]
  /**/           inline def apply()                                 : Time        = System.currentTimeMillis.asOpaque[Time]
  /**/                  def apply(day: Day, l: Length, ls: Length*) : Time        = (day.start.millisTotal + {if (ls.isEmpty) l.millisTotal else ls.~.map(_.nanosTotal).fold(l.nanosTotal)(_ + _) / 1_000_000L}).asOpaque[Time]
  /**/                  def apply(i: java.time.Instant)             : Time        = (i.getEpochSecond * 1000 + i.getNano / 1_000_000L).asOpaque[Time]
  @tn("current_Pro")    def current_*(changeEvery: Length)          : Time.Pro.O  = z.CurrentProperty(changeEvery)
  override              def isVoid(v: Time)                         : Boolean     = v.real == -62167201438000L
  override              def tag(v: Time)                            : String      = v.day.tag + ' ' + v.dayTime.tag
  implicit       inline def xxRequest(inline v: CURRENT)            : Time        = apply()
  implicit       inline def xxRequest(inline v: \/)                 : Time        = -62167201438000L.asOpaque[Time]

  //given xxDefVoid: Def.Void[Time]=this

  extension(x: Time)
    /**/    inline def millisTotal             : Long        = x.real
    /**/           def format(pattern: String) : String      = new java.text.SimpleDateFormat(pattern).format(new java.util.Date(x.millisTotal))
    /**/    inline def toGmt                   : Gmt         = Gmt.fromMillis(x.millisTotal)
    /**/    inline def toInstant               : Instant     = Instant.fromNanos(x.millisTotal * 1_000_000L)
    /**/           def skipTo(dt: DayTime)     : Time        = x + { val l = dt.millisTotal - x.dayTime.millisTotal; { if (l >= 0) l else l + X.Millis.InOneDay}.Millis}
    protected      def general                 : Time        = x
    private inline def zdt         : java.time.ZonedDateTime = java.time.Instant.ofEpochMilli(x.millisTotal).atZone(Zone.Id)
    override       def day                     : Day         = Day.byIndex(x.zdt.toLocalDate.toEpochDay.toInt)
    override       def dayTime                 : DayTime     = { val dt = x.zdt; dt.getHour.Hours + dt.getMinute.Minutes + dt.getSecond.Seconds + dt.getNano.Nanos }

  object opaque:
    opaque type `type` <: Opaque.Long = Opaque.Long

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def DayTime  = time.DayTime;             type DayTime = time.DayTime.opaque.`type`
  inline def Gmt      = time.Gmt;                 type Gmt     = time.Gmt.opaque.`type`
  inline def Instant  = time.Instant;             type Instant = time.Instant.opaque.`type`
  inline def Length   = time.Length;              type Length  = time.Length.opaque.`type`
  inline def Period   = time.Period;              type Period  = time.Period
  inline def Zone     = time.Zone
  inline def X        = time.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

    [[Time]] is an opaque Long value, holding milliseconds since start of 1970

@def format -> Format

     Formats time with given `pattern`

     See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for details
     ```
       val t: Time = \/

       t.format("hh 'o`clock' a, z z z z") TP        // Prints: 07 o'clock PM, Eastern Standard Time

       t.format("yyyy.MM.dd G 'at' HH:mm:ss z") TP // Prints: 1969.12.31 AD at 19:00:00 EST

       t.format("EEE, MMM d, `yy") TP             // Prints: Wed, Dec 31, '69

       t.format("h:mm a") TP                       // Prints: 7:00 PM
     ```


@def toGmt -> GMT Time

       Built-in constructor to create [[Time.Gmt]]


@def skipTo -> Skip to next

       Finds next greater instance of time with given [[DayTime]]

       Note: The result may skip to next day

       ```
         val time = 2018.Year.start

         time TP                                   // Prints: 2018-01-01 0:00:00

         time.skipTo(16.Hours) TP                  // Prints: 2018-01-01 16:00:00

         time.skipTo(16.Hours).skipTo(10.Hours) TP // Prints: 2018-01-02 10:00:00
       ```

*/
