package scalqa; package Index; package WO

trait _Trait[A] extends W[A] with O[A] with Coll.WO[A] {
  protected type COLL_W = W[A]

  def refreshAt(r: Int.Range)

  def multiChange(ch: W[A] => Any)

}

object _Trait extends Able.Void.Companion.Typed[WO](Z.The.Void) {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](c: WO[A]) = new _library[A, c.type](c);

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Observable Writable Index Collection'''
 *
 * @def refreshAt(r: Int.Range) -> Refresh range
 *
 *     Two things happen:
 *
 *       - If any element at the specified range implements [[Able.Refresh]], its ''refresh'' method is executed
 *       - An event containing [[Index.O.Refresh]] is propagated to ''this'' Index listeners.
 *
 *     {{{
 *      val c: Index.WO[Int] = (1 <> 20).all.repeat(3).to[Index.WO]
 *
 *      c.onChange(_.all.tp)
 *
 *      c.refreshAt(10 <> 15)
 *
 *      // Output
 *
 *      ------- ---------
 *      name    range
 *      ------- ---------
 *      Refresh 10 <>> 16
 *      ------- ---------
 *   }}}
 */
