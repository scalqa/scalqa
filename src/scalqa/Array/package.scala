package scalqa

package object Array {
  type Like[A, TRGT] = Like._Trait[A, TRGT]
  type Raw[A] = scala.Array[A]; val Raw = scala.Array

  def get[A](size: Int)(implicit t: Tag[A]): Array[A] = t.newArray(size) // Need single parameter overload to compete with apply(vs: A*)

  def get[A](vs: A*)(implicit t: Tag[A]): Array[A] = vs match {
    case a: scala.collection.mutable.WrappedArray[A] => new Array[A](a.array.cast)
    case _ => vs.all.to(Pipe.To.Array)
  }

  def getWithDefailt[A](size: Int, default: A)(implicit t: Tag[A]): Array[A] = t.newArray(size, default)

  def getByClass[A](c: Any.Class[A], len: Int)(implicit t: Tag[A]): Array[A] = t.Opt.map(_.newArray[A](len)) or get(len)(c.tag)

  def getByRaw[A](raw: Array.Raw[_ >: A]) = new Array[A](raw)

  // --------------------------------------------------------------------------------
  private[scalqa] val VoidRaw = new Array.Raw[AnyRef](0)
  private[scalqa] val Void: Array[Nothing] = getByRaw(VoidRaw).cast
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[A](vs -> By values
 *
 *     Creates [[Array]] with values provided
 *
 *     {{{
 *       val a1 = Array.get[Double](1,3,5,7) // Explivit type Double
 *
 *       val a2 = Array.get(1,3,5,7)         // Implicit type Int
 *     }}}
 *
 *
 * @def get[A](size: Int) -> Empty array
 *
 *     Creates empty [[Array]] of given size
 *
 *     {{{
 *       val a1 = Array.get[String](12)       // With specified type
 *
 *       val a2 : Array[Int] = Array.get(12)  // With context type
 *     }}}
 *
 *
 * @def getByClass -> With Class
 *
 *     Creates [[Array]] of given size based on [[Any.Class]]
 *
 *     {{{
 *         val a = Array.getWithDefailt(12, 'a')
 *
 *         a.all.lp // Prints: ~(a, a, a, a, a, a, a, a, a, a, a, a)
 *     }}}
 *
 * @def getWithDefailt -> With default
 *
 *     Creates [[Array]] of given size, filled with ''default'' value
 *
 *     {{{
 *         val a = Array.getWithDefailt(12, 'a')
 *
 *         a.all.lp // Prints: ~(a, a, a, a, a, a, a, a, a, a, a, a)
 *     }}}
 *
 * @def getByRaw -> With raw
 *
 *     Creates [[Array]] based of given [[Raw]] array
 *
 * @type Raw -> Scala array alias
 *
 *     Scala Array and its companion object can universally be referenced in two way
 *
 *       - scala.Array
 *       - Array.Raw
 */
