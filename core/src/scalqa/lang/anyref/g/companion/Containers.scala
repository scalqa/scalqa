package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

import anyref.g.{ companion as GC }

transparent trait Containers[BASE_TYPE]:
  type Stream         = Val.Stream[BASE_TYPE];              def Stream     = GC.Z.Stream    .cast[GC.Stream[BASE_TYPE]];
  type Range          = Val.Range[BASE_TYPE];               def Range      = GC.Z.Range     .cast[GC.Range[BASE_TYPE]];
  type Pack           = Val.Pack[BASE_TYPE];                def Pack       = GC.Z.Pack      .cast[GC.Pack[BASE_TYPE]]
  type Buffer         = AnyRef.G.Buffer[BASE_TYPE]
  type Collection     = Val.Collection[BASE_TYPE];          val Collection = GC.Z.Collection.cast[GC.Collection[BASE_TYPE]]
  type Idx            = Val.Idx[BASE_TYPE];                 val Idx        = GC.Z.Idx       .cast[GC.Idx[BASE_TYPE]]
  type Lookup[B]      = Val.Lookup[BASE_TYPE,B];            val Lookup     = GC.Z.Lookup    .cast[GC.Lookup[BASE_TYPE]]
  type Opt            = Val.Opt.TYPE.DEF[BASE_TYPE];        def Opt        = GC.Z.Opt       .cast[GC.Opt[BASE_TYPE]]
  type Result         = Val.Result.TYPE.DEF[BASE_TYPE];     def Result     = GC.Z.Result    .cast[GC.Result[BASE_TYPE]]
  type Pro            = Val.Pro[BASE_TYPE];                 val Pro        = GC.Z.Pro       .cast[GC.Pro[BASE_TYPE]]
  type Promise        = Val.Promise[BASE_TYPE];             def Promise    = GC.Z.Promise   .cast[GC.Promise[BASE_TYPE]]
  type Set            = Val.Set[BASE_TYPE];                 def Set        = GC.Z.Set       .cast[GC.Set[BASE_TYPE]]

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
      val s: Stream[String]=VOID
      // is equivalent to
      val s: String.stream =VOID

      val o: Opt[String]=VOID
      // is equivalent to
      val o: String.Opt =VOID
    ```
*/