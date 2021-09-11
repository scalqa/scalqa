package scalqa; package lang; package anyref; package containers; import language.implicitConversions

object Companion:
  @tn("Stream") type ~ [A]         = companion.Stream[A]
  @tn("Pack")   type ><[A]         = companion.Pack[A]
  @tn("Range")  type <>[A]         = companion.Range[A]
  /**/          type Opt[A]        = companion.Opt[A]
  /**/          type Buffer[A]     = companion.Buffer[A]
  /**/          type Collection[A] = companion.Collection[A]
  /**/          type Idx[A]        = companion.Idx[A]
  /**/          type Lookup[A]     = companion.Lookup[A]
  /**/          type Pro[A]        = companion.Pro[A]
  /**/          type Promise[A]    = companion.Promise[A]
  /**/          type Result[A]     = companion.Result[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Companion ->

    Companion object contains a set of classes, which provide companion object functionality for customized generic containers.

*/
