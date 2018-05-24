package scalqa; package Pipe; package _extend

trait _group[A] extends __[A] {

  def group: ~[~[A]] = group((a, b) => a == b)

  def group(test: (A, A) => Boolean, peekSplit: (A, Boolean) => Any = \/): ~[~[A]] = new Z.group(This, test, peekSplit)

  def groupBy(properties: A => Any*): ~[~[A]] = group(properties.all.foldAs[(A, A) => Boolean]((x, y) => true, (f, m) => (x, y) => f(x, y) && m(x) == m(y)))

  def groupBySize(size: Int): ~[~[A]] = if (size <= 0) Fail.argument("size" + '=' + size) else new Z.group.BySize(This, size)

  def partition(groupFilters: A => Boolean*): ~[~[A]] = Z.group.partition(This, groupFilters.toArray)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _group -> '''Element Grouping Interface'''
 *
 * @def partition -> Multi-filter grouping
 *
 *   All pipe elements are grouped by specified filters
 *
 *   Filters are applied in sequence, thus if an element is accepted into a group, it will not be evaluated by the rest of the filters
 *
 *   If there are elements, which are left without a group, one extra group is created
 *
 *   @param groupFilters a set of filters, to specify groups
 *   @example
 *   {{{
 *       // Age groups
 *       (1 <> 80).all.partition(_ <= 12, 13 <> 19, _ < 30, 30 <> 40, _ < 50, _ < 65).tp
 *
 *       // Output
 *       -------------------------------------------------------------------
 *       ?
 *       -------------------------------------------------------------------
 *       ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
 *       ~(13, 14, 15, 16, 17, 18, 19)
 *       ~(20, 21, 22, 23, 24, 25, 26, 27, 28, 29)
 *       ~(30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40)
 *       ~(41, 42, 43, 44, 45, 46, 47, 48, 49)
 *       ~(50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64)
 *       ~(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80)
 *       -------------------------------------------------------------------
 *     }}}
 *
 * @def groupBySize -> Fixed size groups
 *
 *   Puts consecutive elements into fixed size groups
 *
 *   @param size of groups. Cannot be less than 1.
 *   @example
 *   {{{
 *       'x'.I.~.repeat(30).groupBySize(8).tp
 *
 *       // Output
 *
 *       ---------------------------
 *       ?
 *       ---------------------------
 *       ~(x, x, x, x, x, x, x, x)
 *       ~(x, x, x, x, x, x, x, x)
 *       ~(x, x, x, x, x, x, x, x)
 *       ~(x, x, x, x, x, x)
 *       ---------------------------
 *   }}}
 *
 * @def groupBy( -> Grouping on properties
 *
 *   Puts consecutive elements in the same group if all the specified properties are equal
 *
 *   When properties change, a new group is started
 *
 *   @param properties a set of functions, each indicating an element property
 *
 *   @example
 *   {{{
 *        ('#' <> '|').all.groupBy(_.isLetter, _.isDigit).tp
 *
 *       // Output
 *       ---------------------------------------------------------------------------------
 *       ?
 *       ---------------------------------------------------------------------------------
 *       ~(#, $, %, &, ', (, ), *, +, ,, -, ., /)
 *       ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 *       ~(:, ;, <, =, >, ?, @)
 *       ~(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
 *       ~([, \, ], ^, _, `)
 *       ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
 *       ~({, |)
 *       ---------------------------------------------------------------------------------
 *   }}}
 *
 *
 * @def group( -> Group by test
 *
 *   Puts elements in the same group based on a function test for every two consecutive elements
 *
 *   @param test function for two consecutive elements. if 'false' is returned, the second tested element will start a new group
 *   @param peekSplit function to run for each piped element. Boolean parameter indicates if the element starts a new group
 *
 *   @example
 *   {{{
 *      // Putting Ints into groups of 3
 *      (0 <> 20).all.group(_ / 3 == _ / 3).tp
 *
 *      // Output
 *
 *      ---------------
 *      ?
 *      ---------------
 *      ~(0, 1, 2)
 *      ~(3, 4, 5)
 *      ~(6, 7, 8)
 *      ~(9, 10, 11)
 *      ~(12, 13, 14)
 *      ~(15, 16, 17)
 *      ~(18, 19, 20)
 *      ---------------
 *   }}}
 *
 * @def group: -> Simple grouping
 *
 *   Puts consecutive elements in the same group if they are ''equal''
 *
 *   Note: Non consecutive equal elements will end up in different groups. Prior sorting might be needed
 *
 *   @example
 *   {{{
 *       *(1, 2, 3).flatMap(i => i ~ i ~ i).group.tp
 *
 *       // Output
 *
 *       ------------
 *       ?
 *       ------------
 *       ~(1, 1, 1)
 *       ~(2, 2, 2)
 *       ~(3, 3, 3)
 *       ------------
 *   }}}
 */
