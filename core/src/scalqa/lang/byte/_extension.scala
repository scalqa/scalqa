package scalqa; package lang; package byte; import language.implicitConversions

import java.lang.{ Byte => NUMBER }

transparent trait _extension:
  extension(inline x:Byte)
    @tn("Opt")        inline def ?                        : SELF.Opt     = x.cast[SELF.Opt]
    @tn("range")      inline def <> (inline to: Byte)     : SELF.<>      = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Byte)     : SELF.<>      = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int)    : SELF.<>      = new SELF.<>(x,size)
    infix             inline def atLeast(v: Byte)         : Byte         = {val w=x; if(w>v) w else v }
    infix             inline def atMost(v: Byte)          : Byte         = {val w=x; if(w<v) w else v }
    /**/              inline def roundTo(inline size:Int)
                                       (using r:Rounding) : Byte         = r(x,size.Byte)
    //  -------------------------------------------------------------------------------------------------------
    /**/              inline def Byte                     : Byte         = x.toByte
    /**/              inline def Char                     : Char         = x.toChar
    /**/              inline def Short                    : Short        = x.toShort
    /**/              inline def Int                      : Int          = x.toInt
    /**/              inline def Long                     : Long         = x.toLong
    /**/              inline def Float                    : Float        = x.toFloat
    /**/              inline def Double                   : Double       = x.toDouble
    /**/              inline def Number                   : NUMBER       = NUMBER.valueOf(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extension -> ### Byte Extension Methods \n\n Extension methods universaly avaialble for type scala.Byte

@def ? ->  To option

    Returns Byte.Opt for current value
    ```
      val o : Byte.Opt = 12.Byte.?
    ```

@def <> ->  Range

    Returns Byte.Range from current to given value
    ```
      (1.Byte <> 10.Byte).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Byte.Range from current to given value exclusive
    ```
      (1.Byte <>> 10.Byte).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Byte.Range starting at current value and with given size
    ```
      (5.Byte <>= 10).TP  // Prints 5 <> 14
    ```

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val b = 5.Byte

      b.atLeast(0).TP   // Prints 5

      b.atLeast(10).TP  // Prints 10
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
      val b = 5.Byte

      b.atMost(0).TP   // Prints 0

      b.atMost(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.Byte.roundTo(5).TP            // Prints 90

      91.Byte.roundTo(5)(using UP).TP  // Prints 95
    ```

@def Byte    -> Make Byte

                Returns itself

                Operation provided for consistency

@def Char    -> Make Char

                Char constructor attached to Byte

@def Short   -> Make Short

                Short constructor attached to Byte

@def Int     -> Make Int

                Int constructor attached to Byte

@def Long    -> Make Long

                Long constructor attached to Byte

@def Float   -> Make Float

                Float constructor attached to Byte

@def Double  -> Make Double

                Double constructor attached to Byte

@def Number  -> Make Number

                Number constructor attached to Byte
*/