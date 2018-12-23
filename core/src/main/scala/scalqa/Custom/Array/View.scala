package scalqa; package Custom; package Array

trait View[@specialized(DATA) A] extends Any with Any.Able.Void {
  protected type TYPE
  protected def base: Array[A]
  protected def make: Array[A] => TYPE

  def apply(i: Int): A
  def size: Int

  def +(v: A) = make(Z.plus(base, v))
  def +~(v: ~[A]) = make(Z.plus.stream(base, v))
  def +@(i: Int, v: A) = make(Z.plus.at(base, i, v))
  def +~@(i: Int, v: ~[A]) = make(Z.plus.pipeAt(base, i, v))
  def -(v: A) = make(Z.minus(base, v))
  def -~(v: ~[A]) = make(Z.minus.stream(base, v))
  def -@(r: Idx.Range) = make(Z.minus.At(base, r))
  def -@(position: Int) = make(Z.minus.At(base, position <>!))

  def copy(r: scalqa.Idx.Range) = make(Z.copy.range(base, r))
  def copyDrop(r: scalqa.Idx.Range) = make(Z.copy.dropRange(base, r))
  def copyTo(destArray: Array[_ >: A], destPos: Int = 0, srcRangeOpt: Opt[scalqa.Idx.Range] = \/): Int = Array.Z.copy.to(base, destArray, destPos, srcRangeOpt)
  def copyFull: TYPE = copy(size.Range)
  def copyFirst(number: Int): TYPE = copy(number.Range)
  def copyLast(number: Int): TYPE = copy(size - number <>> size)
  def copyFrom(position: Int): TYPE = copy(position <>> size)
  def copyShort(cnt: Int): TYPE = copy((size - cnt).Range)

  protected def contains(v: A): Boolean = Custom.Array.Z.contains(base, v)

  def toArray(implicit t: ClassTag[A]) = { val a = new Array[A](size); System.arraycopy(base, 0, a, 0, size); a }

  override def isVoid = base.length == 0

  override def toString = this.I.id + "{size=" + size + ", array=" + Array.Z.toString(base) + "}"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def toString -> Description
 *
 *     Provides description of size and array type
 *
 * @def toArray -> Copy to Array
 *
 *     Copies all elements to a new Array
 *
 * @def contains -> Inclusion check
 *
 *     Returns true if specified value is contained within
 *
 * @def copyFull -> Copy everything
 *
 *     Copies entire content
 *
 * @def copyTo( -> Copy to another array
 *
 *     Copies elements to target array
 *
 * @def copy( -> Copy range
 *
 *     Copies elements within the range specified
 *     {{{
 *       ('A' <> 'Z').all.toArray.copy(3 <> 10).all.lp  // Prints: ~(D, E, F, G, H, I, J, K)
 *     }}}
 *
 * @def copyDrop -> Copy without range
 *
 *     Copies elements outside the range specified
 *     {{{
 *       ('A' <> 'Z').all.toArray.copyDrop(3 <> 20).all.lp // Prints: ~(A, B, C, V, W, X, Y, Z)
 *     }}}
 *
 * @def copyFirst -> Copy start
 *
 *    Copies specified number of first elements
 *     {{{
 *       ('A' <> 'Z').all.toArray.copyFirst(5).all.lp  // Prints: ~(A, B, C, D, E)
 *     }}}
 *
 *
 * @def copyLast -> Copy end
 *
 *    Copies specified number of elements at the end
 *    {{{
 *       ('A' <> 'Z').all.toArray.copyLast(5).all.lp  // Prints: ~(V, W, X, Y, Z)
 *    }}}
 *
 * @def copyFrom -> Copy end
 *
 *     Copies elements from specified position to the end
 *    {{{
 *       ('A' <> 'Z').all.toArray.copyFrom(20).all.lp  // Prints: ~(U, V, W, X, Y, Z)
 *    }}}
 *
 * @def copyShort -> Copy without end
 *
 *    Copies from the beginning, missing specified number of elements at the end
 *    {{{
 *       ('A' <> 'Z').all.toArray.copyShort(20).all.lp  // Prints: ~(A, B, C, D, E, F)
 *    }}}
 *
 * @def +( -> Plus
 *
 *   Creates a new instance with value added
 *
 *   {{{
 *     // Generic Refs example
 *     val a1: Refs[Char] = Refs.*('a', 'b', 'c')
 *     val a2: Refs[Char] = a1 + 'x' + 'y' + 'z'
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, b, c, x, y, z)
 *   }}}
 *
 * @def +~( -> Plus all
 *
 *   Creates a new instance with added stream values
 *
 *   {{{
 *     val a1: Refs[Char] = Refs.*('a', 'b', 'c')
 *     val a2: Refs[Char] = a1 +~ ~.*('x', 'y', 'z') +~ ('x' <> 'z')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, b, c, x, y, z, x, y, z)
 *   }}}
 *
 * @def +@ -> Plus at position
 *
 *   Creates a new instance with specified `value` added at specified `position`
 *
 *   {{{
 *     val a1: Chars = Chars.*('a', 'b', 'c')
 *     val a2: Chars = a1 +@ (3, 'Z') +@ (1, 'X')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, X, b, c, Z)
 *   }}}
 *
 * @def +~@ -> Plus stream at position
 *
 *   Creates a new instance with stream values added at specified `position`
 *
 *   {{{
 *     val a1: Refs[Char] = Refs.*('a', 'b', 'c')
 *     val a2: Refs[Char] = a1 +~@ (3, 'X' <> 'Z') +~@ (0, 'W' ~+ 'W' + 'W')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(W, W, W, a, b, c, X, Y, Z)
 *   }}}
 *
 * @def -( -> Subtract value
 *
 *   Creates a new instance with specified value removed
 *
 *   {{{
 *       // Generic Refs example
 *       val a1: Refs[Char] = ('a' <> 'g').all.to[Refs]
 *       val a2: Refs[Char] = a1 - 'b' - 'd' - 'f'
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, c, e, g)
 *   }}}
 *
 * @def -~ -> Subtract all values
 *
 *   Creates a new instance with all stream values removed
 *
 *   {{{
 *       // Generic Refs example
 *       val a1: Refs[Char] = ('a' <> 'g').all.to[Refs]
 *       val a2: Refs[Char] = a1 -~ ('c' <> 'e')
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, b, f, g)
 *   }}}
 *
 * @def -@(r -> Subtract range
 *
 *   Creates a new instance with elements within range removed
 *
 *   {{{
 *       // Generic Refs example
 *       val a1: Refs[Char] = ('a' <> 'g').all.to[Refs]
 *       val a2: Refs[Char] = a1 -~ ('c' <> 'e')
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, b, f, g)
 *   }}}
 *
 * @def -@(p -> Subtract position
 *
 *   Creates a new instance with given position removed
 *
 *   {{{
 *       // Generic Refs example
 *       val a1: Refs[Char] = ('a' <> 'g').all.to[Refs]
 *       val a2: Refs[Char] = a1 -~ ('c' <> 'e')
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, b, f, g)
 *   }}}
 *
 */
