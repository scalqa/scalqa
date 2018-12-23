package scalqa; package Idx; package M

trait _Trait[@specialized(DATA) A] extends Idx[A] with Any.Collection.M[A] {

  def update(position: Int, e: A): Unit

  def reposition(r: Idx.Range.Reposition): Unit = r(this)
  def order(o: Ordering[A]): Unit = if (isInstanceOf[O[A]]) reposition(Idx.Range.Reposition.fromOrdering(this)(o)) else this.asJavaListView.sort(o)

  def addAt(i: Int, v: A): Unit
  def addAllAt(i: Int, a: ~[A]): Unit = a.foreachIdx(addAt, i)
  override def add(v: A) = addAt(size, v)
  override def addAll(a: ~[A]) = addAllAt(size, a)

  def clear: Unit = removeAt(size.Range)
  def remove(e: A): Unit = this.all.findIdxOpt(_ == e).map[Idx.Range](_ <>!).apply(removeAt)
  def removeAt(r: Idx.Range): Unit
  def removeAt(position: Int): Unit = removeAt(position <>!)

  @inline final def +=@(position: Int, element: A): this.type = { addAt(position, element); this }
  @inline final def +~=@(position: Int, a: ~[A]): this.type = { addAllAt(position, a); this }

  @inline final def -=@(position: Int): this.type = { removeAt(position); this }
  @inline final def -=@(range: Idx.Range): this.type = { removeAt(range); this }
}

object _Trait {

  implicit def zzMake[A](v: \/): M[A] = Void.asInstanceOf[M[A]]

  implicit def zzMake[A: Ilk](v: NEW.type): M[A] = make[A]

  implicit def zzLibrary[A](c: M[A]) = new _library._Class[A, c.type](c)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Mutable Indexed Collection`
 *
 *    Mutable indexed collection provides methods to modify its content based on element position
 *
 * @def addAt -> Add at position
 *
 *    Adds `element` at given `position`
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Idx.M]
 *
 *       x.addAt(3, 'd')
 *       x.addAt(2, 'c')
 *       x.addAt(1, 'b')
 *       x.addAt(0, 'a')
 *
 *       x.all.lp // Prints: ~(a, A, b, B, c, C, d, D, E, F)
 *    }}}
 *
 * @def addAllAt -> Add stream at position
 *
 *    Adds stream `elements` at given `position`
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Idx.M]
 *
 *       x.addAllAt(4, 'e' <> 'g')
 *       x.addAllAt(1, 'b' ~+ 'c' + 'd')
 *
 *       x.all.lp // Prints: ~(A, b, c, d, B, C, D, e, f, g, E, F)
 *    }}}
 *
 * @def +=@ -> Add at position operator
 *
 *    Adds `element` at given `position`
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Idx.M]
 *
 *       x +=@ (3, 'd') +=@ (2, 'c') +=@ (1, 'b') +=@ (0, 'a')
 *
 *       x.all.lp // Prints: ~(a, A, b, B, c, C, d, D, E, F)
 *    }}}
 *
 * @def +~=@ -> Add all at position operator
 *
 *    Adds stream `elements` at given `position`
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Idx.M]
 *
 *       x +~=@ (4, 'e' <> 'g') +~=@ (1, 'b' ~+ 'c' + 'd')
 *
 *       x.all.lp // Prints: ~(A, b, c, d, B, C, D, e, f, g, E, F)
 *    }}}
 *
 * @def removeAt(p -> Remove at position
 *
 *    Removes element at given position
 *    {{{
 *      // Generic example
 *      val x = ('A' <> 'D').all.to[Idx.M]
 *
 *      x.removeAt(2)
 *      x.removeAt(1)
 *
 *      x.all.lp // Prints: ~(A, D)
 *    }}}
 *
 * @def removeAt(r -> Remove range
 *
 *    Removes elements at given range
 *    {{{
 *      // Generic example
 *      val x = (0 <> 10).all.to[Idx.M]
 *
 *      x.removeAt(7 <> 8)
 *      x.removeAt(2 <> 4)
 *
 *      x.all.lp // Prints: ~(0, 1, 5, 6, 9, 10)
 *    }}}
 *
 * @def -=@(p -> Remove at position operator
 *
 *    Removes element at given position
 *    {{{
 *      // Generic example
 *      val x = ('A' <> 'D').all.to[Idx.M]
 *
 *      x -=@ 2 -=@ 1
 *
 *      x.all.lp // Prints: ~(A, D)
 *    }}}
 *
 * @def -=@(r -> Remove range operator
 *
 *    Removes elements at given range
 *    {{{
 *      // Generic example
 *      val x = (0 <> 10).all.to[Idx.M]
 *
 *      x -=@ (7 <> 8) -=@ (2 <> 4)
 *
 *      x.all.lp // Prints: ~(0, 1, 5, 6, 9, 10)
 *    }}}
 *
 * @def order -> Sort
 *
 *    Reorganizes elements according to the given Ordering
 *    {{{
 *       val iw: Idx.M[Int] = (0 ~+ 7 + 1 + 6 + 2 + 5 + 3 + 4).to[Idx.M]
 *
 *       iw.order(Ordering.A.Int) // 'iw.sort' is same library shortcut
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 3, 4, 5, 6, 7)*
 *    }}}
 *
 * @def reposition -> Reorganizes elements
 *
 *    Reorganizes elements according to the given reposition
 *    {{{
 *       val iw: Idx.M[Int] = (0 <> 9).all.to[Idx.M]
 *
 *       val r = Idx.Reposition.getByAll((3, 7) ~+ (7, 3) + (4, 6) + (6, 4))
 *
 *       iw.all.lp
 *       iw.reposition(r)
 *       iw.all.lp
 *
 *       // Output
 *       ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 *       ~(0, 1, 2, 7, 6, 5, 4, 3, 8, 9)
 *     }}}
 *
 * @def update -> Replaces element at position
 *
 *    Replaces an element at given position
 *    {{{
 *       val iw: Idx.M[Int] = (0 <> 7).all.to[Idx.M]
 *
 *       iw.update(7, 777)
 *       iw.update(3, 333)
 *
 *       iw.all.lp // Prints: ~(0, 1, 2, 333, 4, 5, 6, 777)
 *    }}}
 */
