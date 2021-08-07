package scalqa; package lang; package string; package opaque; package base; package _methods; import language.implicitConversions

transparent trait _evaluate:

  extension[THIS_OPAQUE<:Opaque](inline x: THIS_OPAQUE)
    /**/                     inline def length                                                                      : Int      = x.cast[String].length
    /**/                     inline def contains        (inline v: THIS_OPAQUE|String)                              : Boolean  = x.cast[String].contains(v.cast[String])
    /**/                     inline def startsWith      (inline v: THIS_OPAQUE|String)                              : Boolean  = x.cast[String].startsWith(v.cast[String])
    /**/                     inline def endsWith        (inline v: THIS_OPAQUE|String)                              : Boolean  = x.cast[String].endsWith(v.cast[String])
    /**/                     inline def equalsIgnoreCase(inline v: THIS_OPAQUE|String)                              : Boolean  = x.cast[String].equalsIgnoreCase(v.cast[String])
    /**/                     inline def compareTo       (inline v: THIS_OPAQUE)                                     : Int      = x.cast[String].compareTo(v.cast[String])
    /**/                     inline def charAt          (inline i: Int)                                             : Char     = x.cast[String].charAt(i)
    @tn("charAt_Opt")        inline def charAt_?        (i: Int)                                                    : Char.Opt = x.cast[String].charAt_?(i)
    @tn("indexOf_Opt")       inline def indexOf_?       (inline v: THIS_OPAQUE|String,   inline from: Int.Opt = \/) : Int.Opt  = x.cast[String].indexOf_?      (v.cast[String],from)
    @tn("indexOf_Stream")    inline def indexOf_~       (inline v: THIS_OPAQUE|String,   inline from: Int.Opt = \/) : ~[Int]   = x.cast[String].indexOf_~      (v.cast[String],from)
    @tn("lastIndexOf_Opt")   inline def lastIndexOf_?   (inline v: THIS_OPAQUE|String,   inline from: Int.Opt = \/) : Int.Opt  = x.cast[String].lastIndexOf_?  (v.cast[String],from)
    @tn("charIndex_Opt")     inline def charIndex_?     (inline f: Char => Boolean, inline from: Int.Opt = \/)      : Int.Opt  = x.cast[String].charIndex_?    (f,from)
    @tn("lastCharIndex_Opt") inline def lastCharIndex_? (inline f: Char => Boolean, inline from: Int.Opt = \/)      : Int.Opt  = x.cast[String].lastCharIndex_?(f,from)

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