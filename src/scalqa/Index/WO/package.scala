package scalqa; package Index

package object WO {
  type The[A] = The._Class[A]

  def get[A]: WO[A] = getInit[A](\/)

  def get[A](vs: A*)(implicit t: Tag[A]): WO[A] = getInit(vs.size).I(_ =+~ vs.all)

  def getInit[A](initSize: Opt[Int]): WO[A] = new The[A](initSize)

  def getWrap[A](l: W[A]): WO[A] = new Z.The.WritableWrap[A](l)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[A]: -> Default
 *
 *    Creates [[Index.WO]] with initial size equal to App.Pro.DefaultBufferSize
 *
 *    {{{   val x = Index.WO.get[Int] // Creates Index.WO of Ints  }}}
 *
 * @def get[A]( -> With values
 *
 *    Creates [[Index.WO]] with specified values
 *    {{{
 *       val x = Index.WO.get(3, 6, 9) // Creates Index.WO of Ints
 *       x.all.lp                     // Prints: ~(3, 6, 9)
 *    }}}
 *
 * @def getInit -> With initial size
 *
 *    Creates [[Index.WO]] with initial reserved size equal to the given value
 *
 *    Note. ''initSize'' does not restrict on how big the Index can grow, it is just initial space reservation
 *    {{{
 *       // Creates Index.WO of Char with initial size 12
 *       val x = Index.WO.getInit[Char](12)
 *    }}}
 *
 * @def getWrap -> Writable List wrap
 *
 *    Creates [[Index.WO]] updatable view of given [[Index.W]]
 */
