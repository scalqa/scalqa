package scalqa; package `val`; package idx; import language.implicitConversions

trait ObservableMutable[A] extends Observable[A] with Mutable[A] with Collection.ObservableMutable[A]:
  @tn("refresh_Range")  def refresh_<>(r: Int.<>)                   : Unit
  /**/                  def refreshAt( i: Int)                      : Unit      = refresh_<>(i <>= 1)
  /**/                  def modify(multiChangeFun: Idx.M[A] => Unit): Unit
  /**/         override def removeAll(v: ~[A])                      : Int       = z.observable.removeAll(this,v)

object ObservableMutable:
  /**/           inline def apply[A](inline initSize:Int=J.initSize): Idx.OM[A] = new X.Basic[A](initSize)
  @tn("getVoid") inline def void[A]                                 : Idx.OM[A] = z.Void.OM.cast[Idx.OM[A]]
  /**/                  def wrap[A](v:  Idx[A])                     : Idx.OM[A] = v match
    /**/                                                                           case v:Idx.OM[_] => v.cast[Idx.OM[A]];
    /**/                                                                           case v:Idx.M[_]  => new X.Basic[A](v.cast[Idx.M[A]])
    /**/                                                                           case v:Idx.O[_]  => new z.Unsupported_View.O.OM[A](v.cast[Idx.O[A]])
    /**/                                                                           case v           => new z.Unsupported_View.OM[A](v)
  implicit       inline def implicitRequest[A](v: \/)               : Idx.OM[A] = void
  implicit       inline def implicitRequest[A](inline v: NEW)       : Idx.OM[A] = apply[A]()

  extension[A]  (x: ObservableMutable[A])
    @tn("mutableMap_View") def mutableMap_^[B](m: A=>B, r: B => A)               : Idx.OM[B] = mutableMap_^(using TwoWayFunction(m,r))
    @tn("mutableMap_View") def mutableMap_^[B](using bm: TwoWayFunction[A,B]): Idx.OM[B] = z.TwoWay_View.OM(x, bm)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = observableMutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ObservableMutable -> ### Observable Mutable Indexed Collection

@def void  -> Get void instance

            Returns void instance, which would fail on any mutation attempt.

            [[onChage]] events can be subscribed, but nothing will ever change.

@def modify -> Single transaction interface

            Allows to make multiple changes to the underlying collection, generating a single change event

@def refreshAt -> Creates a refresh event

            Refresh event is an Update event for specified elements, where old and new values are the same.

            Supposedly, the elements themself are mutable and their representation has to be "refreshed"

@def refresh_<> -> Creates a refresh event for range of elements

            Refresh event is an Update event for specified elements, where old and new values are the same.

            Supposedly, the elements themself are mutable and their representation has to be "refreshed"

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
