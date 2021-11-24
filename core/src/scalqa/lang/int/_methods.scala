package scalqa; package lang; package int; import language.implicitConversions

transparent trait _methods:
  extension(inline x:Int)
    @tn("Opt")        inline def ?                         : Int.Opt           = x.cast[Long].cast[Int.Opt]
    @tn("range")      inline def <> (inline to: Int)       : Int.Range         = new Int.Range(x,to,true)
    @tn("rangeX")     inline def <>>(inline to: Int)       : Int.Range         = new Int.Range(x,to,false)
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : Int.Range         = new Int.Range(x,size)
    /**/        infix inline def max(inline v: Int)        : Int               = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/        infix inline def min(inline v: Int)        : Int               = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/              inline def roundTo(inline unit:Int)
                                        (using r:Rounding) : Int               = r(x,unit)
  //  -------------------------------------------------------------------------------------------------------
  import scalqa.gen.time.x.{ Nanos => NANOS }
  extension(inline x:Int)

    /**/              inline def ByteCount                 : ByteCount         = Gen.ByteCount(x.cast[Long])
    /**/              inline def Year                      : Year              = Gen.Year(x)
    /**/              inline def Big                       : BigInteger        = BigInteger(x.cast[Long])
    /**/              inline def Percent                   : Percent           = x.toDouble.cast[Percent]
    /**/              inline def Week                      : Time.Length       = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Weeks                     : Time.Length       = (x * NANOS.InOneWeek).Nanos
    /**/              inline def Day                       : Time.Length       = (x * NANOS.InOneDay).Nanos
    /**/              inline def Days                      : Time.Length       = (x * NANOS.InOneDay).Nanos
    /**/              inline def Hour                      : Time.Length       = (x * NANOS.InOneHour).Nanos
    /**/              inline def Hours                     : Time.Length       = (x * NANOS.InOneHour).Nanos
    /**/              inline def Minute                    : Time.Length       = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Minutes                   : Time.Length       = (x * NANOS.InOneMinute).Nanos
    /**/              inline def Second                    : Time.Length       = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Seconds                   : Time.Length       = (x * NANOS.InOneSecond).Nanos
    /**/              inline def Millis                    : Time.Length       = (x * NANOS.InOneMillis).Nanos
    /**/              inline def Micros                    : Time.Length       = (x * NANOS.InOneMicros).Nanos
    /**/              inline def Nanos                     : Time.Length       = x.cast[Long].Nanos

    /**/              inline def toByte                    : Byte              = x.cast[Byte]
    /**/              inline def toChar                    : Char              = x.cast[Char]
    /**/              inline def toShort                   : Short             = x.cast[Short]
    /**/              inline def toInt                     : Int               = x
    /**/              inline def toLong                    : Long              = x.cast[Long]
    /**/              inline def toFloat                   : Float             = x.cast[Float]
    /**/              inline def toDouble                  : Double            = x.cast[Double]
    /**/              inline def toNumber                  : java.lang.Integer = java.lang.Integer.valueOf(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Int Extension Methods \n\n Extension methods universaly avaialble for type scala.Int

@def ? ->  To option

    Returns Int.Opt for current value
    ```
      val o : Int.Opt = 12.?
    ```

@def <> ->  Range

    Returns Int.Range from current to given value
    ```
      (1 <> 10).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Int.Range from current to given value exclusive
    ```
      (1 <>> 10).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Int.Range starting at current value and with given size
    ```
      (5 <>= 10).TP  // Prints 5 <> 14
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val b = 5

      b.max(0).TP   // Prints 5

      b.max(10).TP  // Prints 10
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
      val b = 5

      b.min(0).TP   // Prints 0

      b.min(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.roundTo(5).TP            // Prints 90

      91.roundTo(5)(using UP).TP  // Prints 95
    ```

@def ByteCount -> Make ByteCount

                [[scalqa.gen.number.ByteCount ByteCount]] constructor attached to Int

@def Year      -> Make Year

                [[scalqa.gen.calendar.Year Year]] constructor attached to Int

@def Big       -> Make BigInteger

                [[scalqa.gen.number.BigInteger BigInteger]] constructor attached to Int

@def Percent   -> Make Percent

                [[scalqa.gen.number.Percent Percent]] constructor attached to Int

@def Week      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Weeks     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Day       -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Days      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Hour      -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Hours     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Minute    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Minutes   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Second    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Seconds   -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Millis    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Micros    -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def Nanos     -> Make Time.Length

                [[scalqa.gen.time.Length Time.Length]] constructor attached to Int

@def toByte    -> Make Byte        \n\n  Attached Byte constructor
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Returns underlying value
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/