package scalqa

package object Index {
  type W[A] = W._Trait[A]
  type O[A] = O._Trait[A]
  type WO[A] = WO._Trait[A]
  type Val[A] = Val._Class[A]
  type Selection[A] = Selection._Trait[A]

  val Void: Index[Nothing] with Index.O[Nothing] = Z.The.Void

  def get[A](vs: A*)(implicit t: Tag[A]): Index[A] = Array.get(vs: _*)

  def getOne[A](a: A): Index[A] = new Z.The.One(a)

  def getWrap[A](v: java.util.List[A]): Index[A] = v.I.as(classOf[Index[A]], Index.Z.The.JavaProxy[A](_))

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
 *    Creates [[Index]] with specified values
 *    {{{
 *       val x = Index.get(3, 6, 9) // Creates Index of Ints
 *       x.all.lp                   // Prints: ~(3, 6, 9)
 *    }}}
 *
 * @def getOne -> Single element
 *
 *     Creates [[Index]] with specified single element
 *
 * @def getWrap -> Java List wrap
 *
 *    Creates [[Index]] view of given Java List
 */
