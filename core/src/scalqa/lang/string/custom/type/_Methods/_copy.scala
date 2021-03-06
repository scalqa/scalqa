package scalqa; package lang; package string; package custom; package `type`; package `_Methods`; import language.implicitConversions

transparent trait _copy[A<: String | Opaque.String]:

  extension(inline x: A)
    @tn("take_Range") inline def take_<>(start:Int, inline size:Int)                              : A   = x.substring(start,start+size).cast[A]
    @tn("take_Range") inline def take_<>(r: Int.<>)                                               : A   = x.substring(r.start, r.endX).cast[A]
    /**/              inline def takeFirst(inline cnt: Int)                                       : A   = x.substring(0, cnt).cast[A]
  extension(x: A)
    /**/              inline def takeLast(inline cnt: Int)                                        : A   = x.substring(x.length - cnt, x.length).cast[A]
    @tn("drop_Range") inline def drop_<>(start:Int, inline size:Int)                              : A   = (x.substring(0, start) + x.substring(start+size)).cast[A]
    @tn("drop_Range") inline def drop_<>(i: Int.<>)                                               : A   = (x.substring(0, i.start) + x.substring(i.endX)).cast[A]
    /**/              inline def dropFirst(inline cnt: Int)                                       : A   = x.substring(cnt).cast[A]
    /**/              inline def dropLast (inline cnt: Int)                                       : A   = x.substring(0, x.length - cnt).cast[A]
  extension(inline x: A)
    inline def takeBefore    (inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeBefore    (x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]
    inline def takeBeforeLast(inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeBeforeLast(x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]
    inline def takeFrom      (inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeFrom(      x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]
    inline def takeFromLast  (inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeFromLast(  x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]
    inline def takeAfter     (inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeAfter(     x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]
    inline def takeAfterLast (inline v:A|String, inline dflt:Opt[A]= \/, inline from:Int.Opt = \/): A   = Z.takeAfterLast( x.cast[String],v.cast[String],dflt.cast[Opt[String]],from).cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _copy -> ###

@def takeFrom -> Copy end

       Copies String from the position where the specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".takeFrom("cd") TP // Prints: cdefg
       ```
       @param string position to start looking from


@def takeFromLast -> Copy end

       Copies String from the last position the specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab") TP // Prints: abcd
       ```
       @param from string last position to start looking from end to start


@def takeAfter ->  Copy end

       Copies String from the position where the specified `v` found plus the length of the `v`

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".copyAfter("cd") TP // Prints: efg
       ```
       @param string position to start looking from


@def takeAfterLast -> Copy end

       Copies String from the last position the specified `v` found plus the length of the `v`

       If no v found, `dflt` v is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab") TP // Prints: cd
       ```
       @param from string last position to start looking from end to start


@def takeBefore ->  Copy start

       Copies String from the beginning until specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".takeBefore("ef") TP // Prints: abcd
       ```
       @param string position to start looking from


@def takeBeforeLast -> Copy start

       Copies String from the beginning until the last occurrence of specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void

       ```
           "abcd_abcd_abcd".copyBeforeLast("ab") TP // Prints: abcd_abcd_
       ```
       @param from string last position to start looking from end to start

*/
