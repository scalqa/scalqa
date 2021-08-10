package scalqa; package gen; package time; import language.implicitConversions

import Time.Length
import x.Nanos

object Length extends Long.Opaque.Data.Calculable[Length]("Time.Length") with time.x.Nanos.LengthBase:
  /**/            def apply(v: Length*)       : Length  = v.~.fold(\/ :Length)(_ + _)
  /**/     inline def fromNanos(inline v:Long): Length  = v.opaque

  override        def value_isVoid(v: Length) : Boolean = v.real==0L
  override        def value_tag(v: Length)    : String  = z.formatLength(v,false)

  implicit inline def implicitRequest(v: \/)  : Length  = fromNanos(0L)

  extension(x: Length)
    /**/          def tagBrief                : String = z.formatLength(x, true)

  object OPAQUE:
    opaque type TYPE <: Long.Opaque = Long.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  ->

      [[Time.Length]] is an opaque Long value, holding total nanoseconds

      [[Time.Length]] constructor methods are attached to primitives:
      ```
         1.Day.TP       // Prints: 1 day
         33.Millis.TP   // Prints: 0.033 sec
         10.Hours.TP    // Prints: 10 hours
         99999.Nanos.TP // Prints: 0.000099999 sec
      ```

      Longest [[Time.Length]] possible is:
      ```
        Long.max.Nanos.TP  // Prints: 106751 days 23 hours 47 mins 16.854775807 secs
      ```

@def fromNanos -> By nanoseconds

     Creates [[Length]] by total nanoseconds.

     ```
         Length.fromNanos(Long.OneTrillion + 999).TP
         // Output
         16 mins, 40.000000999 secs
     ```


@def apply -> By generic units.

     Creates [[Length]] specified by one or more length units in any order.

     ```
          Length(12.Hours, 45.Minutes, 999.Nanos, 5.Millis).TP
          // Output
          12 hours, 45 mins, 0.005000999 sec
     ```

*/
