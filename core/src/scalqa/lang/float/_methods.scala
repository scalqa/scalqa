package scalqa; package lang; package float; import language.implicitConversions

transparent trait _methods:
  extension(inline x: Float)
    @tn("Opt")   inline def ?                          : Float.Opt       = x.cast[Float.Opt]
    @tn("range") inline def <> (inline to: Float)      : Float.Range     = new Float.Range(x,to,true)
    @tn("rangeX")inline def <>>(inline to: Float)      : Float.Range     = new Float.Range(x,to,false)
    /**/   infix inline def max(inline v: Float)       : Float           = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/   infix inline def min(inline v: Float)       : Float           = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/         inline def roundTo(inline unit:Float)
                             (using inline r:Rounding) : Float           = r(x,unit)
    /**/         inline def roundToDecimal(inline d:Int)
                             (using inline r:Rounding) : Float           = r.decimal(x,d).toFloat
    //  -------------------------------------------------------------------------------------------------------
    /**/         inline def Big                        : BigDecimal      = BigDecimal(x)
    /**/         inline def Percent                    : Percent         = x.cast[Percent]
    /**/         inline def Week                       : Time.Length     = x.toDouble.Week
    /**/         inline def Weeks                      : Time.Length     = x.toDouble.Weeks
    /**/         inline def Day                        : Time.Length     = x.toDouble.Day
    /**/         inline def Days                       : Time.Length     = x.toDouble.Days
    /**/         inline def Hour                       : Time.Length     = x.toDouble.Hour
    /**/         inline def Hours                      : Time.Length     = x.toDouble.Hours
    /**/         inline def Minute                     : Time.Length     = x.toDouble.Minute
    /**/         inline def Minutes                    : Time.Length     = x.toDouble.Minutes
    /**/         inline def Second                     : Time.Length     = x.toDouble.Second
    /**/         inline def Seconds                    : Time.Length     = x.toDouble.Seconds
    /**/         inline def Millis                     : Time.Length     = x.toDouble.Millis
    /**/         inline def Micros                     : Time.Length     = x.toDouble.Micros
    /**/         inline def Nanos                      : Time.Length     = x.toDouble.Nanos

    /**/         inline def toByte                     : Byte            = x.cast[Byte]
    /**/         inline def toChar                     : Char            = x.cast[Char]
    /**/         inline def toShort                    : Short           = x.cast[Short]
    /**/         inline def toInt                      : Int             = x.cast[Int]
    /**/         inline def toLong                     : Long            = x.cast[Long]
    /**/         inline def toFloat                    : Float           = x.real
    /**/         inline def toDouble                   : Double          = x.cast[Double]
    /**/         inline def toNumber                   : java.lang.Float = java.lang.Float.valueOf(x)

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

    Returns Float.Range from current to given value
    ```
      (1F <> 10F).TP  // Prints  1.0 <> 10.0
    ```


@def <>> ->  Exclusive end range

    Returns Float.Range from current to given value exclusive
    ```
      (1F <>> 10F).TP  // Prints  1.0 <>> 10.0
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val v = 5F

      v.max(0).TP   // Prints 5.0

      v.max(10).TP  // Prints 10.0
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
      val v = 5F

      v.min(0).TP   // Prints 0.0

      v.min(10).TP  // Prints 5.0
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91F.roundTo(5).TP            // Prints 90.0

      91F.roundTo(5)(using UP).TP  // Prints 95.0
    ```

@def roundToDecimal -> Round to decimal \n\n  Rounds current value to specified decimal position of fractional value

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

@def toByte    -> Make Byte        \n\n  Attached Byte constructor
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Returns underlying value
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/