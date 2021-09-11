package scalqa; package lang; package anyref; import language.implicitConversions

import anyref.containers.{ companion as GC }

transparent trait Containers[A]:
  @tn("Stream") type ~              = Val.~[A];                   @tn("Stream") def ~          = GC.Stream    .cast[GC.Stream[A]];
  @tn("Range")  type <>             = Val.<>[A];                  @tn("Range")  def <>         = GC.Range     .cast[GC.Range[A]];
  @tn("Pack")   type ><             = Val.><[A];                  @tn("Pack")   def ><         = GC.Pack      .cast[GC.Pack[A]]
  /**/          type Buffer         = AnyRef.Buffer[A]
  /**/          type Collection     = Val.Collection[A];                        val Collection = GC.Collection.cast[GC.Collection[A]]
  /**/          type Idx            = Val.Idx[A];                               val Idx        = GC.Idx       .cast[GC.Idx[A]]
  /**/          type Lookup[B]      = Val.Lookup[A,B];                          val Lookup     = GC.Lookup    .cast[GC.Lookup[A]]
  /**/          type Opt            = Val.Opt.TYPE.DEF[A];                      def Opt        = GC.Opt       .cast[GC.Opt[A]]
  /**/          type Result         = Val.Result.TYPE.DEF[A];                   def Result     = GC.Result    .cast[GC.Result[A]]
  /**/          type Pro            = Val.Pro[A];                               val Pro        = GC.Pro       .cast[GC.Pro[A]]
  /**/          type Promise        = Val.Promise[A];                           def Promise    = GC.Promise   .cast[GC.Promise[A]]
  /**/          type StableSet      = Val.StableSet[A];                         def StableSet  = GC.Collection.StableSet

object Containers:

  transparent inline def Companion = containers.Companion

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

     There is no performance difference when using customized vs. generic containers, just better readability.  For example:

    ```
      val s: ~[String] = \/
      // is equivalent to
      val s: String.~  = \/

      val o: Opt[String] = \/
      // is equivalent to
      val o: String.Opt  = \/
    ```
*/