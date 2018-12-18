package scalqa; package Idx

package object M {

  def make[A](implicit i: Ilk[A]): M[A] = i.mkBuffer[A](\/)

  def makeSized[A](initSize: Int)(implicit i: Ilk[A]): M[A] = i.mkBuffer[A](initSize)

  def vals[A: Any.Datum.Setup](initSize: Int = \/): Idx.M[A] with Any.Datum.Vals.Like[A] = new A.DataVals(initSize)

  def sealable[A: Ilk](initSize: Int = \/): M[A] with Any.Able.Seal = new Z.A.Sealable(makeSized[A](initSize))

  def wrap[A](v: java.util.List[A]): M[A] = v.I.as[Idx.M[A]](Idx.M.Z.A.JavaProxy.make[A](_))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object M ->
 *
 *   Canonical way to create a default mutable index is to use universal value [[NEW]]
 *
 *   {{{
 *       val l : Idx.M[Long]   = NEW
 *
 *       val s : Idx.M[String] = NEW
 *   }}}
 *
 * @def makeSized[ -> With initial size
 *
 *    Creates [[Idx.M]] with initial reserved size equal to the given value
 *
 *    Note. `initSize` does not restrict on how big the Idx can grow, it is just initial space reservation
 *    {{{
 *       // Creates Mutable Idx of Char with initial size 12
 *       val x = Idx.M.makeSized[Char](12)
 *    }}}
 * @def sealable -> Sealable
 *
 *    Creates [[Idx.M]] which can be sealed according to [[Any.Able.Seal]] interface
 *
 *    Once sealed, all update methods will fail
 *
 * @def wrap -> Java List get
 *
 *    Creates [[Idx.M]] updatable view of given Java List
 *
 */
