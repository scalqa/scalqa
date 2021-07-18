package scalqa; package lang; package float; import language.implicitConversions

transparent trait _methods extends z.toPrimitives[Float]:
  extension(inline x: Float)
    @tn("Opt")   inline def ?                          : SELF.Opt      = x.cast[SELF.Opt]
    @tn("range") inline def <> (inline to: Float)      : SELF.<>       = new SELF.<>(x,to,true)
    @tn("rangeX")inline def <>>(inline to: Float)      : SELF.<>       = new SELF.<>(x,to,false)
    infix        inline def atLeast(v: Float)          : Float         = {val w=x; if(w>v) w else v }
    infix        inline def atMost(v: Float)           : Float         = {val w=x; if(w<v) w else v }
    /**/         inline def roundTo(inline size:Float)
                             (using inline r:Rounding) : Float         = r(x,size)
    /**/         inline def roundDecimal(inline d:Int)
                             (using inline r:Rounding) : Float         = r.decimal(x,d).Float
    //  -------------------------------------------------------------------------------------------------------
    /**/         inline def Big                        : BigDecimal    = BigDecimal(x)
    /**/         inline def Percent                    : Percent       = x.cast[Percent]
    /**/         inline def Week                       : Time.Length   = x.Double.Week
    /**/         inline def Weeks                      : Time.Length   = x.Double.Weeks
    /**/         inline def Day                        : Time.Length   = x.Double.Day
    /**/         inline def Days                       : Time.Length   = x.Double.Days
    /**/         inline def Hour                       : Time.Length   = x.Double.Hour
    /**/         inline def Hours                      : Time.Length   = x.Double.Hours
    /**/         inline def Minute                     : Time.Length   = x.Double.Minute
    /**/         inline def Minutes                    : Time.Length   = x.Double.Minutes
    /**/         inline def Second                     : Time.Length   = x.Double.Second
    /**/         inline def Seconds                    : Time.Length   = x.Double.Seconds
    /**/         inline def Millis                     : Time.Length   = x.Double.Millis
    /**/         inline def Micros                     : Time.Length   = x.Double.Micros
    /**/         inline def Nanos                      : Time.Length   = x.Double.Nanos

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Float Extension Methods \n\n Extension methods universaly avaialble for type scala.Float

@def ? ->  To option

    Returns Float.Opt for current value
    ```
      val o : Float.Opt = 12F.?
    ```

@def <> ->  Range

    Returns Float.<> from current to given value
    ```
      (1F <> 10F).TP  // Prints  1.0 <> 10.0
    ```


@def <>> ->  Exclusive end range

    Returns Float.<> from current to given value exclusive
    ```
      (1F <>> 10F).TP  // Prints  1.0 <>> 10.0
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

                [[scalqa.gen.number.BigDecimal BigDecimal]] constructor attached to Float

@def Percent   -> Make Percent

                [[scalqa.gen.number.Percent Percent]] constructor attached to Float

@def Week      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Weeks     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Day       -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Days      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Hour      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Hours     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Minute    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Minutes   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Second    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Seconds   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Millis    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Micros    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

@def Nanos     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Float

*/