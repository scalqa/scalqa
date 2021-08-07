package scalqa; package lang; package anyref; import language.implicitConversions

object G:
  @tn("Stream") transparent inline def ~          = `val`.Stream;      @tn("Stream") type ~[A]           = `val`.Stream[A]
  @tn("Range")  transparent inline def <>         = `val`.Range;       @tn("Range")  type <>[A]          = `val`.Range[A]
  @tn("Pack")   transparent inline def ><         = `val`.Pack;        @tn("Pack")   type ><[A]          = `val`.Pack[A]
  /**/          transparent inline def Buffer     = `val`.Buffer;                    type Buffer[A]      = g.Buffer[A]
  /**/          transparent inline def Collection = `val`.Collection;                type Collection[+A] = `val`.Collection[A]
  /**/          transparent inline def Idx        = `val`.Idx;                       type Idx[+A]        = `val`.Idx[A]
  /**/          transparent inline def Lookup     = `val`.Lookup;                    type Lookup[A,+B]   = `val`.Lookup[A,B]
  /**/          transparent inline def Opt        = `val`.Opt;                       type Opt[+A]        = `val`.Opt.OPAQUE.TYPE[A]
  /**/          transparent inline def Pro        = `val`.Pro;                       type Pro[+A]        = `val`.Pro[A]
  /**/          transparent inline def Promise    = `val`.Promise;                   type Promise[+A]    = `val`.Promise[A]
  /**/          transparent inline def Result     = `val`.Result;                    type Result[+A]     = `val`.Result.OPAQUE.TYPE[A]
  /**/          transparent inline def StableSet  = Collection.StableSet;            type StableSet[A]   = Collection.StableSet[A]

  /**/          transparent inline def Customized = g.Customized

package object anyref:
  opaque type Opaque <: AnyRef = AnyRef

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object G -> ### AnyRef Generic Containers

   With the exception of Buffer, AnyRef.G contains same containers as [[scalqa.Val$ Val]], which are aliased in here.

*/