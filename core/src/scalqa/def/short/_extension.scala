package scalqa; package `def`; package short; import language.implicitConversions

import java.lang.{ Short => NUMBER }

transparent trait _extension:
  extension(inline x:Short)
    @tn("Opt")        inline def ?                         : SELF.Opt     = x.cast[SELF.Opt]
    @tn("range")      inline def <> (inline to: Short)     : SELF.<>      = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Short)     : SELF.<>      = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : SELF.<>      = new SELF.<>(x,size)
    infix             inline def atLeast(v: Short)         : Short        = {val w=x; if(w>v) w else v }
    infix             inline def atMost(v: Short)          : Short        = {val w=x; if(w<v) w else v }
    /**/              inline def roundTo(inline size:Int)
                                        (using r:Rounding) : Short        = r(x,size.Short)
    //  -------------------------------------------------------------------------------------------------------
    /**/              inline def Byte                      : Byte         = x.toByte
    /**/              inline def Char                      : Char         = x.toChar
    /**/              inline def Short                     : Short        = x.toShort
    /**/              inline def Int                       : Int          = x.toInt
    /**/              inline def Long                      : Long         = x.toLong
    /**/              inline def Float                     : Float        = x.toFloat
    /**/              inline def Double                    : Double       = x.toDouble
    /**/              inline def Number                    : NUMBER       = NUMBER.valueOf(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extension -> ### Short Extension Methods \n\n Extension methods universaly avaialble for type scala.Short

@def ? ->  To option

    Returns Short.Opt for current value
    ```
      val o : Short.Opt = 12.Short.?
    ```

@def <> ->  Range

    Returns Short.Range from current to given value
    ```
      (1.Short <> 10.Short).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Short.Range from current to given value exclusive
    ```
      (1.Short <>> 10.Short).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Short.Range starting at current value and with given size
    ```
      (5.Short <>= 10).TP  // Prints 5 <> 14
    ```

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val b = 5.Short

      b.atLeast(0).TP   // Prints 5

      b.atLeast(10).TP  // Prints 10
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
      val b = 5.Short

      b.atMost(0).TP   // Prints 0

      b.atMost(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.Short.roundTo(5).TP            // Prints 90

      91.Short.roundTo(5)(using UP).TP  // Prints 95
    ```

@def Byte    -> To Byte

                Byte constructor attached to Short

@def Char    -> To Char

                Char constructor attached to Short

@def Short   -> To Short

                Returns itself

                Operation provided for consistency

@def Int     -> To Int

                Int constructor attached to Short

@def Long    -> To Long

                Long constructor attached to Short

@def Float   -> To Float

                Float constructor attached to Short

@def Double  -> To Double

                Double constructor attached to Short

@def Number  -> To Number

                Number constructor attached to Short
*/