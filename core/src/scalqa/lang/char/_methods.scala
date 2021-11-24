package scalqa; package lang; package char; import language.implicitConversions

transparent trait _methods:
  extension(inline x:Char)
    @tn("Opt")        inline def ?                     : Char.Opt            = x.toInt.cast[Char.Opt]
    @tn("range")      inline def <> (inline to: Char)  : Char.Range          = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Char)  : Char.Range          = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int) : Char.Range          = new Char.Range(x,size)
    /**/        infix inline def max(inline v: Char)   : Char                = {val y=x; val w=v; if(y.real > w.real) y else w }
    /**/        infix inline def min(inline v: Char)   : Char                = {val y=x; val w=v; if(y.real < w.real) y else w }
    //  -------------------------------------------------------------------------------------------------------
    /**/              inline def name                  : String              = Character.getName(x)
    /**/              inline def isAlphabetic          : Boolean             = Character.isAlphabetic(x)
    /**/              inline def isDigit               : Boolean             = Character.isDigit(x)
    /**/              inline def isLetter              : Boolean             = Character.isLetter(x)
    /**/              inline def isLetterOrDigit       : Boolean             = Character.isLetterOrDigit(x)
    /**/              inline def isLower               : Boolean             = Character.isLowerCase(x)
    /**/              inline def isUpper               : Boolean             = Character.isUpperCase(x)
    /**/              inline def isWhitespace          : Boolean             = Character.isWhitespace(x)
    /**/              inline def lower                 : Char                = Character.toLowerCase(x)
    /**/              inline def upper                 : Char                = Character.toUpperCase(x)

    /**/              inline def toByte                : Byte                = x.cast[Byte]
    /**/              inline def toChar                : Char                = x
    /**/              inline def toShort               : Short               = x.cast[Short]
    /**/              inline def toInt                 : Int                 = x.cast[Int]
    /**/              inline def toLong                : Long                = x.cast[Long]
    /**/              inline def toFloat               : Float               = x.cast[Float]
    /**/              inline def toDouble              : Double              = x.cast[Double]
    /**/              inline def toRef                 : java.lang.Character = java.lang.Character.valueOf(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Char Extension Methods \n\n Extension methods universaly avaialble for type scala.Char

@def ? ->  To option

    Returns Char.Opt for current value
    ```
      val o : Char.Opt = 'A'.?
    ```

@def <> ->  Range

    Returns Char.Range from current to given value
    ```
      ('a' <> 'd').TP  // Prints  a <> d
    ```


@def <>> ->  Exclusive end range

    Returns Char.Range from current to given value exclusive
    ```
      ('a' <>> 'd').TP  // Prints  a <> c
    ```

@def <>= ->  Range by size

    Returns Char.Range starting at current value and with given size
    ```
      ('a' <>= 5).TP  // Prints a <> e
    ```

@def max -> Max value

    Returns maximum of current or given value

    ```
      val v = 'D'

      v.max('A').TP   // Prints D

      v.max('F').TP   // Prints F
    ```

@def min -> Min value

    Returns minimun of current or given value

    ```
    val v = 'D'

    v.min('A').TP   // Prints A

    v.min('F').TP   // Prints D
    ```

@def name            -> Char name                \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#getName(int) java.lang.Character.getName]]
@def isAlphabetic    -> Is alphabetic check      \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isAlphabetic(int) java.lang.Character.isAlphabetic]]
@def isDigit         -> Is digit check           \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isDigit(int) java.lang.Character.isDigit]]
@def isLetter        -> Is letter check          \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLetter(int) java.lang.Character.isLetter]]
@def isLetterOrDigit -> Is letter or digit check \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLetterOrDigit(int) java.lang.Character.isLetterOrDigit]]
@def isLower         -> Lower case check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLowerCase(int) java.lang.Character.isLowerCase]]
@def isUpper         -> Upper case check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isUpperCase(int) java.lang.Character.isUpperCase]]
@def isWhitespace    -> Whitespace check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isWhitespace(int) java.lang.Character.isWhitespace]]
@def lower           -> Make lower case          \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#toLowerCase(int) java.lang.Character.toLowerCase]]
@def upper           -> Make upper case          \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#toUpperCase(int) java.lang.Character.toUpperCase]]

@def toByte    -> Make Byte        \n\n  Attached Byte constructor
@def toChar    -> Make Char        \n\n  Returns underlying value
@def toShort   -> Make Short       \n\n  Attached Short constructor
@def toInt     -> Make Int         \n\n  Attached Int constructor
@def toLong    -> Make Long        \n\n  Attached Long constructor
@def toFloat   -> Make Float       \n\n  Attached Float constructor
@def toDouble  -> Make Double      \n\n  Attached Double constructor
@def toRef     -> Make Character   \n\n  Attached Character constructor
*/