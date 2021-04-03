package scalqa; package `def`; package boolean; import language.implicitConversions

object G:
  @tn("Stream") type ~         [A<:RAW]      = g.Stream[A];             @tn("Stream") inline def ~          = g.Stream
  @tn("Pack")   type ><        [A<:RAW]      = g.Pack[A];               @tn("Pack")   inline def ><         = g.Pack
  /**/          type Opt       [A<:RAW]      = g.Opt.opaque.`type`[A];                inline def Opt        = g.Opt
  /**/          type Buffer    [A<:RAW]      = g.Buffer[A];                           inline def Buffer     = g.Buffer
  /**/          type Collection[A<:RAW]      = g.Collection[A];                       inline def Collection = g.Collection
  /**/          type Idx       [A<:RAW]      = g.Idx[A];                              inline def Idx        = g.Idx
  /**/          type Pro       [A<:RAW]      = g.Pro[A];                              inline def Pro        = g.Pro
  /**/                                                                                inline def Fun        = g.Fun

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object G -> ### Raw Boolean Generic Specialized Containers

   The generic containers are never used directly, but rather as customized shortcuts for specific types.

   For example:

      - `Boolean.G.><[Boolean]`   usually called as `Boolean.><`
      - `Double.G.Idx[Percent]`   usually called as `Percent.Idx`
      - `Int.G.Pro.Mutable[Day]`  usually called as `Day.Pro.Mutable`
      - `Long.G.Collection[Time]` usually called as `Time.Collection`
*/