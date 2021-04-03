package scalqa; package `def`; package int; import language.implicitConversions

import java.lang.{ Integer => NUMBER }

transparent trait _extension:
  extension(inline x:Int)
    @tn("Opt")        inline def ?                         : SELF.Opt      = x.toLong.cast[SELF.Opt]
    @tn("range")      inline def <> (inline to: Int)       : SELF.<>       = new SELF.G.<>[Int](x,to,true)
    @tn("rangeX")     inline def <>>(inline to: Int)       : SELF.<>       = new SELF.G.<>[Int](x,to,false)
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : SELF.<>       = new SELF.G.<>[Int](x,size)
    infix             inline def atLeast(v: Int)           : Int           = {val w=x; if(w>v) w else v }
    infix             inline def atMost(v: Int)            : Int           = {val w=x; if(w<v) w else v }
    /**/              inline def roundTo(inline size:Int)
                                        (using r:Rounding) : Int           = r(x,size)

  //  -------------------------------------------------------------------------------------------------------
  extension(inline x:Int)
    /**/              inline def Byte                      : Byte          = x.toByte
    /**/              inline def Char                      : Char          = x.toChar
    /**/              inline def Short                     : Short         = x.toShort
    /**/              inline def Int                       : Int           = x
    /**/              inline def Long                      : Long          = x.toLong
    /**/              inline def Float                     : Float         = x.toFloat
    /**/              inline def Double                    : Double        = x.cast[Double]
    /**/              inline def Number                    : NUMBER        = NUMBER.valueOf(x)
    /**/              inline def ByteCount                 : ByteCount     = scalqa.Gen.ByteCount(x.Long)
    /**/              inline def Year                      : Year          = scalqa.Gen.Year(x)
    /**/              inline def Big                       : BigInteger    = BigInteger(x.Long)
    /**/              inline def Percent                   : Percent       = x.toDouble.asOpaque[Percent]
    /**/              inline def Week                      : Time.Length   = x.Long.Week
    /**/              inline def Weeks                     : Time.Length   = x.Long.Weeks
    /**/              inline def Day                       : Time.Length   = x.Long.Day
    /**/              inline def Days                      : Time.Length   = x.Long.Days
    /**/              inline def Hour                      : Time.Length   = x.Long.Hour
    /**/              inline def Hours                     : Time.Length   = x.Long.Hours
    /**/              inline def Minute                    : Time.Length   = x.Long.Minute
    /**/              inline def Minutes                   : Time.Length   = x.Long.Minutes
    /**/              inline def Second                    : Time.Length   = x.Long.Second
    /**/              inline def Seconds                   : Time.Length   = x.Long.Seconds
    /**/              inline def Millis                    : Time.Length   = x.Long.Millis
    /**/              inline def Micros                    : Time.Length   = x.Long.Micros
    /**/              inline def Nanos                     : Time.Length   = x.Long.Nanos


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extension -> ### Int Extension Methods \n\n Extension methods universaly avaialble for type scala.Int

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

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val b = 5

      b.atLeast(0).TP   // Prints 5

      b.atLeast(10).TP  // Prints 10
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
      val b = 5

      b.atMost(0).TP   // Prints 0

      b.atMost(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.roundTo(5).TP            // Prints 90

      91.roundTo(5)(using UP).TP  // Prints 95
    ```

@def Byte    -> To Byte

                Byte constructor attached to Int

@def Char    -> To Char

                Char constructor attached to Int

@def Short   -> To Short

                Short constructor attached to Int

@def Int     -> To Int

                Returns itself

                Operation provided for consistency

@def Long    -> To Long

                Long constructor attached to Int

@def Float   -> To Float

                Float constructor attached to Int

@def Double  -> To Double

                Double constructor attached to Int

@def Number  -> To Number

                Number constructor attached to Int

@def ByteCount -> To ByteCount

                [[scalqa.gen.number.ByteCount$.opaque ByteCount]] constructor attached to Int

@def Year      -> To Year

                [[scalqa.gen.calendar.Year$.opaque Year]] constructor attached to Int

@def Big       -> To BigInteger

                [[scalqa.gen.number.BigInteger$.opaque BigInteger]] constructor attached to Int

@def Percent   -> To Percent

                [[scalqa.gen.number.Percent$.opaque Percent]] constructor attached to Int

@def Week      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Weeks     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Day       -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Days      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Hour      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Hours     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Minute    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Minutes   -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Second    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Seconds   -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Millis    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Micros    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

@def Nanos     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Int

*/