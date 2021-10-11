package scalqa; package lang; package short; package g; import language.implicitConversions

abstract class Stream[A<:Raw] extends Val.~[A] with ~~.Custom.Discharge[A] with any.z.PrimitiveTag.Short:
  self =>
  @tn("readRaw_Opt")      def readRaw_?                                   : G.Opt[A]
  @tn("read_Opt")         def read_?                                      : Val.Opt[A]    = readRaw_?.ref
  /**/             inline def filter(    inline f: Fun.Filter[A])         : Stream[A]     = take(f)
  /**/             inline def withFilter(inline f: Fun.Filter[A])         : Stream[A]     = take(f)
  /**/                    def take(f: Fun.Filter[A])                      : Stream[A]     = TAKE(f(_))
  /**/                    def takeOnly(v: A)                              : Stream[A]     = TAKE(_ == v)
  /**/                    def drop(  f: Fun.Filter[A])                    : Stream[A]     = DROP(f(_))
  /**/                    def dropOnly(v: A)                              : Stream[A]     = DROP(_ == v)
  /**/                    def joinAll(v: Val.~[A])                        : Stream[A]     = Z.JointStream[A](self,v.raw)
  @tn("joinAll")   inline def ++(inline v: Val.~[A])                      : Stream[A]     = joinAll(v)
  /**/                    def foreach[U](f: Fun.Consume[A,U])             : Unit          = FOREACH(f(_))
  /**/                    def foldAs[B](start: B)(f: Fun.FoldAs[B,A])     : B             = FOLD_AS(start)(f(_,_))
  /**/                    def fold     (start: A)(f: Fun.Fold[A])         : A             = FOLD(start)(f(_,_))
  /**/                    def reduce(  f: Fun.Fold[A])                    : A             = REDUCE(f(_,_))
  @tn("reduce_Opt")       def reduce_?(f: Fun.Fold[A])                    : G.Opt[A]      = REDUCE_?(f(_,_))
  /**/                    def count                                       : Int           = {var c = 0; FOREACH(_ => c += 1); c}
  /**/                    def count(f: Fun.Filter[A])                     : Int           = {var c = 0; FOREACH(v => if(f(v)) c += 1); c}
  @tn("pack")             def ><                                          : Pack[A]       = Pack.fromStream(self)
  /**/                    def toBuffer                                    : Buffer[A]     = Buffer(self)
  /**/                    def toSet                                       : Set[A]        = Set.fromStream(self)
  /**/                    def toArray                                     : Array[A]      = Buffer.z_StreamToArray(self.cast[Stream[Primitive]]).cast[Array[A]]
  /**/                    def dischargeTo(b: Val.Buffer[A])               : Unit          = b match{case v:Buffer[A] => v.addAllRaw(self); case v => v.addAllRef(self)}
  /**/             inline def FILTER(inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.TAKE(self,f)
  /**/             inline def TAKE(  inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.TAKE(self,f)
  /**/             inline def DROP(  inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.DROP(self,f)
  /**/             inline def FOREACH[U](inline f: A=>U)                  : Unit          = {var o=readRaw_?; while(o){f(o.`val`); o=readRaw_?}}
  /**/             inline def FOLD_AS[B](inline s:B)(inline f:(B,A)=>B)   : B             = {var v=s; var o=readRaw_?; while(o){v=f(v,o.`val`); o=readRaw_?}; v}
  /**/             inline def FOLD      (inline s:A)(inline f:(A,A)=>A)   : A             = FOLD_AS(s)(f)
  /**/             inline def REDUCE(    inline f: (A,A) => A)            : A             = FOLD(readRaw_?.get)(f)
  @tn("REDUCE_Opt")inline def REDUCE_?(  inline f: (A,A) => A)            : G.Opt[A]      = { var o = readRaw_?; if(o) o=FOLD(o.`val`)(f); o}
  /**/             inline def mapIf(inline f:A=>Boolean,inline m:A=>A)    : Stream[A]     = map[A](v => if(f(v)) m(v) else v)
  /**/             inline def map     [B](inline f:A => B)                                                (using inline B:Specialized[B]): B.~  = z.stream.map(self,f)
  /**/             inline def MAP     [B](inline f:A => B)                                                (using inline B:Specialized[B]): B.~  = z.stream.map.APPLY(self,f)
  /**/             inline def flatMap [B](inline f:A=> ~[B])                                              (using inline B:Specialized[B]): B.~  = z.stream.flatMap(self,f)
  /**/             inline def FLAT_MAP[B](inline f:A=> ~[B])                                              (using inline B:Specialized[B]): B.~  = z.stream.flatMap.APPLY(self,f)
  @tn("map_Opt")   inline def map_?   [B,OPT<:Any.Opt[B]](inline f:A=>OPT)(using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.~  = z.stream.mapOpt(self,f)
  @tn("MAP_Opt")   inline def MAP_?   [B,OPT<:Any.Opt[B]](inline f:A=>OPT)(using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.~  = z.stream.mapOpt.APPLY(self,f)

object Stream:
  /**/             inline def apply    [A<:Raw](inline v:A)                  : Stream[A] = Z.Stream_ofOne(v)
  /**/                    def apply    [A<:Raw](v: A*)                       : Stream[A] = v match{ case v: scala.collection.immutable.ArraySeq.ofShort => v.unsafeArray.~.cast[Stream[A]]; case v => v.~.raw}
  @tn("getVoid")          def void     [A<:Raw]                              : Stream[A] = Z.VoidStream.cast[Stream[A]]

  implicit         inline def implicitRequest       [A<:Raw](v: \/)                    : Stream[A] = void
  implicit         inline def implicitFromArray     [A<:Raw](inline v: Array[A])       : Stream[A] = v.~
  implicit         inline def implicitFromOpt       [A<:Raw](inline v: G.Opt[A])       : Stream[A] = v.~
  implicit         inline def implicitFromCollection[A<:Raw](inline v: g.Collection[A]): Stream[A] = v.~
  implicit         inline def implicitFromRange     [A<:Raw](inline v: g.Range[A])     : Stream[A] = v.~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Stream -> ### Short Specialized Generic Stream

  To be used with Short based opaque values.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@def readRaw_? -> Read primitive              \n\n  Main specialized stream method to be implemented.
@def read_?    -> Read boxed                  \n\n  Implementation of stream "read_?" method
@def filter    -> Legacy filter               \n\n  Operation is inlined as "take"
@def FILTER    -> Legacy heavy filter         \n\n  Operation is inlined as "TAKE"
@def take      -> Main filter                 \n\n  Specialized override of "take"     method in general stream [[scalqa.val.stream._build._filter._take _filter._take]] interface
@def TAKE      -> Heavy filter                \n\n  Specialized override of "TAKE"     method in general stream [[scalqa.val.stream._build._filter._take _filter._take]] interface
@def takeOnly  -> Single value filter         \n\n  Specialized override of "takeOnly" method in general stream [[scalqa.val.stream._build._filter._take _filter._take]] interface
@def drop      -> Main reverse filter         \n\n  Specialized override of "drop"     method in general stream [[scalqa.val.stream._build._filter._drop _filter._drop]] interface
@def DROP      -> Reverse heavy filter        \n\n  Specialized override of "DROP"     method in general stream [[scalqa.val.stream._build._filter._drop _filter._drop]] interface
@def dropOnly  -> Single value reverse filter \n\n  Specialized override of "dropOnly" method in general stream [[scalqa.val.stream._build._filter._drop _filter._drop]] interface
@def ++        -> Alias for join all          \n\n  Specialized override of "joinAll"  method in general stream [[scalqa.val.stream._build._extend _extend]] interface
@def joinAll   -> Join all                    \n\n  Specialized override of "joinAll"  method in general stream [[scalqa.val.stream._build._extend _extend]] interface
@def foreach   -> Process stream              \n\n  Specialized override of "foreach"  method in general stream [[scalqa.val.stream._use._process _process]] interface
@def FOREACH   -> Heavy process stream        \n\n  Specialized override of "FOREACH"  method in general stream [[scalqa.val.stream._use._process _process]] interface
@def foldAs    -> Fold and convert            \n\n  Specialized override of "foldAs"   method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def FOLD_AS   -> Heavy fold and convert      \n\n  Specialized override of "FOLD_AS"  method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def fold      -> Fold                        \n\n  Specialized override of "fold"     method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def FOLD      -> Heavy fold                  \n\n  Specialized override of "FOLD"     method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def reduce    -> Reduce                      \n\n  Specialized override of "reduce"   method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def REDUCE    -> Heavy reduce                \n\n  Specialized override of "REDUCE"   method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def reduce_?  -> Optional reduce             \n\n  Specialized override of "reduce_?" method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def REDUCE_?  -> Heavy optional reduce       \n\n  Specialized override of "REDUCE_?" method in general stream [[scalqa.val.stream._use._aggregate _aggregate]] interface
@def count     -> Count all                   \n\n  Specialized override of "count"    method in general stream [[scalqa.val.stream._use._evaluate _evaluate]] interface
@def count     -> Conditional count           \n\n  Specialized override of "count"    method in general stream [[scalqa.val.stream._use._evaluate _evaluate]] interface
@def ><        -> Pack                        \n\n  Specialized override of "><"       method in general stream [[scalqa.val.stream._use._transform._toCollections _toCollections]] interface
@def toBuffer  -> Convert to Buffer           \n\n  Specialized override of "toBuffer" method in general stream [[scalqa.val.stream._use._transform._toCollections _toCollections]] interface
@def toSet     -> Convert to Set              \n\n  Specialized override of "toSet"    method in general stream [[scalqa.val.stream._use._transform._toCollections _toCollections]] interface
@def toArray   -> Convert to Array            \n\n  Specialized override of "toArray"  method in general stream [[scalqa.val.stream._use._transform._toCollections _toCollections]] interface
@def dischargeTo -> Custom discharge          \n\n  Custom discharge implementation, which will benefit operations like: ><, toBuffer, toArray and others
@def map       -> Map                         \n\n  Specialized override of "map"      method in general stream [[scalqa.val.stream._build._map _map]] interface
@def mapIf     -> Conditional map             \n\n  Specialized override of "mapIf"    method in general stream [[scalqa.val.stream._build._map _map]] interface
@def MAP       -> Heavy map                   \n\n  Specialized override of "MAP"      method in general stream [[scalqa.val.stream._build._map _map]] interface
@def flatMap   -> Map                         \n\n  Specialized override of "flatMap"  method in general stream [[scalqa.val.stream._build._map _map]] interface
@def FLAT_MAP  -> Map                         \n\n  Specialized override of "FLAT_MAP" method in general stream [[scalqa.val.stream._build._map _map]] interface
@def map_?     -> Optional map                \n\n  Specialized override of "map_?"    method in general stream [[scalqa.val.stream._build._map _map]] interface
@def MAP_?     -> Heavy optional map          \n\n  Specialized override of "MAP_?"    method in general stream [[scalqa.val.stream._build._map _map]] interface

*/
