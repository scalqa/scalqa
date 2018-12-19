package scalqa; package Any; package Datum

package object Vals {
  private[scalqa] def This = this

  def *[A](vs: A*)(implicit setup: Any.Datum.Setup[A]): Vals[A] = {
    val a = setup.ilk.mkArray[setup.VALUE](vs.size)
    a.updateAll(vs.all.map((v: A) => setup.Map.undo(v)))
    new Vals[A](a, setup)
  }

  private[scalqa] def fromFlow[A](v: Stream.Flow[A])(implicit setup: Any.Datum.Setup[A]): Vals[A] = {
    val b = setup.ilk.mkBuffer[setup.VALUE](v.sizeOpt or App.initSize)
    v.map(setup.Map.undo(_)).copyTo(b.loader)
    new Vals[A](b.arrayBase, setup)
  }

  implicit def zzMake[A](v: \/)(implicit setup: Any.Datum.Setup[A]) = new Vals[A](setup.ilk.mkArray(0), setup)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def *[A] -> Vararg constructor
 *
 *    Creates [[Vals]] with specified values
 *
 */
