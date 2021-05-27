package scalqa; package `val`; package stream; package _Build; import language.implicitConversions

import z.build.{ group => G }

transparent trait _group:

  extension[A]  (inline x: ~[A])
    inline def group                                                             : ~[~[A]]     = new G.group(x, _ == _)
    inline def group[U](inline f:(A,A)=>Boolean, inline peek:(A,Boolean)=>U= \/) : ~[~[A]]     = new G.group(x, f, peek)
    inline def groupWith[B](f: A => B)                                           : ~[(B,~[A])] = new G.groupBy(x, f, Nil).map(_.enablePreview).map(v => (f(v.preview), v))
    inline def groupEvery(inline cnt: Int)                                       : ~[~[A]]     = new G.groupEvery(x, cnt)
    inline def groupBy(inline f: A => Any, inline more: A => Any*)               : ~[~[A]]     = new G.groupBy(x, f, more)

    inline def partition(inline p: A => Boolean, inline more: A => Boolean*)     : ~[~[A]]     = new G.partition(x, p, more)
    inline def sliding(inline size: Int, inline step: Int = 1)                   : ~[~[A]]     = new G.sliding(x.cast[~[Ref]], size, step).cast[~[~[A]]]
    inline def splitAt(inline positions: Int*)                                   : ~[~[A]]     = new G.splitAt(x, positions)

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
         def stream =  ~~(1, 2, 3).repeat(3)

         stream.TP           // Prints ~(1, 1, 1, 2, 2, 2, 3, 3, 3)

         stream.group.print  // Prints  ------------
                                      ?
                                      ------------
                                      ~(1, 1, 1)
                                      ~(2, 2, 2)
                                      ~(3, 3, 3)
                                      ------------
     ```

     Note: Non consecutive equal elements will end up in different groups. Prior ordering might be needed

@def group ->  Group by test

     Puts elements in the same group based on a function test for every two consecutive elements

     ```
        // Putting Ints into groups of 3

        (0 <> 20).~.group(_ / 3 == _ / 3).print

        // Output
        ---------------
        ?
        ---------------
        ~(0, 1, 2)
        ~(3, 4, 5)
        ~(6, 7, 8)
        ~(9, 10, 11)
        ~(12, 13, 14)
        ~(15, 16, 17)
        ~(18, 19, 20)
        ---------------
     ```

    @param f function for two consecutive elements. if 'false' is returned, the second tested element will start a new group
    @param peek side-effect convenience function will run for each element. Boolean parameter indicates if the element starts a new group

@def groupBy ->  Grouping on properties

     Puts consecutive elements in the same group if all the specified properties are equal

     When properties change, a new group is started

     ```
          ('#' <> '|').~.groupBy(_.isLetter, _.isDigit).print

         // Output
         ---------------------------------------------------------------------------------
         ?
         ---------------------------------------------------------------------------------
         ~(#, $, %, &, ', (, ), *, +, ,, -, ., /)
         ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
         ~(:, ;, <, =, >, ?, @)
         ~(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
         ~([, \, ], /\, _, `)
         ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, p, t, u, v, w, x, y, z)
         ~({, ~)
         ---------------------------------------------------------------------------------
     ```

     @param properties a set of functions, each indicating element property


@def groupWith -> Grouping on a property

     Puts consecutive elements in the same group if their properties are equal

     ```
        (0 <> 20).~.groupWith(_ / 3).print

        // Output
        -- -------------
        _1 _2
        -- -------------
        0  ~(0, 1, 2)
        1  ~(3, 4, 5)
        2  ~(6, 7, 8)
        3  ~(9, 10, 11)
        4  ~(12, 13, 14)
        5  ~(15, 16, 17)
        6  ~(18, 19, 20)
        -- -------------
     ```

     Note: [[groupWith]] also returns the groupped property value (unlike [[groupBy]])

     @param properties a set of functions, each indicating an element property


@def groupEvery -> Fixed size groups

     Puts consecutive elements into fixed size groups

     ```
     ('a' <> 'z').~.groupEvery(8).print

     // Output
     -------------------------
     ?
     -------------------------
     ~(a, b, c, d, e, f, g, h)
     ~(i, j, k, l, m, n, o, p)
     ~(q, r, p, t, u, v, w, x)
     ~(y, z)
     -------------------------
     ```

@def splitAt -> Positional split

      Splits [[scalqa.val.Stream ~]] at specified positions

      ```
      val ~~(s1, s2, s3) = (0 <> 20).~.splitAt(5, 15)

      s1.TP   // Prints ~(0, 1, 2, 3, 4)
      s2.TP   // Prints ~(5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
      s3.TP   // Prints ~(15, 16, 17, 18, 19, 20)
      ```

       Note. The same could be accomplished with [[read_~]]

   		```
      val s3 = (0 <> 20).~
      val s1 = s3.read_~(5)
      val s2 = s3.read_~(10)
   		```

@def sliding -> Sliding group view

     Example: group size 3 with step 1
     ```
       ('a' <> 'g').~.sliding(3).print

       // Output
       ----------
       ?
       ----------
       ~(a, b, c)
       ~(b, c, d)
       ~(c, d, e)
       ~(d, e, f)
       ~(e, f, g)
       ----------
     ```

     Example: group size 4 with step 2
     ```
       ('a' <> 'g').~.sliding(4,2).print

       // Output
       -------------
       ?
       -------------
       ~(a, b, c, d)
       ~(c, d, e, f)
       ~(e, f, g)
       -------------
     ```

@def partition -> Predicate grouping

     All stream elements are grouped by given predicates, which are applied in sequence. Thus if an element is accepted into a group, it will not be evaluated by the rest of the filters.

     The resulting stream size will be equal to the number of predicates plus one. The last group will hold spill over elements, not accepted by any predicate. Groups can be empty.

     ```
     val ~~(odd,even) = (1 <> 10).~.partition(_ % 2 == 1)

     odd.TP
     even.TP

     // Age groups
     (1 <> 80).~.partition(_ <= 12, _ in 13 <> 19, _ < 30, _ in 30 <> 40, _ < 50, _ < 65).print
     ```
     ```
     // Output
     ~(1, 3, 5, 7, 9)
     ~(2, 4, 6, 8, 10)

      -------------------------------------------------------------------
      ?
      -------------------------------------------------------------------
      ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
      ~(13, 14, 15, 16, 17, 18, 19)
      ~(20, 21, 22, 23, 24, 25, 26, 27, 28, 29)
      ~(30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40)
      ~(41, 42, 43, 44, 45, 46, 47, 48, 49)
      ~(50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64)
      ~(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80)
      -------------------------------------------------------------------
     ```
*/
