package scalqa; package lang; package short; import language.implicitConversions

object G:
  /**/          type Containers[A<:Raw]      = g.Containers[A];                       transparent inline def Companion  = g.Companion
  @tn("Stream") type ~         [A<:Raw]      = g.Stream[A];             @tn("Stream") transparent inline def ~          = g.Stream
  @tn("Range")  type <>        [A<:Raw]      = g.Range[A];              @tn("Range")  transparent inline def <>         = Range
  @tn("Pack")   type ><        [A<:Raw]      = g.Pack[A];               @tn("Pack")   transparent inline def ><         = g.Pack
  /**/          type Opt       [A<:Raw]      = g.Opt.TYPE.DEF[A];                     transparent inline def Opt        = g.Opt
  /**/          type Buffer    [A<:Raw]      = g.Buffer[A];                           transparent inline def Buffer     = g.Buffer
  /**/          type Collection[A<:Raw]      = g.Collection[A];                       transparent inline def Collection = g.Collection
  /**/          type Idx       [A<:Raw]      = g.Idx[A];                              transparent inline def Idx        = g.Idx
  /**/          type Lookup    [A<:Raw,B]    = g.Lookup[A,B];                         transparent inline def Lookup     = g.Lookup
  /**/          type Set       [A<:Raw]      = g.Set[A];                              transparent inline def Set        = g.Set
  /**/          type Pro       [A<:Raw]      = g.Pro[A];                              transparent inline def Pro        = g.Pro
  /**/                                                                                transparent inline def Fun        = g.Fun
  /**/          type Math[A<:Raw]            = g.Math[A];                             transparent inline def Math       = g.Math
  /**/          type Ordering  [A<:Raw]      = g.Math.Ordering[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object G -> ### Short Generic Specialized Containers

   The generic containers are never used directly, but rather as customized shortcuts for specific types.

   For example:

      - `Short.G.><[Short]`       usually called as `Short.><`
      - `Double.G.Idx[Percent]`   usually called as `Percent.Idx`
      - `Int.G.Pro.Mutable[Day]`  usually called as `Day.Pro.Mutable`
      - `Long.G.Collection[Time]` usually called as `Time.Collection`

*/