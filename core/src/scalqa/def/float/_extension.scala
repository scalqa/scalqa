package scalqa; package `def`; package float; import language.implicitConversions

import java.lang.{ Float => NUMBER }

transparent trait _extension:
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
    /**/         inline def Byte                       : Byte          = x.toByte
    /**/         inline def Char                       : Char          = x.toChar
    /**/         inline def Short                      : Short         = x.toShort
    /**/         inline def Int                        : Int           = x.toInt
    /**/         inline def Long                       : Long          = x.toLong
    /**/         inline def Float                      : Float         = x
    /**/         inline def Double                     : Double        = x.toDouble
    /**/         inline def Number                     : NUMBER        = NUMBER.valueOf(x)

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
@trait _extension -> ### Float Extension Methods \n\n Extension methods universaly avaialble for type scala.Float

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

@def Byte    -> To Byte

                Byte constructor attached to Float

@def Char    -> To Char

                Char constructor attached to Float

@def Short   -> To Short

                Short constructor attached to Float

@def Int     -> To Int

                Int constructor attached to Float

@def Long    -> To Long

                Long constructor attached to Float

@def Float   -> To Float

                Returns itself

                Operation provided for consistency

@def Double  -> To Double

                Double constructor attached to Float

@def Number  -> To Number

                Number constructor attached to Float

@def Big       -> To BigDecimal

                [[scalqa.gen.number.BigDecimal$.opaque BigDecimal]] constructor attached to Float

@def Percent   -> To Percent

                [[scalqa.gen.number.Percent$.opaque Percent]] constructor attached to Float

@def Week      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Weeks     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Day       -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Days      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Hour      -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Hours     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Minute    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Minutes   -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Second    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Seconds   -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Millis    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Micros    -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

@def Nanos     -> To Time.Length

                [[scalqa.gen.time.Length$.opaque Time.Length]] constructor attached to Float

*/