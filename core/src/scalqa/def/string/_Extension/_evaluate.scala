package scalqa; package `def`; package string; package _Extension; import language.implicitConversions

transparent trait _evaluate[A<: String | Opaque.String] :
  self: z.Lib[A] =>

  extension(x: A)
    //infix             inline def in(inline v: A)                                         : Boolean  = v.real.indexOf(x.real) >= 0
    /**/              inline def length                                                  : Int      = x.real.length
    /**/              inline def contains        (v: A|String)                           : Boolean  = x.real.contains(v)
    /**/              inline def startsWith      (v: A|String)                           : Boolean  = x.real.startsWith(v)
    /**/              inline def endsWith        (v: A|String)                           : Boolean  = x.real.endsWith(v)
    /**/              inline def equalsIgnoreCase(v: A|String)                           : Boolean  = x.real.equalsIgnoreCase(v)
    /**/              inline def compareTo       (v: A)                                  : Int      = x.real.compareTo(v.real)
    /**/              inline def charAt(i: Int)                                          : Char     = x.real.charAt(i)
    @tn("charAt_Opt")        def charAt_?       (i: Int)                                 : Char.Opt = if (i < 0 || i >= x.length) \/ else x.charAt(i)
    @tn("indexOf_Opt")       def indexOf_?      (v: A|String, from: Int.Opt = \/)        : Int.Opt  = x.indexOf(v, from or 0).?.take(_ >= 0)
    @tn("lastIndexOf_Opt")   def lastIndexOf_?  (v: A|String, from: Int.Opt = \/)        : Int.Opt  = x.lastIndexOf(v, from or x.length).?.take(_ >= 0)
    @tn("indexesOf_Stream")  def indexesOf_~    (v: A|String, from: Int.Opt = \/)        : ~[Int]   = x.indexOf_?(v, from).map(i => ~~(i) ++ x.indexesOf_~(v, i + v.length)) or \/
    @tn("charIndex_Opt")     def charIndex_?    (f: Char => Boolean, from: Int.Opt = \/) : Int.Opt  = { var i = from or 0; while (i < x.length) { if (f(x.charAt(i))) return i; i += 1 }; \/ }
    @tn("lastCharIndex_Opt") def lastCharIndex_?(f: Char => Boolean, from: Int.Opt = \/) : Int.Opt  = { var i = from or x.length - 1; while (i >= 0) { if (f(x.charAt(i))) return i; i -= 1 }; \/ }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def contains -> Contains check

       Returns true is `this` String contains `that` String
       ```  "abc".contains("cd") TP // Prints: false ```


@def startsWith -> Check if begins with

       Returns true `this` String starts with `that` String
       ```  "abc".startsWith("ab") TP // Prints: true ```


@def endsWith -> Check if ends with

       Returns true `this` String ends with `that` String
       ```  "abc".endsWith("bc") TP // Prints: true ```


@def equalsIgnoreCase -> Check if equals ignore case

       Returns true `this` and `that` String are equal, if upper and lower case Chars are considered equal
       ```  "aBc".equalsIgnoreCase("ABC").TP // Prints: true ```


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
     ``` "abcd_abcd_".indexOf_?("d_a") TP // Prints: ?(3) ```
     @param from position to start looking from


@def lastIndexOf_? -> Value position

     Optionally returns last position of the specified `x`
     ``` "abcd_abcd_abcd_".lastIndexOf_?("d_a") TP // Prints: ?(8) ```
     @param from last position to start looking from end to start


@def charIndex_? -> Char index

     Optionally returns index of the first Char passing the let function
     ```
         "abcd_abcd_".charIndex_?(_ >= 'd', 4) TP // Prints: ?(8)
         "abcd_abcd_".charIndex_?('x' <> 'z') TP  // Prints: \/
     ```
     @param from position to start looking from


@def lastCharIndex_? -> Char index

     Optionally returns index of the last Char passing the let function
     ```
         "abcd_abcd_".lastCharIndex_?(_ >= 'd', 4) TP // Prints: ?(3)
         "abcd_abcd_".lastCharIndex_?('x' <> 'z') TP  // Prints: \/
     ```
     @param from last position to start looking from end to start


@def indexesOf_~ -> Source of indexes

     Source of indexes for each occurrence of `x`
     ```"abcd_abcd_abcd_abcd_abcd".indexesOf_~("bc") TP // Prints ~(1, 6, 11, 16, 21) ```
     @param from position to start looking from


*/
