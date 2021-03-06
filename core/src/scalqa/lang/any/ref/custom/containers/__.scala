package scalqa; package lang; package any; package ref; package custom; import language.implicitConversions

import containers.{ companion as C }

transparent trait Containers[A]:
  @tn("Stream") type ~              = Val.~[A];                   @tn("Stream") val ~          = Val.~
  @tn("Range")  type <>             = Val.<>[A];                  @tn("Range")  val <>         = C.Range     .cast[C.Range[A]];
  @tn("Pack")   type ><             = Val.><[A];                  @tn("Pack")   val ><         = C.Pack      .cast[C.Pack[A]]
  /**/          type Buffer         = Any.Ref.Buffer[A]
  /**/          type Collection     = Val.Collection[A];                  final val Collection = C.Collection.cast[C.Collection[A]]
  /**/          type Idx            = Val.Idx[A];                         final val Idx        = C.Idx       .cast[C.Idx[A]]
  /**/          type Lookup[B]      = Val.Lookup[A,B];                    final val Lookup     = C.Lookup    .cast[C.Lookup[A]]
  /**/          type Opt            = Val.Opt.opaque.`type`[A];           final val Opt        = C.Opt       .cast[C.Opt[A]]
  /**/          type Result         = Val.Result.opaque.`type`[A];        final val Result     = C.Result    .cast[C.Result[A]]
  /**/          type Pro            = Val.Pro[A];                         final val Pro        = C.Pro       .cast[C.Pro[A]]
  /**/          type Promise        = Val.Promise[A];                     final val Promise    = C.Promise   .cast[C.Promise[A]]
  /**/          type StableSet      = Val.StableSet[A];                   final val StableSet  = Collection.StableSet

object Containers:
  inline def Companion[A] = containers.Companion

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Custom Containers Setup

     This trait customizes generic containers with given Ref type.

     Custom.Containers are already mixed with Custom.Data, so the application code usually uses them indirectly when defining data elements.

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