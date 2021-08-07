package scalqa; package lang; package short; import language.implicitConversions

transparent trait _methods:
  extension(inline x:Short)
    @tn("Opt")        inline def ?                         : lang.Short.Opt  = x.cast[lang.Short.Opt]
    @tn("range")      inline def <> (inline to: Short)     : lang.Short.<>   = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Short)     : lang.Short.<>   = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int)     : lang.Short.<>   = new lang.Short.<>(x,size)
    /**/        infix inline def max(inline v: Short)      : Short           = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/        infix inline def min(inline v: Short)      : Short           = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/              inline def roundTo(inline unit:Int)
                                        (using r:Rounding) : Short           = r(x,unit.toShort)

    /**/              inline def toByte                    : Byte            = x.cast[Byte]
    /**/              inline def toChar                    : Char            = x.cast[Char]
    /**/              inline def toShort                   : Short           = x
    /**/              inline def toInt                     : Int             = x.cast[Int]
    /**/              inline def toLong                    : Long            = x.cast[Long]
    /**/              inline def toFloat                   : Float           = x.cast[Float]
    /**/              inline def toDouble                  : Double          = x.cast[Double]
    /**/              inline def toNumber                  : java.lang.Short = java.lang.Short.valueOf(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Short Extension Methods \n\n Extension methods universaly avaialble for type scala.Short

@def ? ->  To option

    Returns Short.Opt for current value
    ```
      val o : Short.Opt = 12.Short.?
    ```

@def <> ->  Range

    Returns Short.<> from current to given value
    ```
      (1.Short <> 10.Short).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Short.<> from current to given value exclusive
    ```
      (1.Short <>> 10.Short).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Short.Range starting at current value and with given size
    ```
      (5.Short <>= 10).TP  // Prints 5 <> 14
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val b = 5.Short

      b.max(0).TP   // Prints 5

      b.max(10).TP  // Prints 10
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
      val b = 5.Short

      b.min(0).TP   // Prints 0

      b.min(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.Short.roundTo(5).TP            // Prints 90

      91.Short.roundTo(5)(using UP).TP  // Prints 95
    ```
@def toByte    -> Make Byte        \n\n  Attached Byte constructor
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Returns underlying value
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/