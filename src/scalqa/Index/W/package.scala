package scalqa; package Index

package object W {
  type The[A] = The._Class[A]

  def get[A: Tag]: W[A] = getInit[A](\/)

  def get[A](vs: A*)(implicit t: Tag[A]): W[A] = getInit(vs.size).I(_ =+~ vs.all)

  def getInit[A](initSize: Opt[Int])(implicit t: Tag[A] = \/): W[A] = if (t.isValue) new The.ValWrap[A](initSize)(t) else new The[A](initSize)

  def getSealable[A: Tag](initSize: Opt[Int] = \/): W[A] with Able.Seal = new Z.The.Sealable()

  def getWrapJava[A](v: java.util.List[A]): W[A] = v.I.as(classOf[Index.W[A]], Index.W.Z.The.JavaProxy.get[A](_))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[A: -> Default
 *
 *    Creates [[Index.W]] with initial size equal to App.Pro.DefaultBufferSize
 *
 *    {{{   val x = Index.W.get[Int] // Creates Writable Index of Ints  }}}
 *
 * @def get[A] -> With values
 *
 *    Creates [[Index.W]] with specified values
 *    {{{
 *       val x = Index.W.get(3, 6, 9) // Creates Writable Index of Ints
 *       x.all.lp                     // Prints: ~(3, 6, 9)
 *    }}}
 *
 * @def getInit -> With initial size
 *
 *    Creates [[Index.W]] with initial reserved size equal to the given value
 *
 *    Note. ''initSize'' does not restrict on how big the Index can grow, it is just initial space reservation
 *    {{{
 *       // Creates Writable Index of Char with initial size 12
 *       val x = Index.W.getInit[Char](12)
 *    }}}
 * @def getSealable -> Sealable
 *
 *    Creates [[Index.W]] which can be sealed according to [[Able.Seal]] interface
 *
 *    Once sealed, all update methods will fail
 *
 * @def getWrapJava -> Java List wrap
 *
 *    Creates [[Index.W]] updatable view of given Java List
 *
 */
