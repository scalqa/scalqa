package scalqa; package `val`; import language.implicitConversions

trait Idx[+A] extends Collection[A]:
  def apply(i: Int) : A
  def size          : Int
  def stream        : Stream[A] = idx.z.DefaultStream(this)

object Idx:
  /**/                 def apply[A](v: A)                   : Idx[A]         = Pack(v)
  /**/                 def apply[A](v1:A, v2:A)             : Idx[A]         = Pack(v1,v2)
  /**/                 def apply[A](v1:A, v2:A, v3:A, vs:A*): Idx[A]         = Pack(v1,v2,v3,vs *)
  /**/                 def wrap[A](v: java.util.List[A])    : Idx[A]         = idx.z.as.JavaListWrap[A](v)
  @tn("getVoid")inline def void[A]                          : Idx[A]         = \/ : Pack[A]
  /**/                 def unapplySeq[A](v: Idx[A])         : Option[Seq[A]] = Some(v.toSeqView)
  implicit      inline def implicitRequest[A](v: \/)        : Idx[A]         = void

  extension[A] (x: Idx[A])
    def applyOpt(position: Int)                         : Opt[A]            = if (position < 0 || position >= x.size) \/ else x(position)
    def contains(v:A)                                   : Boolean           = {var i=0; val sz=x.size; while(i<sz){if(x(i) == v) return true; i+=1}; false}
    def head                                            : A                 = x.applyOpt(0).get
    def headOpt                                         : Opt[A]            = x.applyOpt(0)
    def tail                                            : Idx[A]            = {import idx.z.{Tail_View as V}; if(x.isInstanceOf[V[_]]) x.cast[V[A]].tail else if(x.size<=1) \/ else new V(x,1)}
    def last                                            : A                 = x.lastOpt.get
    def lastOpt                                         : Opt[A]            = x.applyOpt(x.size - 1)
    def rangeView(r: Int.Range)                         : Idx[A]            = idx.z.View.Range(x, r.start, r.size)
    def reversedView                                    : Idx[A]            = idx.z.Reversed_View(x)
    def mapView[B](f: A => B)                           : Idx[B]            = idx.z.Convert_View(x, f)
    def toJavaListView                                  : java.util.List[A] = idx.z.JavaList_View(x)
    def toProductView                                   : Product           = idx.z.Product_View(x)
    def toSeqView                 :scala.collection.immutable.IndexedSeq[A] = idx.z.View.IndexedSeq(x)
    def orderedContains(v: A)       (using Ordering[A]) : Boolean           = idx.z.Ordered.contains[A](x,v)
    def orderedSearch(v:A,max:Int=1)(using Ordering[A]) : Int.Range         = idx.z.Ordered.search(x,v,max)
    def orderedSearchBy[B](map:A=>B,v:B,max:Int=1,
        extraFilter: A=>Boolean= \/)(using Ordering[B]) : Int.Range         = idx.z.Ordered.searchBy(x,v,map,max,extraFilter)
  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Mutable           = idx.Mutable;              type Mutable[A]           = idx.Mutable[A]
  transparent inline def M                 = Mutable;                  type M[A]                 = Mutable[A]
  transparent inline def Observable        = idx.Observable;           type Observable[A]        = idx.Observable[A]
  transparent inline def O                 = Observable;               type O[A]                 = Observable[A]
  transparent inline def ObservableMutable = idx.ObservableMutable;    type ObservableMutable[A] = idx.ObservableMutable[A]
  transparent inline def OM                = ObservableMutable;        type OM[A]                = ObservableMutable[A]
  transparent inline def Selection         = idx.Selection;            type Selection[A]         = idx.Selection[A]
  transparent inline def Event             = idx.observable.Event;     type Event[A]             = idx.observable.Event[A]
  transparent inline def Permutation       = idx.Permutation;          type Permutation          = idx.Permutation
  transparent inline def X                 = idx.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Idx -> ### Indexed Collection

   Elements in [[scalqa.val.Idx Idx]] can be efficiently accessed with Int index starting from 0

   The immutable implementation of [[scalqa.val.Idx Idx]] is [[scalqa.val.Pack Pack]]

@def apply -> Returns element at specified position

      ```
        val idx: Idx[Char] = ('A' <> 'Z').stream.pack

        idx(1).TP // Prints: B

        idx(4).TP // Prints: E
      ```


@def stream  -> Returns a [[Stream]] of all elements

      The element order is same as in the Idx itself

      ```
         val l: Idx[Char] = ('a' <> 'g').stream.pack

         l.stream.TP  // Prints Stream(a, b, c, d, e, f, g)
      ```

@def head -> First element

    Returns first elements or fails for empty Idx

    Use [[headOpt]] for safer access

@def headOpt -> First optional element

    Returns first elements or empty option for empty Idx

@def tail -> Idx without first element

    The returned [[tail]] can be empty

    Note. This operation creates a tail "view" of target Idx, so target mutations may cause problem

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@def  M      -> Alias \n\n Shortcut to [[scalqa.val.idx.Mutable$ Idx.Mutable]]
@type M      -> Alias \n\n Shortcut to [[scalqa.val.idx.Mutable Idx.Mutable]]
@def  O      -> Alias \n\n Shortcut to [[scalqa.val.idx.Observable$ Idx.Observable]]
@type O      -> Alias \n\n Shortcut to [[scalqa.val.idx.Observable Idx.Observable]]
@def  OM     -> Alias \n\n Shortcut to [[scalqa.val.idx.ObservableMutable$ Idx.ObservableMutable]]
@type OM     -> Alias \n\n Shortcut to [[scalqa.val.idx.ObservableMutable Idx.ObservableMutable]]
@def  Event -> Alias \n\n Shortcut to [[scalqa.val.idx.observable.Change$ Idx.Observable.Event]]
@type Event -> Alias \n\n Shortcut to [[scalqa.val.idx.observable.Event Idx.Observable.Event]]

*/

