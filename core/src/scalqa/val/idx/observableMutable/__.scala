package scalqa; package `val`; package idx; import language.implicitConversions

trait ObservableMutable[A] extends Observable[A] with Mutable[A] with Collection.ObservableMutable[A]:
  @tn("refresh_Range") def refresh_<>(r: Int.<>)                     : Unit
  /**/                 def refreshAt( i: Int)                        : Unit = refresh_<>(i <>= 1)
  /**/                 def modify(multiChangeFun:  Idx.M[A] => Unit) : Unit
  /**/        override def removeAll(v: ~[A])                        : Int  = z.observable.removeAll(this,v)

object ObservableMutable:
  /**/                  def apply[A](initSize: Int = J.initSize)      : Idx.OM[A] = new X.Basic[A](initSize)
  /**/                  def wrap[A](l:  Idx.M[A])                     : Idx.OM[A] = new X.Basic[A](l)
  @tn("getVoid") inline def void[A]                                   : Idx.OM[A] = z.Void.OM.cast[Idx.OM[A]]
  implicit       inline def xxRequest[A](inline v: \/)                : Idx.OM[A] = void

  extension[A]  (x: ObservableMutable[A])
    @tn("twoWay_View")  def twoWay_^[B](m: A=>B, r: B => A)           : Idx.OM[B] = twoWay_^(using TwoWayFun(m,r))
    @tn("twoWay_View")  def twoWay_^[B]     (using bm: TwoWayFun[A,B]): Idx.OM[B] = z.TwoWay_View.OM(x, bm)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def X = observableMutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ObservableMutable -> ### Observable Mutable Idx Collection

@def void  -> Get void instance

            Returns void instance, which would fail on any mutation attempt.

            [[onChage]] events can be subscribed, but nothing will ever change.

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/
