package scalqa; package Index; package W

trait _Trait[A] extends Index[A] with Coll.W[A] {

  def addAt(position: Int, e: A)

  def replaceAt(position: Int, e: A)

  def removeAt(range: Int.Range)

  def reposition(r: Int.Range.Reposition): Unit = r(this)

  def order(o: Sorting[A]): Unit = if (isInstanceOf[O[A]]) reposition(Int.Range.Reposition.getBySorting(this)(o)) else this.asJavaList.sort(o.asComparator)

  final def add(e: A): Unit = addAt(size, e)

  final def remove(e: A): Unit = this.all.findIdxOpt(_ == e).map[Int.Range](_ <>!).apply(removeAt)

  final def clear: Unit = removeAt(size.Range)

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): W[A] = Void.cast

  implicit def zzLibrary[A](c: W[A]) = new _library[A, c.type](c)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Writable Index Collection'''
 *
 *    Writable index collection provides methods to modify its content based on element position
 *
 * @def order -> Sort
 *
 *    Reorganizes elements according to the given [[Sorting]]
 *    {{{
 *       val iw: Index.W[Int] = (0 ~ 7 ~ 1 ~ 6 ~ 2 ~ 5 ~ 3 ~ 4).to[Index.W]
 *
 *       iw.order(Sorting.The.Int) // 'iw.sort' is same library shortcut
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 3, 4, 5, 6, 7)*
 *    }}}
 *
 * @def reposition -> Reorganizes elements
 *
 *    Reorganizes elements according to the given reposition
 *    {{{
 *       val iw: Index.W[Int] = (0 <> 9).all.to[Index.W]
 *
 *       val r = Int.Range.Reposition.getByAll((3, 7) ~ (7, 3) ~ (4, 6) ~ (6, 4))
 *
 *       iw.all.lp
 *       iw.reposition(r)
 *       iw.all.lp
 *
 *       // Output
 *       ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 *       ~(0, 1, 2, 7, 6, 5, 4, 3, 8, 9)
 *     }}}
 * @def removeAt -> Removes elements at range
 *
 *    Removes elements at given range
 *    {{{
 *       val iw: Index.W[Int] = (0 <> 10).all.to[Index.W]
 *
 *       iw.removeAt(3 <> 7)
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 8, 9, 10)
 *    }}}
 * @def replaceAt -> Replaces element at position
 *
 *    Replaces an element at given position
 *    {{{
 *       val iw: Index.W[Int] = (0 <> 7).all.to[Index.W]
 *
 *       iw.replaceAt(7, 777)
 *       iw.replaceAt(3, 333)
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 333, 4, 5, 6, 777)
 *    }}}
 * @def addAt -> Add element at position
 *
 *    Adds an element at given position
 *    {{{
 *       val iw: Index.W[Int] = (0 <> 7).all.to[Index.W]
 *
 *       iw.addAt(7, 777)
 *       iw.addAt(3, 333)
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 333, 3, 4, 5, 6, 777, 7)
 *    }}}
 */
