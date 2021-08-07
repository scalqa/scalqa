package scalqa; package lang; package double; package g; package customized; import language.implicitConversions

object Companion:
  @tn("Stream") type ~         [A<:Raw] = companion.Stream[A]
  @tn("Pack")   type ><        [A<:Raw] = companion.Pack[A]
  /**/          type Opt       [A<:Raw] = companion.Opt[A]
  /**/          type Collection[A<:Raw] = companion.Collection[A]
  /**/          type Idx       [A<:Raw] = companion.Idx[A]
  /**/          type Pro       [A<:Raw] = companion.Pro[A]
  /**/          type Fun       [A<:Raw] = companion.Fun[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Companion ->


*/