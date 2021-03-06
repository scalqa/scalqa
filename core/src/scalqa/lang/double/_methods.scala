package scalqa; package lang; package double; import language.implicitConversions

import scalqa.gen.time.x.{ Nanos => NANOS }

transparent trait _methods extends z.toPrimitives[Double]:
  extension(inline x:Double)
    @tn("Opt")   inline def ?                          : SELF.Opt      = x.cast[SELF.Opt]
    @tn("range") inline def <> (inline to: Double)     : SELF.<>       = new SELF.<>(x,to,true)
    @tn("rangeX")inline def <>>(inline to: Double)     : SELF.<>       = new SELF.<>(x,to,false)
    infix        inline def atLeast(v: Double)         : Double        = {val w=x; if(w>v) w else v }
    infix        inline def atMost(v: Double)          : Double        = {val w=x; if(w<v) w else v }
    /**/         inline def roundTo(inline size:Double)
                             (using inline r:Rounding) : Double        = r(x,size)
    /**/         inline def roundDecimal(inline d:Int)
                             (using inline r:Rounding) : Double        = r.decimal(x,d)

    //  -------------------------------------------------------------------------------------------------------
    /**/         inline def Big                        : BigDecimal    = Gen.BigDecimal(x)
    /**/         inline def Percent                    : Percent       = x.cast[Percent]

    /**/         inline def Week                       : Time.Length   = (x * NANOS.InOneWeek).Nanos
    /**/         inline def Weeks                      : Time.Length   = (x * NANOS.InOneWeek).Nanos
    /**/         inline def Day                        : Time.Length   = (x * NANOS.InOneDay).Nanos
    /**/         inline def Days                       : Time.Length   = (x * NANOS.InOneDay).Nanos
    /**/         inline def Hour                       : Time.Length   = (x * NANOS.InOneHour).Nanos
    /**/         inline def Hours                      : Time.Length   = (x * NANOS.InOneHour).Nanos
    /**/         inline def Minute                     : Time.Length   = (x * NANOS.InOneMinute).Nanos
    /**/         inline def Minutes                    : Time.Length   = (x * NANOS.InOneMinute).Nanos
    /**/         inline def Second                     : Time.Length   = (x * NANOS.InOneSecond).Nanos
    /**/         inline def Seconds                    : Time.Length   = (x * NANOS.InOneSecond).Nanos
    /**/         inline def Millis                     : Time.Length   = (x * NANOS.InOneMillis).Nanos
    /**/         inline def Micros                     : Time.Length   = (x * NANOS.InOneMicros).Nanos
    /**/         inline def Nanos                      : Time.Length   = x.Long.cast[Time.Length]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Double Extension Methods \n\n Extension methods universaly avaialble for type scala.Double

@def ? ->  To option

    Returns Double.Opt for current value
    ```
      val o : Double.Opt = 12.0.?
    ```

@def <> ->  Range

    Returns Double.<> from current to given value
    ```
      (1.0 <> 10.0).TP  // Prints  1.0 <> 10.0
    ```


@def <>> ->  Exclusive end range

    Returns Double.<> from current to given value exclusive
    ```
      (1.0 <>> 10.0).TP  // Prints  1.0 <>> 10.0
    ```

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val v = 5F

      v.atLeast(0).TP   // Prints 5.0

      v.atLeast(10).TP  // Prints 10.0
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
      val v = 5F

      v.atMost(0).TP   // Prints 0.0

      v.atMost(10).TP  // Prints 5.0
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91F.roundTo(5).TP            // Prints 90.0

      91F.roundTo(5)(using UP).TP  // Prints 95.0
    ```

@def Big       -> Make BigDecimal

                [[scalqa.gen.number.BigDecimal BigDecimal]] constructor attached to Double

@def Percent   -> Make Percent

                [[scalqa.gen.number.Percent Percent]] constructor attached to Double

@def Week      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Weeks     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Day       -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Days      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Hour      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Hours     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Minute    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Minutes   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Second    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Seconds   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Millis    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Micros    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double

@def Nanos     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Double
*/