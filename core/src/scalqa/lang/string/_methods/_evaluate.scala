package scalqa; package lang; package string; package _methods; import language.implicitConversions

transparent trait _evaluate:

  extension(inline x: String)
    /**/                     inline def length                                                              : Int      = x.length
    /**/                     inline def contains        (inline v: String)                                  : Boolean  = x.contains(v)
    /**/                     inline def startsWith      (inline v: String)                                  : Boolean  = x.startsWith(v)
    /**/                     inline def endsWith        (inline v: String)                                  : Boolean  = x.endsWith(v)
    /**/                     inline def equalsIgnoreCase(inline v: String)                                  : Boolean  = x.equalsIgnoreCase(v)
    /**/                     inline def compareTo       (inline v: String)                                  : Int      = x.compareTo(v)
    /**/                     inline def charAt          (inline i: Int)                                     : Char     = x.charAt(i)
    @tn("charAt_Opt")        inline def charAt_?        (i: Int)                                            : Char.Opt = Z.charAt_Opt(x,i)
    @tn("indexOf_Opt")       inline def indexOf_?       (inline v: String,        inline from: Int.Opt = \/): Int.Opt  = Z.indexOf_Opt      (x,v,from)
    @tn("indexOf_Stream")    inline def indexOf_~       (inline v: String,        inline from: Int.Opt = \/): ~[Int]   = Z.indexOf_Stream   (x,v,from)
    @tn("lastIndexOf_Opt")   inline def lastIndexOf_?   (inline v: String,        inline from: Int.Opt = \/): Int.Opt  = Z.lastIndexOf_Opt  (x,v,from)
    @tn("charIndex_Opt")     inline def charIndex_?     (inline f: Char=>Boolean, inline from: Int.Opt = \/): Int.Opt  = Z.charIndex_Opt    (x,f,from)
    @tn("lastCharIndex_Opt") inline def lastCharIndex_? (inline f: Char=>Boolean, inline from: Int.Opt = \/): Int.Opt  = Z.lastCharIndex_Opt(x,f,from)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def contains -> Contains check

       Returns true is `this` String contains `that` String
       ```
       "abc".contains("cd").TP // Prints: false
       ```

@def startsWith -> Check if begins with

       Returns true `this` String starts with `that` String
       ```
       "abc".startsWith("ab").TP // Prints: true
       ```

@def endsWith -> Check if ends with

       Returns true `this` String ends with `that` String
       ```
       "abc".endsWith("bc").TP // Prints: true
       ```

@def equalsIgnoreCase -> Check if equals ignore case

       Returns true `this` and `that` String are equal, if upper and lower case Chars are considered equal
       ```
       "aBc".equalsIgnoreCase("ABC").TP // Prints: true
       ```

@def charAt ->  Char at position

       Returns Char at the specified position


@def charAt_? -> Char at position

       Optionally Returns Char at the specified position

       \/ is returned if specified position is out of String range
       ```
       if(<name>.charAt_?(2).take(_.isUpper)) ()
       // is equivalent
       if(<name>.length >=2 && <name>.charAt(2).isUpper) ()
       ```



@def indexOf_? -> Value position

     Optionally returns position of the specified `x`
     ```
     "abcd_abcd_".indexOf_?("d_a").TP // Prints: Opt(3)
     ```
     @param from position to start looking from


@def lastIndexOf_? -> Value position

     Optionally returns last position of the specified `x`
     ```
     "abcd_abcd_abcd_".lastIndexOf_?("d_a").TP // Prints: Opt(8)
     ```
     @param from last position to start looking from end to start

@def charIndex_? -> Char index

     Optionally returns index of the first Char passing the let function
     ```
         "abcd_abcd_".charIndex_?(_ >= 'd', 4).TP // Prints: Opt(8)
         "abcd_abcd_".charIndex_?('x' <> 'z') TP  // Prints: Opt(\/)
     ```
     @param from position to start looking from


@def lastCharIndex_? -> Char index

     Optionally returns index of the last Char passing the let function
     ```
         "abcd_abcd_".lastCharIndex_?(_ >= 'd', 4).TP // Prints: Opt(3)
         "abcd_abcd_".lastCharIndex_?('x' <> 'z') TP  // Prints: Opt(\/)
     ```
     @param from last position to start looking from end to start


@def indexOf_~ -> Source of indexes

     Source of indexes for each occurrence of `x`
     ```
     "abcd_abcd_abcd_abcd_abcd".indexOf_~("bc").TP // Prints ~(1, 6, 11, 16, 21)
     ```
     @param from position to start looking from

*/
