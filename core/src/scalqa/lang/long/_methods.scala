package scalqa; package lang; package long; import language.implicitConversions

import scalqa.gen.time.x.{ Nanos => NANOS }

transparent trait _methods:

  extension(inline x:Long)
    @tn("Opt")        inline def ?                         : Long.Opt       = {val v=x; if(v==g.Opt.void.cast[Long]) throw ZZ.LO(); v.cast[Long.Opt]}
    @tn("range")      inline def <> (inline to: Long)      : Long.<>        = new Long.<>(x,to,true)
    @tn("rangeX")     inline def <>>(inline to: Long)      : Long.<>        = new Long.<>(x,to,false)
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : Long.<>        = {val v=x; new lang.Long.<>(v,v+size,false)}
    /**/        infix inline def max(inline v: Long)       : Long           = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/        infix inline def min(inline v: Long)       : Long           = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/              inline def tagBrief                  : String         = Z.tagBrief(x)
    /**/              inline def roundTo(inline unit:Long)
                                        (using r:Rounding) : Long           = r(x,unit)
    //  -------------------------------------------------------------------------------------------------------
    /**/              inline def ByteCount                 : ByteCount      = Gen.ByteCount(x)
    /**/              inline def Year                      : Year           = Gen.Year(x.toInt)
    /**/              inline def Big                       : BigInteger     = Gen.BigInteger(x)
    /**/              inline def Percent                   : Percent        = Gen.Percent(x.toDouble)
    /**/              inline def Week                      : Time.Length    = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Weeks                     : Time.Length    = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Day                       : Time.Length    = (x * NANOS.InOneDay).Nanos
    /**/              inline def Days                      : Time.Length    = (x * NANOS.InOneDay).Nanos
    /**/              inline def Hour                      : Time.Length    = (x * NANOS.InOneHour).Nanos
    /**/              inline def Hours                     : Time.Length    = (x * NANOS.InOneHour).Nanos
    /**/              inline def Minute                    : Time.Length    = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Minutes                   : Time.Length    = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Second                    : Time.Length    = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Seconds                   : Time.Length    = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Millis                    : Time.Length    = (x * NANOS.InOneMillis).Nanos
    /**/              inline def Micros                    : Time.Length    = (x * NANOS.InOneMicros).Nanos
    /**/              inline def Nanos                     : Time.Length    = x.cast[Time.Length]

    /**/              inline def toByte                    : Byte           = x.cast[Byte]
    /**/              inline def toChar                    : Char           = x.cast[Char]
    /**/              inline def toShort                   : Short          = x.cast[Short]
    /**/              inline def toInt                     : Int            = x.cast[Int]
    /**/              inline def toLong                    : Long           = x
    /**/              inline def toFloat                   : Float          = x.cast[Float]
    /**/              inline def toDouble                  : Double         = x.cast[Double]
    /**/              inline def toNumber                  : java.lang.Long = java.lang.Long.valueOf(x)

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

    Returns Long.<> from current to given value
    ```
      (1L <> 10L).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Long.<> from current to given value exclusive
    ```
      (1L <>> 10L).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Long.Range starting at current value and with given size
    ```
      (5L <>= 10L).TP  // Prints 5 <> 14
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val v = 5L

      v.max(0).TP   // Prints 5

      v.max(10).TP  // Prints 10
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
      val v = 5L

      v.min(0).TP   // Prints 0

      v.min(10).TP  // Prints 5
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


@def toByte    -> Make Byte        \n\n  Returns underlying value
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/