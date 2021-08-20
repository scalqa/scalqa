package scalqa; package gen; package time; import language.implicitConversions

import Time.Instant

object Instant extends Long.Opaque.Data.Ordered[Instant]("Time.Instant") with time.x.Base[Instant] with time.x.Nanos.Base:
  /**/           inline def fromNanos(inline v: Long)  : Instant = v.opaque
  /**/           inline def apply()                    : Instant = apply(clock.instant); private val clock = java.time.Clock.systemUTC
  /**/                  def apply(i: java.time.Instant): Instant = (i.getEpochSecond * 1_000_000_000L + i.getNano).opaque
  override              def value_tag(v: Instant)      : String  = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(v.real / 1_000_000L)) + "." + Z.pad(v.micros, 3) + "." + Z.pad(v.nanos, 3)

  implicit       inline def implicitFrom(v: CURRENT)   : Instant = apply()

  extension(x: Instant)
    /**/                def genTime                    : Time    = Time.fromIndex(x.real / 1_000_000L)
    @tn("plus")  inline def + (inline l: Time.Length)  : Instant = (x.real + l.nanosTotal).opaque
    @tn("minus") inline def - (inline l: Time.Length)  : Instant = (x.real - l.nanosTotal).opaque

  object OPAQUE:
    opaque type TYPE <: Long.Opaque = Long.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

      [[Time.Instant]] is an opaque Long value, holding nanoseconds since start of 1970

      General timing in `scalqa` is done with millisecond precision and it is sufficient for most scenarios.

      Occasionally, however, nanosecond precision is required, and [[Time.Instant]] fills the gap:
      ```
           val t : Time    = CURRRENT
           val i : Instant = CURRRENT

           t.TP   // Printed: 2021-01-21 09:36:31.761

           i.TP   // Printed: 2021-01-21 09:36:31.766.000.000

      ```
      Note. [[Time.Instant]] is limited to range of years from 1677 to 2260

@def apply  -> Current time instant

     Getting instant from java.time.Clock.systemUTC.instant

     ```
         Instant().TP
         // Printed no micros or nanos
         2021-01-21 09:36:31.766.000.000
         // Apparently not every JVM supports precise clock
    ```

@def apply -> By instant

     Time from java.time.Instant

*/
