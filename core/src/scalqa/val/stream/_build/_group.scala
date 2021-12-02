package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import z._build.{ _group => G }

transparent trait _group:

  extension[A](inline x: Stream[A])
    inline def group                                                             : Stream[Stream[A]]     = new G.group(x, _ == _)
    inline def group[U](inline f:(A,A)=>Boolean, inline peek:(A,Boolean)=>U=VOID): Stream[Stream[A]]     = new G.group(x, f, peek)
    inline def groupWith[B](f: A => B)                                           : Stream[(B,Stream[A])] = new G.groupBy(x, f, Nil).map(_.enablePreview).map(v => (f(v.preview), v))
    inline def groupEvery(inline cnt: Int)                                       : Stream[Stream[A]]     = new G.groupEvery(x, cnt)
    inline def groupBy(inline f: A => Any, inline more: A => Any*)               : Stream[Stream[A]]     = new G.groupBy(x, f, more)

    inline def partition(inline p: A => Boolean, inline more: A => Boolean*)     : Stream[Stream[A]]     = new G.partition(x, p, more)
    inline def sliding(inline size: Int, inline step: Int = 1)                   : Stream[Stream[A]]     = new G.sliding(x.cast[Stream[AnyRef]], size, step).cast[Stream[Stream[A]]]
    inline def splitAt(inline positions: Int*)                                   : Stream[Stream[A]]     = new G.splitAt(x, positions)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _group -> ### Stream Element Grouping Interface

@def group -> Simple grouping

     Puts consecutive elements in the same group if they are `equal`

     ```
         def stream =  Stream(1, 2, 3).repeat(3)

         stream.TP           // Prints Stream(1, 1, 1, 2, 2, 2, 3, 3, 3)

         stream.group.print  // Prints  ------------
                                      ?
                                      ------------
                                      Stream(1, 1, 1)
                                      Stream(2, 2, 2)
                                      Stream(3, 3, 3)
                                      ------------
     ```

     Note: Non consecutive equal elements will end up in different groups. Prior ordering might be needed

@def group ->  Group by test

     Puts elements in the same group based on a function test for every two consecutive elements

     ```
        // Putting Ints into groups of 3

        (0 <> 20).stream.group(_ / 3 == _ / 3).print

        // Output
        ---------------
        ?
        ---------------
        Stream(0, 1, 2)
        Stream(3, 4, 5)
        Stream(6, 7, 8)
        Stream(9, 10, 11)
        Stream(12, 13, 14)
        Stream(15, 16, 17)
        Stream(18, 19, 20)
        ---------------
     ```

    @param f function for two consecutive elements. if 'false' is returned, the second tested element will start a new group
    @param peek side-effect convenience function will run for each element. Boolean parameter indicates if the element starts a new group

@def groupBy ->  Grouping on properties

     Puts consecutive elements in the same group if all the specified properties are equal

     When properties change, a new group is started

     ```
          ('#' <> '|').stream.groupBy(_.isLetter, _.isDigit).print

         // Output
         ---------------------------------------------------------------------------------
         ?
         ---------------------------------------------------------------------------------
         Stream(#, $, %, &, ', (, ), *, +, ,, -, ., /)
         Stream(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
         Stream(:, ;, <, =, >, ?, @)
         Stream(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, B, U, V, W, X, Y, Z)
         Stream([, \, ], /\, _, `)
         Stream(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, p, t, u, v, w, x, y, z)
         Stream({, |)
         ---------------------------------------------------------------------------------
     ```

     @param properties a set of functions, each indicating element property


@def groupWith -> Grouping on a property

     Puts consecutive elements in the same group if their properties are equal

     ```
        (0 <> 20).stream.groupWith(_ / 3).print

        // Output
        -- -------------
        _1 _2
        -- -------------
        0  Stream(0, 1, 2)
        1  Stream(3, 4, 5)
        2  Stream(6, 7, 8)
        3  Stream(9, 10, 11)
        4  Stream(12, 13, 14)
        5  Stream(15, 16, 17)
        6  Stream(18, 19, 20)
        -- -------------
     ```

     Note: [[groupWith]] also returns the groupped property value (unlike [[groupBy]])

     @param properties a set of functions, each indicating an element property


@def groupEvery -> Fixed size groups

     Puts consecutive elements into fixed size groups

     ```
     ('a' <> 'z').stream.groupEvery(8).print

     // Output
     -------------------------
     ?
     -------------------------
     Stream(a, b, c, d, e, f, g, h)
     Stream(i, j, k, l, m, n, o, p)
     Stream(q, r, p, t, u, v, w, x)
     Stream(y, z)
     -------------------------
     ```

@def splitAt -> Positional split

      Splits [[scalqa.val.Stream Stream]] at specified positions

      ```
      val (s1,s2,s3) = (0 <> 20).stream.splitAt(5, 15).tuple3

      s1.TP   // Prints Stream(0, 1, 2, 3, 4)
      s2.TP   // Prints Stream(5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
      s3.TP   // Prints Stream(15, 16, 17, 18, 19, 20)
      ```

      Note. The same could be accomplished with [[readStream]]

      ```
      val s3 = (0 <> 20).stream
      val s1 = s3.readStream(5)
      val s2 = s3.readStream(10)
   		```

@def sliding -> Sliding group view

     Example: group size 3 with step 1
     ```
       ('a' <> 'g').stream.sliding(3).print

       // Output
       ----------
       ?
       ----------
       Stream(a, b, c)
       Stream(b, c, d)
       Stream(c, d, e)
       Stream(d, e, f)
       Stream(e, f, g)
       ----------
     ```

     Example: group size 4 with step 2
     ```
       ('a' <> 'g').stream.sliding(4,2).print

       // Output
       -------------
       ?
       -------------
       Stream(a, b, c, d)
       Stream(c, d, e, f)
       Stream(e, f, g)
       -------------
     ```

@def partition -> Predicate grouping

     All stream elements are grouped by given predicates, which are applied in sequence. Thus if an element is accepted into a group, it will not be evaluated by the rest of the filters.

     The resulting stream size will be equal to the number of predicates plus one. The last group will hold spill over elements, not accepted by any predicate. Groups can be empty.

     ```
     val (odd,even) = (1 <> 10).stream.partition(_ % 2 == 1).tuple2

     odd.TP
     even.TP

     // Output
     Stream(1, 3, 5, 7, 9)
     Stream(2, 4, 6, 8, 10)


     // Age groups
     (1 <> 80).stream.partition(_ <= 12, _ in 13 <> 19, _ < 30, _ in 30 <> 40, _ < 50, _ < 65).print
     ```
     ```

      -------------------------------------------------------------------
      ?
      -------------------------------------------------------------------
      Stream(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
      Stream(13, 14, 15, 16, 17, 18, 19)
      Stream(20, 21, 22, 23, 24, 25, 26, 27, 28, 29)
      Stream(30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40)
      Stream(41, 42, 43, 44, 45, 46, 47, 48, 49)
      Stream(50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64)
      Stream(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80)
      -------------------------------------------------------------------
     ```
*/
