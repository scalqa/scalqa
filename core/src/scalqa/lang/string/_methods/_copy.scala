package scalqa; package lang; package string; package _methods; import language.implicitConversions

transparent trait _copy:

  extension(inline x: String)
    inline def takeBefore    (inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeBefore    (x,v,dflt,fromPosition)
    inline def takeBeforeLast(inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeBeforeLast(x,v,dflt,fromPosition)
    inline def takeFrom      (inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeFrom(      x,v,dflt,fromPosition)
    inline def takeFromLast  (inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeFromLast(  x,v,dflt,fromPosition)
    inline def takeAfter     (inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeAfter(     x,v,dflt,fromPosition)
    inline def takeAfterLast (inline v:String, inline dflt:Opt[String]=VOID,inline fromPosition:Int.Opt=VOID): String   = Z.takeAfterLast( x,v,dflt,fromPosition)
    inline def takeRange(start:Int, inline size:Int)                                                         : String   = x.substring(start,start+size)
    inline def takeRange(r: Int.Range)                                                                       : String   = x.substring(r.start, r.endX)
    inline def takeFirst(inline cnt: Int)                                                                    : String   = x.substring(0, cnt)
    inline def dropFirst(inline cnt: Int)                                                                    : String   = x.substring(cnt)

  extension(x: String)
    inline def takeLast(inline cnt: Int)                                                                     : String   = x.substring(x.length - cnt, x.length)
    inline def dropRange(start:Int, inline size:Int)                                                         : String   = (x.substring(0, start) + x.substring(start+size))
    inline def dropRange(i: Int.Range)                                                                       : String   = (x.substring(0, i.start) + x.substring(i.endX))
    inline def dropLast (inline cnt: Int)                                                                    : String   = x.substring(0, x.length - cnt)

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

@def takeRange -> Copy range

      Copies only range of characters specified

@def takeRange -> Copy range

      Copies only range of characters specified

@def dropFirst -> Copy without start

       Copies without given number of first characters

       The method call is inlined as Java ```.substring(cnt)```

@def dropLast -> Copy without end

       Copies without given number of last characters

       The method call is inlined as Java ```x.substring(0, x.length - cnt)```

@def dropRange -> Copy without range

       Copies without range of characters specified

@def dropRange -> Copy without range

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
