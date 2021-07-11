package scalqa; package lang; package long; import language.implicitConversions

transparent trait _methods extends z.toPrimitives[Long]:
  extension(inline x:Long)
    @tn("Opt")        inline def ?                         : SELF.Opt     = {val v=x; if(v==g.Opt.void.real) throw ZZ.LO(); v.cast[SELF.Opt]}
    @tn("range")      inline def <> (inline to: Long)      : SELF.<>      = new SELF.<>(x,to,true)
    @tn("rangeX")     inline def <>>(inline to: Long)      : SELF.<>      = new SELF.<>(x,to,false)
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : SELF.<>      = {val v=x; new SELF.<>(v,v+size,false)}
    infix             inline def atLeast(v: Long)          : Long         = {val w=x; if(w>v) w else v }
    infix             inline def atMost(v: Long)           : Long         = {val w=x; if(w<v) w else v }
    /**/              inline def roundTo(inline size:Long)
                                        (using r:Rounding) : Long         = r(x,size)

  extension(x: Long)         def toBrief                   : String       = x match
    /**/                                                                       case v if v >= 1_000_000_000_000L => s"${v * 10 / 1_000_000_000_000L / 10D}t"
    /**/                                                                       case v if v >= 1_000_000_000L     => s"${v * 10 / 1_000_000_000L / 10D}g"
    /**/                                                                       case v if v >= 1_000_000L         => s"${v * 10 / 1_000_000L / 10D}m"
    /**/                                                                       case v if v >= 1000L              => s"${v * 10 / 1000L / 10D}k"
    /**/                                                                       case v                            => v.toString
  //  -------------------------------------------------------------------------------------------------------
  import scalqa.gen.time.x.{ Nanos => NANOS }
  extension(inline x:Long)
    /**/              inline def ByteCount                 : ByteCount    = scalqa.Gen.ByteCount(x)
    /**/              inline def Year                      : Year         = scalqa.Gen.Year(x.toInt)
    /**/              inline def Big                       : BigInteger   = scalqa.Gen.BigInteger(x)
    /**/              inline def Percent                   : Percent      = scalqa.Gen.Percent(x.toDouble)
    /**/              inline def Week                      : Time.Length  = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Weeks                     : Time.Length  = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Day                       : Time.Length  = (x * NANOS.InOneDay).Nanos
    /**/              inline def Days                      : Time.Length  = (x * NANOS.InOneDay).Nanos
    /**/              inline def Hour                      : Time.Length  = (x * NANOS.InOneHour).Nanos
    /**/              inline def Hours                     : Time.Length  = (x * NANOS.InOneHour).Nanos
    /**/              inline def Minute                    : Time.Length  = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Minutes                   : Time.Length  = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Second                    : Time.Length  = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Seconds                   : Time.Length  = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Millis                    : Time.Length  = (x * NANOS.InOneMillis).Nanos
    /**/              inline def Micros                    : Time.Length  = (x * NANOS.InOneMicros).Nanos
    /**/              inline def Nanos                     : Time.Length  = x.cast[Time.Length]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Long Extension Methods \n\n Extension methods universaly avaialble for type scala.Long

@def ? ->  To option

    Returns Long.Opt for current value
    ```
      val o : Long.Opt = 12L.?
    ```

@def <> ->  Range

    Returns Long.Range from current to given value
    ```
      (1L <> 10L).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Long.Range from current to given value exclusive
    ```
      (1L <>> 10L).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Long.Range starting at current value and with given size
    ```
      (5L <>= 10L).TP  // Prints 5 <> 14
    ```

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val v = 5L

      v.atLeast(0).TP   // Prints 5

      v.atLeast(10).TP  // Prints 10
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
      val v = 5L

      v.atMost(0).TP   // Prints 0

      v.atMost(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91L.roundTo(5).TP            // Prints 90

      91L.roundTo(5)(using UP).TP  // Prints 95
    ```

@def ByteCount -> Make ByteCount

                [[scalqa.gen.number.ByteCount ByteCount]] constructor attached to Long

@def Year      -> Make Year

                [[scalqa.gen.calendar.Year Year]] constructor attached to Long

@def Big       -> Make BigInteger

                [[scalqa.gen.number.BigInteger BigInteger]] constructor attached to Long

@def Percent   -> Make Percent

                [[scalqa.gen.number.Percent Percent]] constructor attached to Long

@def Week      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Weeks     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Day       -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Days      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Hour      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Hours     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Minute    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Minutes   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Second    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Seconds   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Millis    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Micros    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

@def Nanos     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Long

*/