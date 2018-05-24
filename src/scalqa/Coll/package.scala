package scalqa

package object Coll {
  type O[A] = O._Trait[A]
  type W[A] = W._Trait[A]
  type WO[A] = WO._Trait[A]
  type Val[A] = Val._Class[A]

  def get[A](vs: A*)(implicit t: Tag[A]): Coll[A] = Array.get(vs: _*)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[A] -> With values
 *
 *    Creates [[Coll]] with specified values
 *    {{{
 *       val x = Coll.get(3, 6, 9) // Creates Coll of Ints
 *       x.all.lp                  // Prints: ~(3, 6, 9)
 *    }}}
 */
