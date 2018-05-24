package scalqa; package Array

trait _data[A] extends Any with Like.__[A, _Class] {

  def ensureCapacity(required: Int, setter: Array[A] => Any = \/, reserveExtra: Percent = 20): Array[A] = if (size >= required) This else copyResize(required +% reserveExtra).I(setter)

  def withinInsertAt(position: Int, value: A): Array[A] = { if (position + 1 < size) copyToArray(This, position + 1, position <>> size - 1); This(position) = value; This }

  def withinInsertAt(position: Int, pipe: ~[A]): Array[A] =
    pipe.yieldSize.to((pipe, sz) => { if (position + sz < size) copyToArray(This, position + sz, position <>> size - sz); loadAt(position, pipe); This })

  def withinRemoveAt(r: Int.Range): Array[A] = { copyToArray(This, r.start, r.end <>> size); This }

  def sort(implicit sorting: Sorting[A]): Array[A] = { if (sorting.isVoid.not) scala.util.Sorting.quickSort(_raw)(sorting.asOrdering.cast); This }

  def fill(value: A): Array[A] = fillAt(size.Range, value)

  def fillAt(r: Int.Range, value: A): Array[A] = { var i = r.start; val end = r.end; while (i < end) { update(i, value); i += 1 }; This }

  def load(pipe: ~[A], controlSize: Opt[Int] = \/): Array[A] = Z.loadAt(This, 0, pipe, controlSize)

  def loadAt(position: Int, pipe: ~[A], controlSize: Opt[Int] = \/): Array[A] = Z.loadAt(This, position, pipe, controlSize)

  def loadFlowAt(position: Int, flow: Pipe.Flow[A], controlSize: Opt[Int] = \/): Array[A] = Z.loadAt(This, position, flow, controlSize)

  protected def update(i: Int, e: A): Unit
  private[Array] override def This: Array[A] = this.cast
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def sort -> Ordering data
 *
 *    Sorts [[Array]] elements according the ''sorting''
 *    {{{
 *      var a: Array[Char] = ('a' <> 'z').all.reverse.to[Array]
 *      a.all.format().lp
 *      a.sort
 *      a.all.format().lp
 *
 *      // Output
 *      zyxwvutsrqponmlkjihgfedcba
 *      abcdefghijklmnopqrstuvwxyz
 *    }}}
 *
 * @def load( -> Load data
 *
 *     Loads [[Pipe]] of elements into ''this'' [[Array]] starting from the beginning
 *
 *     @param controlSize optional ''pipe'' size check. If specified and is different from ''pipe'' size, load will fail
 *
 *     @example
 *     {{{
 *         var a: Array[Char] = ('a' <> 'z').all.to[Array]
 *         a.all.format().lp
 *         a.load('1' <> '9')
 *         a.all.format().lp *
 *
 *         // Output
 *         abcdefghijklmnopqrstuvwxyz
 *         123456789jklmnopqrstuvwxyz
 *     }}}
 *
 * @def loadAt -> Load data at position
 *
 *     Loads [[Pipe]] of elements into ''this'' [[Array]] at specified position
 *
 *     @param controlSize optional ''pipe'' size check. If specified and is different from ''pipe'' size, load will fail
 *
 *     @example
 *     {{{
 *         var a: Array[Char] = ('a' <> 'z').all.to[Array]
 *         a.all.format().lp
 *         a.loadAt(10, '1' <> '9')
 *         a.all.format().lp
 *
 *         // Output
 *         abcdefghijklmnopqrstuvwxyz
 *         abcdefghij123456789tuvwxyz
 *     }}}
 *
 * @def loadFlowAt -> Load data at position
 *
 *     Loads [[Pipe.Flow]] of elements into ''this'' [[Array]] at specified position
 *
 *     ''loadFlowAt'' is similar to ''loadAt'' for [[Pipe]]s, however for parallel [[Pipe.Flow]]
 *     this is more efficient to load it directly, without converting to [[Pipe]]
 *
 *     @param controlSize optional ''pipe'' size check. If specified and is different from ''pipe'' size, load will fail
 *
 *     @example
 *     {{{
 *         var a: Array[Char] = ('a' <> 'z').all.to[Array]
 *         a.all.format().lp
 *         a.loadAt(10, '1' <> '9')
 *         a.all.format().lp
 *
 *         // Output
 *         abcdefghijklmnopqrstuvwxyz
 *         abcdefghij123456789tuvwxyz
 *     }}}
 *
 * @def withinInsertAt(position: Int, pipe -> Insert all within
 *
 *   Inserts given ''pipe'' of at given ''position'' by shifting all elements from this ''position' down
 *
 *   Note. Elements at the end of [[Array]] are lost
 *
 *   Returns ''this'' [[Array]]
 *   {{{
 *     var a: Array[Char] = ('a' <> 'z').all.to[Array]
 *     a.all.lp
 *     a.withinInsertAt(5, 'X'.~.repeat(12))
 *     a.all.lp
 *
 *     // Output
 *     ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
 *     ~(a, b, c, d, e, X, X, X, X, X, X, X, X, X, X, X, X, f, g, h, i, j, k, l, m, n)
 *   }}}
 *
 * @def withinInsertAt(position: Int, value -> Insert within
 *
 *   Inserts given ''value'' at given ''position'' by shifting all elements from this ''position' down
 *
 *   Note. The last [[Array]] element is lost
 *
 *   Returns ''this'' [[Array]]
 *   {{{
 *       var a: Array[Int] = (0 <> 9).all.to[Array]
 *       a.all.lp
 *       a.withinInsertAt(5, 99)
 *       a.all.lp
 *
 *      // Output
 *       ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 *       ~(0, 1, 2, 3, 4, 99, 5, 6, 7, 8)
 *   }}}
 *
 * @def withinRemoveAt -> Remove within
 *
 *   Removes range of elements from the [[Array]] by copying elements after the range to their place.
 *   Basically, all the elements after the range are shifted up by range.size.
 *
 *   Returns ''this'' [[Array]]
 *   {{{
 *     var a: Array[Int] = (0 <> 25).all.to[Array]
 *     a.all.lp
 *     a.withinRemoveAt(10 <> 15)
 *     a.all.lp
 *
 *     // Output
 *     ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
 *     ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 20, 21, 22, 23, 24, 25)
 *  }}}
 *
 * @def fill( -> Fill with value
 *
 *     Fills the entire array space with single specified value
 *
 *     Returns ''this'' [[Array]]
 *     {{{
 *       var a = Array.get[Char](10)
 *       a fill 'Z'
 *       a.all.lp // Ptints: ~(Z, Z, Z, Z, Z, Z, Z, Z, Z, Z)
 *     }}}
 *
 * @def fillAt -> Fill range with value
 *
 *     Fills range of elements with single value
 *
 *     Returns ''this'' [[Array]]
 *     {{{
 *       var a = Array.get[Int](10)
 *       a.fillAt(3 <> 6, 9)
 *       a.all.lp  // Ptints: ~(0, 0, 0, 9, 9, 9, 9, 0, 0, 0)
 *     }}}
 *
 * @def ensureCapacity -> Maintain needed capacity
 *
 *     [[Array]] size cannot be changed, so this method does not 'ensureCapacity' for this [[Array]], it is rather a tool to be used
 *
 *     @param required     size of array
 *     @param setter       function to be called with new copied array of at least required size
 *     @param reserveExtra extra percent capacity over required size added to new copied array
 *     @example
 *     {{{
 *         var array = Array.get[Char](2)
 *         var count = 0
 *
 *         def add(c: Char) {
 *           count += 1
 *           array.ensureCapacity(count, array = _, 0.Percent)
 *           array(count - 1) = c
 *         }
 *
 *         ('a' <> 'z').all.apply(add)
 *
 *         count.lp
 *         array.all.lp
 *
 *         // Output
 *         26
 *         ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
 *     }}}
 */
