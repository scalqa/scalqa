package scalqa; package lang; package string; package opaque; package base; package _methods; import language.implicitConversions

transparent trait _evaluate:

  extension[THIS_OPAQUE<:Opaque](inline x: THIS_OPAQUE)
    inline def length                                                                   : Int        = x.cast[String].length
    inline def contains        (inline v: THIS_OPAQUE|String)                           : Boolean    = x.cast[String].contains(v.cast[String])
    inline def startsWith      (inline v: THIS_OPAQUE|String)                           : Boolean    = x.cast[String].startsWith(v.cast[String])
    inline def endsWith        (inline v: THIS_OPAQUE|String)                           : Boolean    = x.cast[String].endsWith(v.cast[String])
    inline def equalsIgnoreCase(inline v: THIS_OPAQUE|String)                           : Boolean    = x.cast[String].equalsIgnoreCase(v.cast[String])
    inline def compareTo       (inline v: THIS_OPAQUE)                                  : Int        = x.cast[String].compareTo(v.cast[String])
    inline def charAt          (inline i: Int)                                          : Char       = x.cast[String].charAt(i)
    inline def charAtOpt       (i: Int)                                                 : Char.Opt   = x.cast[String].charAtOpt(i)
    inline def indexOfOpt      (inline v: THIS_OPAQUE|String, inline from: Int.Opt=VOID): Int.Opt    = x.cast[String].indexOfOpt      (v.cast[String],from)
    inline def indexOfStream   (inline v: THIS_OPAQUE|String, inline from: Int.Opt=VOID): Int.Stream = x.cast[String].indexOfStream   (v.cast[String],from)
    inline def lastIndexOfOpt  (inline v: THIS_OPAQUE|String, inline from: Int.Opt=VOID): Int.Opt    = x.cast[String].lastIndexOfOpt  (v.cast[String],from)
    inline def charIndexOpt    (inline f: Char => Boolean,    inline from: Int.Opt=VOID): Int.Opt    = x.cast[String].charIndexOpt    (f,from)
    inline def lastCharIndexOpt(inline f: Char => Boolean,    inline from: Int.Opt=VOID): Int.Opt    = x.cast[String].lastCharIndexOpt(f,from)

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


@def charAtOpt -> Char at position

       Optionally Returns Char at the specified position

       VOID is returned if specified position is out of String range
       ```
       if(<name>.charAtOpt(2).take(_.isUpper)) ()
       // is equivalent
       if(<name>.length >=2 && <name>.charAt(2).isUpper) ()
       ```



@def indexOfOpt -> Value position

     Optionally returns position of the specified `x`
     ```
     "abcd_abcd_".indexOfOpt("d_a").TP // Prints: Opt(3)
     ```
@param from position to start looking from


@def lastIndexOfOpt -> Value position

     Optionally returns last position of the specified `x`
     ```
     "abcd_abcd_abcd_".lastIndexOfOpt("d_a").TP // Prints: Opt(8)
     ```
@param from last position to start looking from end to start

@def charIndexOpt -> Char index

     Optionally returns index of the first Char passing the let function
     ```
         "abcd_abcd_".charIndexOpt(_ >= 'd', 4).TP // Prints: Opt(8)
         "abcd_abcd_".charIndexOpt('x' <> 'z') TP  // Prints: Opt(VOID)
     ```
@param from position to start looking from


@def lastCharIndexOpt -> Char index

     Optionally returns index of the last Char passing the let function
     ```
         "abcd_abcd_".lastCharIndexOpt(_ >= 'd', 4).TP // Prints: Opt(3)
         "abcd_abcd_".lastCharIndexOpt('x' <> 'z') TP  // Prints: Opt(VOID)
     ```
@param from last position to start looking from end to start


@def indexOfStream -> Source of indexes

     Source of indexes for each occurrence of `x`
     ```
     "abcd_abcd_abcd_abcd_abcd".indexOfStream("bc").TP // Prints Stream(1, 6, 11, 16, 21)
     ```
@param from position to start looking from

*/