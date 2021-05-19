package scalqa; package `val`; import language.implicitConversions

import idx.z
import z. {Unsupported_View => UV}

trait Idx[+A] extends Collection[A]:
  /**/          def apply(i: Int) : A
  override      def size          : Int
  @tn("stream") def ~             : ~[A] = z.DefaultStream(this)

object Idx:
  /**/                 def apply[A](v: A)                      : Idx[A]  = Pack(v)
  /**/                 def apply[A](v1:A, v2:A)                : Idx[A]  = Pack(v1,v2)
  /**/                 def apply[A](v1:A, v2:A, v3:A, vs:A*)   : Idx[A]  = Pack(v1,v2,v3,vs *)
  /**/                 def wrap[A](v: java.util.List[A])       : Idx[A]  = z.as.JavaListWrap[A](v)
  @tn("getVoid")inline def void[A]                             : Idx[A]  = ZZ.voidPack[A]
  implicit      inline def implicitRequestVoid[A](inline v: \/): Idx[A]  = void

  extension[A] (x: Idx[A])
    /**/                         def contains(v:A)                 : Boolean           = {var i=0; val sz=x.size; while(i<sz){if(x(i) == v) return true; i+=1}; false}
    /**/                         def head                          : A                 = x.at_?(0).get
    @tn("head_Opt")              def head_?                        : Opt[A]            = x.at_?(0)
    /**/                         def tail                          : Idx[A]            = if(x.isInstanceOf[z.Tail_View[_]]) x.cast[z.Tail_View[A]].tail else if(x.size<=1) \/ else new z.Tail_View(x,1)
    @tn("at_Opt")                def at_?(position: Int)           : Opt[A]            = if (position < 0 || position >= x.size) \/ else x(position)
    /**/                         def last                          : A                 = x.last_?.get
    @tn("last_Opt")              def last_?                        : Opt[A]            = x.at_?(x.size - 1)
    @tn("readOnly_View")         def readOnly_^                    : Idx[A]            = z.View.ReadOnly(x)
    @tn("range_View")            def range_^(r: Int.<>)            : Idx[A]            = z.View.Range(x, r.start, r.size)
    @tn("reversed_View")         def reversed_^                    : Idx[A]            = z.Reversed_View(x)
    @tn("map_View")              def map_^[B](f: A => B)           : Idx[B]            = z.Convert_View(x, f)
    @tn("toJavaList_View")       def toJavaList_^                  : java.util.List[A] = z.JavaList_View(x)
    @tn("toSeq_View")            def toSeq_^ :scala.collection.immutable.IndexedSeq[A] = z.View.IndexedSeq(x)
    @tn("toProduct_View")        def toProduct_^                   : Product           = z.Product_View(x)
    def orderedContains(v: A)                  (using Ordering[A]) : Boolean           = z.Ordered.contains[A](x,v)
    def orderedSearch(v:A,max:Int=1)           (using Ordering[A]) : Int.<>            = z.Ordered.search(x,v,max)
    def orderedSearchBy[B](map:A=>B,v:B,max:Int=1,
                   extraFilter: A=>Boolean= \/)(using Ordering[B]) : Int.<>            = z.Ordered.searchBy(x,v,map,max,extraFilter)
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Mutable           = idx.Mutable;              type Mutable[A]           = idx.Mutable[A]
  inline def M                 = Mutable;                  type M[A]                 = Mutable[A]
  inline def Observable        = idx.Observable;           type Observable[A]        = idx.Observable[A]
  inline def O                 = Observable;               type O[A]                 = Observable[A]
  inline def ObservableMutable = idx.ObservableMutable;    type ObservableMutable[A] = idx.ObservableMutable[A]
  inline def OM                = ObservableMutable;        type OM[A]                = ObservableMutable[A]
  inline def Selection         = idx.Selection;            type Selection[A]         = idx.Selection[A]
  inline def Event             = idx.observable.Event;     type Event[A]             = idx.observable.Event[A]
  inline def Permutation       = idx.Permutation;          type Permutation          = idx.Permutation
  inline def X                 = idx.X
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
        val idx: Idx[Char] = ('A' <> 'Z').~.><

        idx(1).TP // Prints: B

        idx(4).TP // Prints: E
      ```


@def ~  -> Returns a [[Stream]] of all elements

      The element order is same as in the Idx itself

      ```
         val l: Idx[Char] = ('a' <> 'g').~.><

         l.~.TP  // Prints ~(a, b, c, d, e, f, g)
      ```

@def head -> First element

    Returns first elements or fails for empty Idx

    Use [[head_?]] for safer access

@def head_? -> First optional element

    Returns first elements or empty option for empty Idx

@def tail -> Idx without first element

    The returned [[tail]] can be empty

    Note. This operation creates a tail "view" of target Idx, so target mutations may cause problem

@def void  -> Get void instance

@def implicitRequestVoid -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@def  M      -> Alias \n\n Shortcut to [[scalqa.val.idx.Mutable$ Idx.Mutable]]
@type M      -> Alias \n\n Shortcut to [[scalqa.val.idx.Mutable Idx.Mutable]]
@def  O      -> Alias \n\n Shortcut to [[scalqa.val.idx.Observable$ Idx.Observable]]
@type O      -> Alias \n\n Shortcut to [[scalqa.val.idx.Observable Idx.Observable]]
@def  OM     -> Alias \n\n Shortcut to [[scalqa.val.idx.ObservableMutable$ Idx.ObservableMutable]]
@type OM     -> Alias \n\n Shortcut to [[scalqa.val.idx.ObservableMutable Idx.ObservableMutable]]
@def  Event -> Alias \n\n Shortcut to [[scalqa.val.idx.observable.Change$ Idx.Observable.Event]]
@type Event -> Alias \n\n Shortcut to [[scalqa.val.idx.observable.Event Idx.Observable.Event]]

*/

