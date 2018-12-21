package scalqa; package Idx

package object OM {

  def make[A]: OM[A] = makeSized(\/)

  def makeSized[A](initSize: Int): OM[A] = new A.Basic[A](initSize)

  def wrap[A](l: M[A]): OM[A] = new Z.A.WritableWrap[A](l)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object OM ->
 *
 *   Canonical way to create a default observable mutable index is to use universal value [[NEW]]
 *
 *   {{{
 *       val l : Idx.OM[Long]   = NEW
 *
 *       val s : Idx.OM[String] = NEW
 *   }}}
 * *
 *
 * @def makeSized -> With initial size
 *
 *    Creates [[Idx.OM]] with initial reserved size equal to the given value
 *
 *    Note. `initSize` does not restrict on how big the Idx can grow, it is just initial space reservation
 *    {{{
 *       // Creates Idx.OM of Char with initial size 12
 *       val x = Idx.OM.makeSized[Char](12)
 *    }}}
 *
 * @def wrap -> Mutable List
 *
 *    Creates [[Idx.OM]] updatable view of given [[Idx.M]]
 */
