package scalqa; package lang; package byte; import language.implicitConversions

transparent trait _methods:

  extension(inline x:Byte)
    @tn("Opt")        inline def ?                        : Byte.Opt       = x.cast[Byte.Opt]
    @tn("range")      inline def <> (inline to: Byte)     : Byte.<>        = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Byte)     : Byte.<>        = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int)    : Byte.<>        = new Byte.<>(x,size)
    /**/        infix inline def max(inline v: Byte)      : Byte           = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/        infix inline def min(inline v: Byte)      : Byte           = {val y=x; val w=v; if(y.real < w.real) y else w }
    /**/              inline def roundTo(inline unit:Int)
                                       (using r:Rounding) : Byte           = r(x,unit.toByte)

    /**/              inline def toByte                   : Byte           = x
    /**/              inline def toChar                   : Char           = x.cast[Char]
    /**/              inline def toShort                  : Short          = x.cast[Short]
    /**/              inline def toInt                    : Int            = x.cast[Int]
    /**/              inline def toLong                   : Long           = x.cast[Long]
    /**/              inline def toFloat                  : Float          = x.cast[Float]
    /**/              inline def toDouble                 : Double         = x.cast[Double]
    /**/              inline def toNumber                 : java.lang.Byte = java.lang.Byte.valueOf(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Byte Extension Methods \n\n Extension methods universaly avaialble for type scala.Byte

@def ? ->  To option

    Returns Byte.Opt for current value
    ```
      val o : Byte.Opt = 12.Byte.?
    ```

@def <> ->  Range

    Returns Byte.<> from current to given value
    ```
      (1.Byte <> 10.Byte).TP  // Prints  1 <> 10
    ```


@def <>> ->  Exclusive end range

    Returns Byte.<> from current to given value exclusive
    ```
      (1.Byte <>> 10.Byte).TP  // Prints  1 <> 9
    ```

@def <>= ->  Range by size

    Returns Byte.Range starting at current value and with given size
    ```
      (5.Byte <>= 10).TP  // Prints 5 <> 14
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val b = 5.Byte

      b.max(0).TP   // Prints 5

      b.max(10).TP  // Prints 10
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
      val b = 5.Byte

      b.min(0).TP   // Prints 0

      b.min(10).TP  // Prints 5
    ```

@def roundTo -> Round to size

      Rounds current value to specified size

    ```
      91.Byte.roundTo(5).TP            // Prints 90

      91.Byte.roundTo(5)(using UP).TP  // Prints 95
    ```

@def toByte    -> Make Byte        \n\n  Returns underlying value
@def toChar    -> Make Char        \n\n  Attached Char constructor
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toNumber  -> Make Number      \n\n  Attached Number constructor
*/