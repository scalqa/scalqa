package scalqa; package lang; package byte; package g; package companion; import language.implicitConversions

import anyref.g.{ companion as REF }
import g.{ companion as RAW }

transparent trait Containers[BASE_TYPE<:Raw]:
  type Stream       = g.Stream[BASE_TYPE];        def Stream     = RAW.Z.Stream    .cast[RAW.Stream[BASE_TYPE]]
  type Range        = g.Range[BASE_TYPE]
  type Opt          = G.Opt[BASE_TYPE];           def Opt        = RAW.Z.Opt       .cast[RAW.Opt[BASE_TYPE]]
  type Buffer       = G.Buffer[BASE_TYPE]
  type Collection   = G.Collection[BASE_TYPE];    val Collection = RAW.Z.Collection.cast[RAW.Collection[BASE_TYPE]]
  type Idx          = G.Idx[BASE_TYPE];           val Idx        = RAW.Z.Idx       .cast[RAW.Idx[BASE_TYPE]]
  type Pack         = G.Pack[BASE_TYPE];          def Pack       = RAW.Z.Pack      .cast[RAW.Pack[BASE_TYPE]]
  type Lookup[B]    = G.Lookup[BASE_TYPE,B];      val Lookup     = RAW.Z.Lookup    .cast[RAW.Lookup[BASE_TYPE]]
  type Pro          = G.Pro[BASE_TYPE];           val Pro        = RAW.Z.Pro       .cast[RAW.Pro[BASE_TYPE]]
  type Promise      = Val.Promise[BASE_TYPE];     def Promise    = REF.Z.Promise   .cast[REF.Promise[BASE_TYPE]]
  type Result       = Val.Result[BASE_TYPE];      def Result     = REF.Z.Result    .cast[REF.Result[BASE_TYPE]]
  /**/                                            val Fun        = RAW.Z.Fun       .cast[RAW.Fun[BASE_TYPE]]
  type Set          = G.Set[BASE_TYPE];           def Set        = RAW.Z.Set       .cast[RAW.Set[BASE_TYPE]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Byte Generic Type Assigened Containers

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