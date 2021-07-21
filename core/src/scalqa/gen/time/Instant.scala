package scalqa; package gen; package time; import language.implicitConversions

import Time.Instant

object Instant extends Long.Custom.Data.Ordered[Instant]("Time.Instant") with time.x.Base[Instant] with time.x.Nanos._methods[Instant]:
  inline   def fromNanos(inline v: Long)   : Instant = v.asOpaque[Instant]
  inline   def apply()                     : Instant = apply(clock.instant); private val clock = java.time.Clock.systemUTC
  /**/     def apply(i: java.time.Instant) : Instant = (i.getEpochSecond * 1_000_000_000L + i.getNano).asOpaque[Instant]
  override def tag(v: Instant)             : String  = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(v.real / 1_000_000)) + "." + Z.pad(v.micros, 3) + "." + Z.pad(v.nanos, 3)

  implicit inline def implicitRequest(inline v: CURRENT): Instant = apply()

  extension(x: Instant)
    @tn("nanosTotal")        def nanosTotal                : Long     = x.real
    @tn("general") protected def general                   : Time     = Time.fromMillis(x.millisTotal)
    @tn("plus")       inline def + (inline l: Time.Length) : Instant  = (x.nanosTotal + l.nanosTotal).cast[Instant]
    @tn("minus")      inline def - (inline l: Time.Length) : Instant  = (x.nanosTotal - l.nanosTotal).cast[Instant]

  object opaque:
    opaque type `type` <: Opaque.Long = Opaque.Long

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

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
