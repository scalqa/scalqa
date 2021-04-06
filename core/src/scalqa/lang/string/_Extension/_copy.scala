package scalqa; package lang; package string; package _Extension; import language.implicitConversions

transparent trait _copy[A<: String | Opaque.String]:
  self: z.Lib[A] =>

  extension(inline x: A)
    inline def take_<>(s:Int, sz:Int)                                        : A   = x.substring(s,s+sz).cast[A]
    inline def take_<>(r: Int.<>)                                            : A   = x.substring(r.start, r.endX).cast[A]
    inline def takeFirst(inline cnt: Int)                                    : A   = x.substring(0, cnt).cast[A]
  extension(x: A)
    inline def takeLast(cnt: Int)                                            : A   = x.substring(x.length - cnt, x.length).cast[A]
    inline def drop_<>(s:Int, sz:Int)                                        : A   = (x.substring(0, s) + x.substring(s+sz)).cast[A]
    inline def drop_<>(i: Int.<>)                                            : A   = (x.substring(0, i.start) + x.substring(i.endX)).cast[A]
    inline def dropFirst(inline cnt: Int)                                    : A   = x.substring(cnt).cast[A]
    inline def dropLast (inline cnt: Int)                                    : A   = x.substring(0, x.length - cnt).cast[A]
    /**/   def takeBefore    (v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.indexOf_?    (v, from).map(i => x.substring(0, i).cast[A])                   or_? dflt or x
    /**/   def takeBeforeLast(v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.lastIndexOf_?(v, from).map(i => x.substring(0, i).cast[A])                   or_? dflt or x
    /**/   def takeFrom      (v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.indexOf_?    (v, from).map(i => x.substring(i).cast[A])                      or_? dflt or x
    /**/   def takeFromLast  (v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.lastIndexOf_?(v, from).map(i => x.substring(i).cast[A])                      or_? dflt or x
    /**/   def takeAfter     (v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.indexOf_?    (v, from).map(i => x.substring(i + v.length, x.length).cast[A]) or_? dflt or x
    /**/   def takeAfterLast (v:A|String, dflt:Opt[A]= \/, from:Int.Opt = \/): A   = x.lastIndexOf_?(v, from).map(i => x.substring(i + v.length, x.length).cast[A]) or_? dflt or x

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _copy -> ###

This trait provides some copy overloads, which at first glance seem to be unnesasary, but they proved to bring semantic clarity in the code.


@def takeFrom -> Copy end

       Copies String from the position where the specified `x` found

       If no x found, `dflt` x is returned, or original if dflt is void
       ```
           "abcdefg".takeFrom("cd") TP // Prints: cdefg
       ```
       @param string position to start looking from


@def takeFromLast -> Copy end

       Copies String from the last position the specified `x` found

       If no x found, `dflt` x is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab") TP // Prints: abcd
       ```
       @param from string last position to start looking from end to start


@def takeAfter ->  Copy end

       Copies String from the position where the specified `x` found plus the length of the `x`

       If no x found, `dflt` x is returned, or original if dflt is void
       ```
           "abcdefg".copyAfter("cd") TP // Prints: efg
       ```
       @param string position to start looking from


@def takeAfterLast -> Copy end

       Copies String from the last position the specified `x` found plus the length of the `x`

       If no x found, `dflt` x is returned, or original if dflt is void.
       ```
           "abcd_abcd_abcd".takeFromLast("ab") TP // Prints: cd
       ```
       @param from string last position to start looking from end to start


@def takeBefore ->  Copy start

       Copies String from the beginning until specified `x` found

       If no x found, `dflt` x is returned, or original if dflt is void
       ```
           "abcdefg".takeBefore("ef") TP // Prints: abcd
       ```
       @param string position to start looking from


@def takeBeforeLast -> Copy start

       Copies String from the beginning until the last occurrence of specified `x` found

       If no x found, `dflt` x is returned, or original if dflt is void

       ```
           "abcd_abcd_abcd".copyBeforeLast("ab") TP // Prints: abcd_abcd_
       ```
       @param from string last position to start looking from end to start

*/
