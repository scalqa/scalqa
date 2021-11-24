package scalqa; package `val`; package idx; import language.implicitConversions

import scala.{ Ordering as O }

trait Mutable[A] extends Idx[A] with Val.Collection.Mutable[A] with gen.able.Contain[A]:
  inline   def +@= (inline position:Int, inline v: A)      : this.type  = { addAt(position, v);    this }
  inline   def ++@=(inline position:Int,inline v:Stream[A]): this.type  = { addAllAt(position, v); this }
  /**/     def add(v: A)                                   : Unit       = addAt(size, v)
  /**/     def addAt(position: Int, v: A)                  : Unit
  override def addAll(v: Stream[A])                        : Unit       = v.foreach(add)
  /**/     def addAllAt(position: Int, v: Stream[A])       : Unit       = v.zipIndex(position).foreach(v => addAt(v._1, v._2))
  /**/     def updateAt(position: Int, s: A)               : Unit
  /**/     def updateAllAt(position: Int, s: Stream[A])    : Unit       = this.stream.foreachIndexed(updateAt, position)
  /**/     def reposition(v: Idx.Permutation)              : Unit       = v.reposition(this)
  /**/     def sort                 (using c: Ordering[A]) : Unit       = this.stream.sort(using c).foreachIndexed(this.update(_, _))
  /**/     def remove(v: A)                                : Int        = (0 <>> size).stream.reverse.take(apply(_) == v).peek(removeAt).count
  /**/     def removeAt(position: Int)                     : Unit       = removeRange(position <> position)
  /**/     def removeRange(range: Int.Range)               : Unit
  override def clear                                       : Unit       = removeRange(0 <>> size)

object Mutable:
  /**/     inline def apply[A](inline initSize: Int=J.initSize): Mutable[A]             = new lang.anyref.Buffer(initSize)
  /**/            def sealable[A](initSize: Int = J.initSize)  : Mutable[A] & Able.Seal = new z.mutable.AsSealable(apply[A](initSize))
  /**/            def wrap[A](v: java.util.List[A])            : Mutable[A]             = z.as.JavaListWrap.Mutable[A](v)
  /**/            def wrap[A](v:  Idx[A])                      : Mutable[A]             = v match{ case v:Idx.M[_] => v.cast[Idx.M[A]]; case v => new z.Unsupported_View.M[A](v)}
  implicit inline def implicitRequest[A](v: NEW)               : Mutable[A]             = apply[A]()

  extension[A](x: Mutable[A])
    def updateFor(f: A => Boolean, value: A)            : Int             = { var c = 0; x.stream.foreachIndexed((i, v) => if (f(v)) { c += 1; x.update(i, value) }); c }
    def removeFor(f: A => Boolean)                      : Int             = { var c = 0; (0 <>> x.size).stream.reverse.foreach(i => if (f(x(i))) { c += 1; x.removeAt(i) }); c }
    def sortReversed                    (using o: O[A]) : Unit            = x.sort(using o.reverse)
    def readOnlyView                                    : Idx[A]          = idx.z.View.ReadOnly[A](x)
    def mutableMapView[B](m: A=>B, r: B => A)           : Mutable[B]      = mutableMapView(using TwoWayFunction(m,r))
    def mutableMapView[B](using m:TwoWayFunction[A,B])  : Mutable[B]      = z.TwoWay_View.M[A,B](x, m)
    def sortBy[B](f:  A=>B)             (using o: O[B]) : Unit            = x.sort(using o.on(f))
    def sortBy[B,C](f1:A=>B,f2:A=>C)  (using O[B],O[C]) : Unit            = x.sortBy(a => (f1(a), f2(a)))
    def sortBy[B,C,D](f1:A=>B,f2:A=>C,f3:A=>D)(using O[B],O[C],O[D]):Unit = x.sortBy(a => (f1(a), f2(a), f3(a)))
  extension[SELF <: Mutable[A], A](x: SELF)
    inline def update(inline position:Int, inline v: A) : Unit            = x.updateAt(position, v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = mutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Mutable -> ### Mutable Indexed Collection

      Mutable indexed collection provides methods to modify its content based on element position

@def sort ->  Sort elements

       Sorts elements in `this` container

@def sortBy -> Sort by property

       Sorts elements in `this` container based on given property map

@def sortBy -> Sort by two properties

       Sorts elements in `this` container based on given two properties

@def sortBy -> Sort by three properties

       Sorts elements in `this` container based on given three properties

@def sortReversed ->  Sort in reverse

       Sorts elements in `this` container in reverse

@def add -> Append element

    Adds given element to the end of this [[Idx]]

@def addAll -> Append all

    Adds all stream values to the end of this [[Idx]]

@def addAt ->  Add at position

      Adds `element` at given `position`
      ```
         // Generic example
         val x = ('A' <> 'F').stream.toBuffer

         x.addAt(3, 'd')
         x.addAt(2, 'c')
         x.addAt(1, 'b')
         x.addAt(0, 'a')

         x.stream.TP // Prints Stream(a, A, b, B, c, C, d, D, E, F)
      ```

@def +@= -> Alias for [[addAt]]

      Adds `element` at given `position`
      ```
         // Generic example
         val x = ('A' <> 'F').stream.toBuffer

         x +@= (3, 'd') +@= (2, 'c') +@= (1, 'b') +@= (0, 'a')

         x.stream.TP // Prints Stream(a, A, b, B, c, C, d, D, E, F)
      ```

@def addAllAt -> Add stream at position

      Adds stream `elements` at given `position`
      ```
         // Generic example
         val x = ('A' <> 'F').stream.toBuffer

         x.addAllAt(4, 'e' <> 'g')
         x.addAllAt(1, Stream('b','c','d'))

         x.stream.TP // Prints Stream(A, b, c, d, B, C, D, e, f, g, E, F)
      ```

@def ++@= -> Alias for [[addAllAt]]

      Adds stream `elements` at given `position`
      ```
         // Generic example
         val x = ('A' <> 'F').stream.toBuffer

         x ++@= (4, 'e' <> 'g') ++@= (1, Stream('b','c','d'))

         x.stream.TP // Prints Stream(A, b, c, d, B, C, D, e, f, g, E, F)
      ```

@def remove -> Remove element

    Removes all Idx elements, which are equal to the given value

    Returns count of removed elements, which can be 0, 1, or many

@def removeAt -> Remove at position

      Removes element at given position
      ```
        // Generic example
        val x = ('A' <> 'D').stream.toBuffer

        x.remove(2)
        x.remove(1)

        x.stream.TP // Prints Stream(A, D)
      ```


@def removeRange -> Remove range

      Removes elements at given range
      ```
        // Generic example
        val x = (0 <> 10).stream.toBuffer

        x.remove(7 <> 8)
        x.remove(2 <> 4)

        x.stream.TP // Prints Stream(0, 1, 5, 6, 9, 10)
      ```


@def reposition -> Reorganizes elements

      Reorganizes elements according to the given permutation
      ```
         val im: Idx.Mutable[Int] = (0 <> 9).stream.toBuffer

         val p = Idx.Permutation.pairs(3 -> 7, 7 -> 3, 4 -> 6, 6 -> 4)

         im.stream.TP
         im.reposition(p)
         im.stream.TP

         // Output
         Stream(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
         Stream(0, 1, 2, 7, 6, 5, 4, 3, 8, 9)
       ```

@def updateAt ->  Update at position

      Replaces element at given position with given value

      ```
         val im: Idx.Mutable[Int] = (0 <> 7).stream.toBuffer

         im.updateAt(7, 777)
         im.updateAt(3, 333)

         im.stream.TP // Prints Stream(0, 1, 2, 333, 4, 5, 6, 777)

         // The same can be done with Scala symplified syntax

         im(7) = 777
         im(3) = 333

      ```

@def updateAllAt ->  Update many at position

      Replaces elements starting at given position with stream values

*/
