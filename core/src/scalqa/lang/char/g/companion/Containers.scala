package scalqa; package lang; package char; package g; package companion; import language.implicitConversions

import anyref.g.{ companion as REF }
import g.{ companion as RAW }

transparent trait Containers[A<:Raw]:
  type Stream       = g.Stream[A];        def Stream     = RAW.Z.Stream    .cast[RAW.Stream[A]]
  type Range        = g.Range[A]
  type Opt          = G.Opt[A];           def Opt        = RAW.Z.Opt       .cast[RAW.Opt[A]]
  type Buffer       = G.Buffer[A]
  type Collection   = G.Collection[A];    val Collection = RAW.Z.Collection.cast[RAW.Collection[A]]
  type Idx          = G.Idx[A];           val Idx        = RAW.Z.Idx       .cast[RAW.Idx[A]]
  type Pack         = G.Pack[A];          def Pack       = RAW.Z.Pack      .cast[RAW.Pack[A]]
  type Lookup[B]    = G.Lookup[A,B];      val Lookup     = RAW.Z.Lookup    .cast[RAW.Lookup[A]]
  type Pro          = G.Pro[A];           val Pro        = RAW.Z.Pro       .cast[RAW.Pro[A]]
  type Promise      = Val.Promise[A];     def Promise    = REF.Z.Promise   .cast[REF.Promise[A]]
  type Result       = Val.Result[A];      def Result     = REF.Z.Result    .cast[REF.Result[A]]
                                          val Fun        = RAW.Z.Fun       .cast[RAW.Fun[A]]
  type Set          = G.Set[A];           def Set        = RAW.Z.Set       .cast[RAW.Set[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Char Generic Type Assigened Containers

     This trait customizes generic containers with given Primitive type.

     Containers trait is already mixed with Opaque.Data, so the application code usually uses them indirectly when defining data elements.

@type Opt        ->  Specialized option \n\n Already parameterized generic option
@def  Opt        ->  Type companion \n\n Holds methods to construct type instances
@type Buffer     ->  Specialized buffer \n\n Already parameterized generic buffer
@type Collection ->  Specialized collection \n\n Already parameterized generic collection
@val  Collection ->  Type companion \n\n Holds methods to construct type instances
@type Idx        ->  Specialized indexed collection \n\n Already parameterized generic indexed collection
@val  Idx        ->  Type companion \n\n Holds methods to construct type instances
@type Pack       ->  Specialized pack\n\n Already parameterized generic immutable collection
@def  Pack       ->  Type companion \n\n Holds methods to construct type instances
@type Lookup     ->  Specialized lookup collection \n\n Already parameterized generic lookup collection
@val  Lookup     ->  Type companion \n\n Holds methods to construct type instances
@type Pro        ->  Specialized property \n\n Already parameterized generic property
@val  Pro        ->  Type companion \n\n Holds methods to construct type instances
@type Promise    ->  Parameterized Val.Promise \n\n Already parameterized generic Val.Promise
@def  Promise    ->  Type companion \n\n Holds methods to construct type instances
@type Range      ->  Specialized range \n\n Already parameterized generic range
@type Result     ->  Parameterized Val.Result \n\n Already parameterized generic Val.Result
@def  Result     ->  Type companion \n\n Holds methods to construct type instances
@type Set        ->  Type alias
@def  Set        ->  Companion alias \n\n Holds methods to construct type instances
@val  Fun        ->  Specialized functions \n\n Already parameterized set of generic functions
@type Stream     ->  Specialized stream \n\n Already parameterized generic stream
@def  Stream     ->  Type companion \n\n Holds methods to construct type instances
*/