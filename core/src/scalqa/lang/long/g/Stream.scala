package scalqa; package lang; package long; package g; import language.implicitConversions

abstract class Stream[A<:Raw] extends Val.~[A] with ~~.Custom.Discharge[A] with Raw.Specialized:
  self =>
  @tn("readRaw_Opt")      def readRaw_?                                   : G.Opt[A]
  @tn("read_Opt")         def read_?                                      : Val.Opt[A]    = readRaw_?.ref
  /**/             inline def filter(    inline f: Fun.Filter[A])         : Stream[A]     = take(f)
  /**/             inline def withFilter(inline f: Fun.Filter[A])         : Stream[A]     = take(f)
  /**/                    def take(f: Fun.Filter[A])                      : Stream[A]     = TAKE(f(_))
  /**/                    def takeOnly(v: A)                              : Stream[A]     = TAKE(_ == v)
  /**/                    def takeAll( v: ~[A])                           : Stream[A]     = {val set=v.raw.toSet; if(set.isEmpty) \/   else TAKE (set.contains)}
  /**/                    def drop(  f: Fun.Filter[A])                    : Stream[A]     = DROP(f(_))
  /**/                    def dropOnly(v: A)                              : Stream[A]     = DROP(_ == v)
  /**/                    def dropAll(v: ~[A])                            : Stream[A]     = {val set=v.raw.toSet; if(set.isEmpty) self else DROP(set.contains)}
  /**/                    def joinAll(v: Val.~[A])                        : Stream[A]     = Z.JointStream[A](self,v.raw)
  @tn("_joinAll")  inline def ++(inline v: Val.~[A])                      : Stream[A]     = joinAll(v)
  /**/                    def foreach[U](f: Fun.Consume[A,U])             : Unit          = FOREACH(f(_))
  /**/                    def foldAs[B](start: B)(f: Fun.FoldAs[B,A])     : B             = FOLD_AS(start)(f(_,_))
  /**/                    def fold     (start: A)(f: Fun.Fold[A])         : A             = FOLD(start)(f(_,_))
  /**/                    def reduce(  f: Fun.Fold[A])                    : A             = REDUCE(f(_,_))
  @tn("reduce_Opt")       def reduce_?(f: Fun.Fold[A])                    : G.Opt[A]      = REDUCE_?(f(_,_))
  /**/                    def count                                       : Int           = {var c = 0; FOREACH(_ => c += 1); c}
  /**/                    def count(f: Fun.Filter[A])                     : Int           = {var c = 0; FOREACH(v => if(f(v)) c += 1); c}
  @tn("pack")             def ><                                          : Pack[A]       = Pack.fromStream(self)
  /**/                    def toBuffer                                    : Buffer[A]     = Buffer(self)
  /**/                    def toSet                                       : StableSet[A]  = StableSet(self)
  /**/                    def toArray                                     : Array[A]      = {val b=Buffer.accessible(self.size_? or J.initSize).^(_ ++= self); var a=b.access; if(a.length!=b.size) a=a.copySize(b.size); a.cast[Array[A]]}
  /**/                    def dischargeTo(b: Val.Buffer[A])               : Unit          = b match{case v:Buffer[A] => v.addAllRaw(self); case v => v.addAllRef(self)}
  /**/             inline def FILTER(inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.TAKE(self,f)
  /**/             inline def TAKE(  inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.TAKE(self,f)
  /**/             inline def DROP(  inline f: A=>Boolean)                : Stream[A]     = z.stream.filter.DROP(self,f)
  /**/             inline def FOREACH[U](inline f: A=>U)                  : Unit          = {var o=readRaw_?; while(o.nonEmpty){f(o.`val`); o=readRaw_?}}
  /**/             inline def FOLD_AS[B](inline s:B)(inline f:(B,A)=>B)   : B             = {var v=s; var o=readRaw_?; while(o.nonEmpty){v=f(v,o.`val`); o=readRaw_?}; v}
  /**/             inline def FOLD      (inline s:A)(inline f:(A,A)=>A)   : A             = FOLD_AS(s)(f)
  /**/             inline def REDUCE(    inline f: (A,A) => A)            : A             = FOLD(readRaw_?.get)(f)
  @tn("REDUCE_Opt")inline def REDUCE_?(  inline f: (A,A) => A)            : G.Opt[A]      = { var o = readRaw_?; if(o.nonEmpty) o=FOLD(o.`val`)(f); o}

object Stream:
  import gen.`given`.StreamShape
  extension[A<:Raw,T,STM<: ~~.AnyType[T]](inline x: g.Stream[A])
    /**/           inline def map      [B>:T](inline f: A => B)                  (using inline t:StreamShape[B,        STM]): STM  = z.stream.map(x,f,t)
    /**/           inline def MAP      [B>:T](inline f: A => B)                  (using inline t:StreamShape[B,        STM]): STM  = z.stream.map.APPLY(x,f,t)
    /**/           inline def flatMap  [B>:T](inline f: A => ~[B])               (using inline t:StreamShape[B,        STM]): STM  = z.stream.flatMap(x,f,t)
    /**/           inline def FLAT_MAP [B>:T](inline f: A => ~[B])               (using inline t:StreamShape[B,        STM]): STM  = z.stream.flatMap.APPLY(x,f,t)
    @tn("map_Opt") inline def map_?    [OPT<:Val.Opt.AnyType[T]](inline f:A=>OPT)(using inline t:StreamShape.Opt[T,OPT,STM]): STM  = z.stream.mapOpt(x,f,t)
    @tn("MAP_Opt") inline def MAP_?    [OPT<:Val.Opt.AnyType[T]](inline f:A=>OPT)(using inline t:StreamShape.Opt[T,OPT,STM]): STM  = z.stream.mapOpt.APPLY(x,f,t)
  // -------------------------------------------------------------------------------------------------------------------------------------------------------
  /**/             inline def apply    [A<:Raw](inline v:A)                  : Stream[A] = Z.Stream_ofOne(v)
  /**/                    def apply    [A<:Raw](v: A*)                       : Stream[A] = v match{ case v: scala.collection.immutable.ArraySeq.ofLong => v.unsafeArray.~.cast[Stream[A]]; case v => v.~.raw}
  @tn("getVoid")          def void     [A<:Raw]                              : Stream[A] = Z.VoidStream.cast[Stream[A]]

  implicit         inline def implicitFrom[A<:Raw](inline v: \/)             : Stream[A] = void
  implicit         inline def implicitFrom[A<:Raw](inline v: Array[A])       : Stream[A] = v.~
  implicit         inline def implicitFrom[A<:Raw](inline v: G.Opt[A])       : Stream[A] = v.~
  implicit         inline def implicitFrom[A<:Raw](inline v: g.Collection[A]): Stream[A] = v.~
  implicit         inline def implicitFrom[A<:Raw](inline v: g.Range[A])     : Stream[A] = v.~


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/