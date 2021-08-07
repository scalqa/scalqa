package scalqa; package lang; package anyref; package g; package customized; import language.implicitConversions

transparent trait Containers[A]:
  @tn("Stream") type ~              = Val.~[A];                   @tn("Stream") def ~          = companion.Stream    .cast[companion.Stream[A]];
  @tn("Range")  type <>             = Val.<>[A];                  @tn("Range")  def <>         = companion.Range     .cast[companion.Range[A]];
  @tn("Pack")   type ><             = Val.><[A];                  @tn("Pack")   def ><         = companion.Pack      .cast[companion.Pack[A]]
  /**/          type Buffer         = AnyRef.G.Buffer[A]
  /**/          type Collection     = Val.Collection[A];                        val Collection = companion.Collection.cast[companion.Collection[A]]
  /**/          type Idx            = Val.Idx[A];                               val Idx        = companion.Idx       .cast[companion.Idx[A]]
  /**/          type Lookup[B]      = Val.Lookup[A,B];                          val Lookup     = companion.Lookup    .cast[companion.Lookup[A]]
  /**/          type Opt            = Val.Opt.OPAQUE.TYPE[A];                   def Opt        = companion.Opt       .cast[companion.Opt[A]]
  /**/          type Result         = Val.Result.OPAQUE.TYPE[A];                def Result     = companion.Result    .cast[companion.Result[A]]
  /**/          type Pro            = Val.Pro[A];                               val Pro        = companion.Pro       .cast[companion.Pro[A]]
  /**/          type Promise        = Val.Promise[A];                           def Promise    = companion.Promise   .cast[companion.Promise[A]]
  /**/          type StableSet      = Val.StableSet[A];                         def StableSet  = companion.Collection.StableSet

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Type Assigned Containers Setup

     This trait customizes generic containers with given AnyRef type.

     Customized.Containers are already mixed with Opaque.Data, so the application code usually uses them indirectly when defining data elements.

     Generally there is no performance difference when using customized vs. generic containers, just better readability.  For example:

    ```
      val s: ~[String] = \/
      // is equivalent to
      val s: String.~  = \/

      val o: Opt[String] = \/
      // is equivalent to
      val o: String.Opt  = \/
    ```
*/