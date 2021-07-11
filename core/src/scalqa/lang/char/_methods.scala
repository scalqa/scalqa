package scalqa; package lang; package char; import language.implicitConversions

transparent trait _methods extends z.toPrimitives[Char]:
  extension(inline x:Char)
    @tn("Opt")        inline def ?                                 : SELF.Opt     = x.toInt.cast[SELF.Opt]
    @tn("range")      inline def <> (inline to: Char)              : SELF.<>      = {val w=x; w <>= to-w+1 }
    @tn("rangeX")     inline def <>>(inline to: Char)              : SELF.<>      = {val w=x; w <>= to-w   }
    @tn("rangeOfSize")inline def <>=(inline size: Int)             : SELF.<>      = new SELF.<>(x,size)
    infix             inline def atLeast(v: Char)                  : Char         = {val w=x; if(w>v) w else v }
    infix             inline def atMost(v: Char)                   : Char         = {val w=x; if(w<v) w else v }
    //  -------------------------------------------------------------------------------------------------------
    /**/              inline def name                              : String       = Character.getName(x)
    /**/              inline def isAlphabetic                      : Boolean      = Character.isAlphabetic(x)
    /**/              inline def isDigit                           : Boolean      = Character.isDigit(x)
    /**/              inline def isLetter                          : Boolean      = Character.isLetter(x)
    /**/              inline def isLetterOrDigit                   : Boolean      = Character.isLetterOrDigit(x)
    /**/              inline def isTitleCase                       : Boolean      = Character.isTitleCase(x)
    /**/              inline def isLowerCase                       : Boolean      = Character.isLowerCase(x)
    /**/              inline def isUpperCase                       : Boolean      = Character.isUpperCase(x)
    /**/              inline def isWhitespace                      : Boolean      = Character.isWhitespace(x)
    /**/              inline def toTitleCase                       : Char         = Character.toTitleCase(x)
    /**/              inline def toLowerCase                       : Char         = Character.toLowerCase(x)
    /**/              inline def toUpperCase                       : Char         = Character.toUpperCase(x)

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

@def atLeast -> Max

    Returns maximum of current or given value

    ```
      val v = 'D'

      v.atLeast('A').TP   // Prints D

      v.atLeast('F').TP   // Prints F
    ```

@def atMost -> Min

    Returns minimun of current or given value

    ```
    val v = 'D'

    v.atMost('A').TP   // Prints A

    v.atMost('F').TP   // Prints D
    ```

@def name            -> Char name                \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#getName(int) java.lang.Character.getName]]
@def isAlphabetic    -> Is alphabetic check      \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isAlphabetic(int) java.lang.Character.isAlphabetic]]
@def isDigit         -> Is digit check           \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isDigit(int) java.lang.Character.isDigit]]
@def isLetter        -> Is letter check          \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLetter(int) java.lang.Character.isLetter]]
@def isLetterOrDigit -> Is letter or digit check \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLetterOrDigit(int) java.lang.Character.isLetterOrDigit]]
@def isTitleCase     -> Title case check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isTitleCase(int) java.lang.Character.isTitleCase]]
@def isLowerCase     -> Lower case check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isLowerCase(int) java.lang.Character.isLowerCase]]
@def isUpperCase     -> Upper case check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isUpperCase(int) java.lang.Character.isUpperCase]]
@def isWhitespace    -> Whitespace check         \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isWhitespace(int) java.lang.Character.isWhitespace]]
@def toTitleCase     -> Make title case            \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#toTitleCase(int) java.lang.Character.toTitleCase]]
@def toLowerCase     -> Make lower case            \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#toLowerCase(int) java.lang.Character.toLowerCase]]
@def toUpperCase     -> Make upper case            \n\n Inlines call to [[https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#toUpperCase(int) java.lang.Character.toUpperCase]]

*/