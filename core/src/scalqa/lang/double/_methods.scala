package scalqa; package lang; package double; import language.implicitConversions

import scalqa.gen.time.x.{ Nanos => NANOS }

transparent trait _methods:
  extension(inline x:Double)
    @tn("Opt")   inline def ?                          : Double.Opt       = x.cast[Double.Opt]
    @tn("range") inline def <> (inline to: Double)     : Double.Range     = new Double.Range(x,to,true)
    @tn("rangeX")inline def <>>(inline to: Double)     : Double.Range     = new Double.Range(x,to,false)
    /**/   infix inline def max(inline v: Double)      : Double           = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/   infix inline def min(inline v: Double)      : Double           = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/         inline def roundTo(inline unit:Double)
                             (using inline r:Rounding) : Double           = r(x,unit)
    /**/         inline def roundToDecimal(inline d:Int)
                             (using inline r:Rounding) : Double           = r.decimal(x,d)

    //  -------------------------------------------------------------------------------------------------------
    /**/         inline def Big                        : BigDecimal       = Gen.BigDecimal(x)
    /**/         inline def Percent                    : Percent          = x.cast[Percent]

    /**/         inline def Week                       : Time.Length      = (x * NANOS.InOneWeek).Nanos
    /**/         inline def Weeks                      : Time.Length      = (x * NANOS.InOneWeek).Nanos
    /**/         inline def Day                        : Time.Length      = (x * NANOS.InOneDay).Nanos
    /**/         inline def Days                       : Time.Length      = (x * NANOS.InOneDay).Nanos
    /**/         inline def Hour                       : Time.Length      = (x * NANOS.InOneHour).Nanos
    /**/         inline def Hours                      : Time.Length      = (x * NANOS.InOneHour).Nanos
    /**/         inline def Minute                     : Time.Length      = (x * NANOS.InOneMinute).Nanos
    /**/         inline def Minutes                    : Time.Length      = (x * NANOS.InOneMinute).Nanos
    /**/         inline def Second                     : Time.Length      = (x * NANOS.InOneSecond).Nanos
    /**/         inline def Seconds                    : Time.Length      = (x * NANOS.InOneSecond).Nanos
    /**/         inline def Millis                     : Time.Length      = (x * NANOS.InOneMillis).Nanos
    /**/         inline def Micros                     : Time.Length      = (x * NANOS.InOneMicros).Nanos
    /**/         inline def Nanos                      : Time.Length      = x.toLong.cast[Time.Length]


    /**/         inline def toByte                     : Byte             = x.cast[Byte]
    /**/         inline def toChar                     : Char             = x.cast[Char]
    /**/         inline def toShort                    : Short            = x.cast[Short]
    /**/         inline def toInt                      : Int              = x.cast[Int]
    /**/         inline def toLong                     : Long             = x.cast[Long]
    /**/         inline def toFloat                    : Float            = x.cast[Float]
    /**/         inline def toDouble                   : Double           = x
    /**/         inline def toNumber                   : java.lang.Double = java.lang.Double.valueOf(x)

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

    Returns Double.Range from current to given value
    ```
      (1.0 <> 10.0).TP  // Prints  1.0 <> 10.0
    ```


@def <>> ->  Exclusive end range

    Returns Double.Range from current to given value exclusive
    ```
      (1.0 <>> 10.0).TP  // Prints  1.0 <>> 10.0
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

@def toByte    -> Make Byte        \n\n  Attached Byte constructor
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Returns underlying value
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/