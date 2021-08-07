package scalqa; package lang; package string; package opaque; package base; package _methods; import language.implicitConversions

transparent trait _copy:

  extension[THIS_OPAQUE<:Opaque](inline x: THIS_OPAQUE)
    /**/              inline def takeBefore    (inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeBefore    (v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    /**/              inline def takeBeforeLast(inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeBeforeLast(v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    /**/              inline def takeFrom      (inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeFrom      (v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    /**/              inline def takeFromLast  (inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeFromLast  (v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    /**/              inline def takeAfter     (inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeAfter     (v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    /**/              inline def takeAfterLast (inline v:THIS_OPAQUE|String, inline dflt:Opt[THIS_OPAQUE]= \/, inline from:Int.Opt = \/): THIS_OPAQUE   = x.cast[String].takeAfterLast (v.cast[String],dflt.cast[Opt[String]],from).cast[THIS_OPAQUE]
    @tn("take_Range") inline def take_<>(start:Int, inline size:Int)                                                                    : THIS_OPAQUE   = x.cast[String].take_<>       (start,size)                                .cast[THIS_OPAQUE]
    @tn("take_Range") inline def take_<>(r: Int.<>)                                                                                     : THIS_OPAQUE   = x.cast[String].take_<>       (r)                                         .cast[THIS_OPAQUE]
    /**/              inline def takeFirst(inline cnt: Int)                                                                             : THIS_OPAQUE   = x.cast[String].takeFirst     (cnt)                                       .cast[THIS_OPAQUE]
    /**/              inline def dropFirst(inline cnt: Int)                                                                             : THIS_OPAQUE   = x.cast[String].dropFirst     (cnt)                                       .cast[THIS_OPAQUE]

  extension[THIS_OPAQUE<:Opaque](x: THIS_OPAQUE)
    /**/              inline def takeLast(inline cnt: Int)                                                                              : THIS_OPAQUE   = x.cast[String].takeLast      (cnt)                                       .cast[THIS_OPAQUE]
    @tn("drop_Range") inline def drop_<>(start:Int, inline size:Int)                                                                    : THIS_OPAQUE   = x.cast[String].drop_<>       (start,size)                                .cast[THIS_OPAQUE]
    @tn("drop_Range") inline def drop_<>(r: Int.<>)                                                                                     : THIS_OPAQUE   = x.cast[String].drop_<>       (r)                                         .cast[THIS_OPAQUE]
    /**/              inline def dropLast (inline cnt: Int)                                                                             : THIS_OPAQUE   = x.cast[String].dropLast      (cnt)                                       .cast[THIS_OPAQUE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _copy -> ###

@def takeFirst -> Copy start

       Copies first given number of characters

       The method call is inlined as Java ```x.substring(0,cnt)```

@def takeLast -> Copy end

       Copies last given number of characters

       The method call is inlined as Java ```x.substring(x.length - cnt, x.length)```

@def take_<> -> Copy range

      Copies only range of characters specified

@def take_<> -> Copy range

      Copies only range of characters specified

@def dropFirst -> Copy without start

       Copies without given number of first characters

       The method call is inlined as Java ```.substring(cnt)```

@def dropLast -> Copy without end

       Copies without given number of last characters

       The method call is inlined as Java ```x.substring(0, x.length - cnt)```

@def drop_<> -> Copy without range

       Copies without range of characters specified

@def drop_<> -> Copy without range

       Copies without range of characters specified

@def takeFrom -> Copy end

       Copies String from the position where the specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".takeFrom("cd").TP // Prints: cdefg
       ```
       @param string position to start looking from


@def takeFromLast -> Copy end

       Copies String from the last position the specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab").TP // Prints: abcd
       ```
@param from string last position to start looking from end to start


@def takeAfter ->  Copy end

       Copies String from the position where the specified `v` found plus the length of the `v`

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".copyAfter("cd").TP // Prints: efg
       ```
      @param string position to start looking from

@def takeAfterLast -> Copy end

       Copies String from the last position the specified `v` found plus the length of the `v`

       If no v found, `dflt` v is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab").TP // Prints: cd
       ```
       @param from string last position to start looking from end to start

@def takeBefore ->  Copy start

       Copies String from the beginning until specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void
       ```
           "abcdefg".takeBefore("ef").TP // Prints: abcd
       ```
       @param string position to start looking from


@def takeBeforeLast -> Copy start

       Copies String from the beginning until the last occurrence of specified `v` found

       If no v found, `dflt` v is returned, or original if dflt is void

       ```
           "abcd_abcd_abcd".copyBeforeLast("ab").TP // Prints: abcd_abcd_
       ```
       @param from string last position to start looking from end to start

*/
