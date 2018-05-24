package scalqa; package Array; package Like

trait _basic[A, ARRAY[A]] extends Any with __[A, ARRAY] with Index[A] with Able.Void {

  protected override def isVoid = raw.length == 0

  @inline def apply(i: Int): A = raw(i).cast[A]

  @inline def size: Int = raw.length

  def contains(v: A): Boolean = { var i = 0; while (i < raw.length) { if (raw(i) == v) return true; i += 1 }; false }

  override def all: ~[A] = new Z.all(raw)

  def length: Int = raw.length // Need this because of a strange bug, "val Ints(first, second) = Ints.get(1,2)" would fail otherwise

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def length -> Number of elements
 *
 *     Same as size
 *
 * @def contains -> Enclose check
 *
 *     Returns ''true'' if there is data element equal to the specified
 *
 *     {{{
 *       val a: Array[Char] = Array.get('a', 'b', 'c')
 *
 *       a.contains('b').lp // Prints: true
 *       a.contains('z').lp // Prints: false
 *     }}}
 */
