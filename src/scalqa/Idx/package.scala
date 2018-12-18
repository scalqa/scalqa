package scalqa

package object Idx {
  private[scalqa] def This = this
  type I[A] = I._Trait[A]
  type M[A] = M._Trait[A]
  type O[A] = O._Trait[A]
  type OM[A] = OM._Trait[A]
  type Array[A] = Array._Class[A]
  type Selection[A] = Selection._Trait[A]

  type Change[A] = O.Change[A]
  type Add[A] = O.Change.Add[A]; val Add = O.Change.Add
  type Remove[A] = O.Change.Remove[A]; val Remove = O.Change.Remove
  type Refresh[A] = O.Change.Refresh[A]; val Refresh = O.Change.Refresh
  type Reposition[A] = O.Change.Reposition[A]; val Reposition = O.Change.Reposition

  type Range = Range._Class

  def make[A](vs: A*): Idx[A] = Refs.make(vs: _*)

  def wrap[A](v: java.util.List[A]): Idx[A] = v.I.as[Idx[A]](Idx.Z.A.JavaProxy[A](_))

  val Void: Idx[Nothing] with Idx.O[Nothing] = new O[Nothing] with Void {
    def size = 0
    def apply(i: Int) = App.Fail("Requesting element '" + i + "' on empty Idx")
    def onChange(f: Idx[Change[Nothing]] => Any): App.Event = \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def make[A] -> With values
 *
 *    Creates [[Idx]] with specified values
 *    {{{
 *       val x = Idx.make(3, 6, 9) // Creates Idx of Ints
 *       x.all.lp                   // Prints: ~(3, 6, 9)
 *    }}}
 *
 * @def wrap -> Java List get
 *
 *    Creates [[Idx]] view of given Java List
 */
