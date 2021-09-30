package scalqa; package lang; package long; import language.implicitConversions

object G:
  @tn("Stream") transparent inline def ~          = g.Stream;       @tn("Stream")  type ~         [A<:Raw]      = g.Stream[A]
  @tn("Range")  transparent inline def <>         = g.Range;        @tn("Range")   type <>        [A<:Raw]      = g.Range[A]
  @tn("Pack")   transparent inline def ><         = g.Pack;         @tn("Pack")    type ><        [A<:Raw]      = g.Pack[A]
  /**/          transparent inline def Opt        = g.Opt;                         type Opt       [A<:Raw]      = g.Opt.TYPE.DEF[A]
  /**/          transparent inline def Buffer     = g.Buffer;                      type Buffer    [A<:Raw]      = g.Buffer[A]
  /**/          transparent inline def Collection = g.Collection;                  type Collection[A<:Raw]      = g.Collection[A]
  /**/          transparent inline def Idx        = g.Idx;                         type Idx       [A<:Raw]      = g.Idx[A]
  /**/          transparent inline def Lookup     = g.Lookup;                      type Lookup    [A<:Raw,B]    = g.Lookup[A,B]
  /**/          transparent inline def Set        = g.Set;                         type Set       [A<:Raw]      = g.Set[A]
  /**/          transparent inline def Pro        = g.Pro;                         type Pro       [A<:Raw]      = g.Pro[A]
  /**/          transparent inline def Fun        = g.Fun
  /**/          transparent inline def Companion  = g.Companion

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object G -> ### Long Generic Specialized Containers

   The generic containers are never used directly, but rather as customized shortcuts for specific types.

   For example:

      - `Long.G.><[Long]`         usually called as `Long.><`
      - `Double.G.Idx[Percent]`   usually called as `Percent.Idx`
      - `Int.G.Pro.Mutable[Day]`  usually called as `Day.Pro.Mutable`
      - `Long.G.Collection[Time]` usually called as `Time.Collection`

*/