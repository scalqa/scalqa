package scalqa; package lang; package char; package g; package customized; import language.implicitConversions

import anyref.g.customized.{ companion as COMPANION }

transparent trait Containers[A<:Raw]:
  @tn("Stream") type ~            = g.Stream[A];        @tn("Stream") def ~          = companion.Stream    .cast[companion.Stream[A]]
  @tn("Range")  type <>           = g.Range[A]
  /**/          type Opt          = G.Opt[A];                         def Opt        = companion.Opt       .cast[companion.Opt[A]]
  /**/          type Buffer       = G.Buffer[A]
  /**/          type Collection   = G.Collection[A];                  val Collection = companion.Collection.cast[companion.Collection[A]]
  /**/          type Idx          = G.Idx[A];                         val Idx        = companion.Idx       .cast[companion.Idx[A]]
  @tn("Pack")   type ><           = G.><[A];            @tn("Pack")   def ><         = companion.Pack      .cast[companion.Pack[A]]
  /**/          type Lookup[B]    = G.Lookup[A,B];                    val Lookup     = companion.Lookup    .cast[companion.Lookup[A]]
  /**/          type Pro          = G.Pro[A];                         val Pro        = companion.Pro       .cast[companion.Pro[A]]
  /**/          type Promise      = Val.Promise[A];                   def Promise    = COMPANION.Promise   .cast[COMPANION.Promise[A]]
  /**/          type Result       = Val.Result[A];                    def Result     = COMPANION.Result    .cast[COMPANION.Result[A]]
  /**/          type Ordering     = G.Ordering[A];                    val Fun        = companion.Fun       .cast[companion.Fun[A]]
  /**/          type StableSet    = Val.Collection.StableSet[A];      def StableSet  = Val.Collection.StableSet

  inline def emptyArray: Array[A] = ZZ.emptyCharArray.cast[Array[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Char Generic Type Assigened Containers

     This trait customizes generic containers with given Raw type.

     Typed.Containers trait is already mixed with Opaque.Data, so the application code usually uses them indirectly when defining data elements.

@def emptyArray  -> Empty array \n\n Returns singleton scala.Array.emptyCharArray

@type Opt        ->  Specialized option \n\n Already parameterized generic option
@def  Opt        ->  Type companion \n\n Holds methods to construct type instances
@type Buffer     ->  Specialized buffer \n\n Already parameterized generic buffer
@type Collection ->  Specialized collection \n\n Already parameterized generic collection
@val  Collection ->  Type companion \n\n Holds methods to construct type instances
@type Idx        ->  Specialized indexed collection \n\n Already parameterized generic indexed collection
@val  Idx        ->  Type companion \n\n Holds methods to construct type instances
@type ><         ->  Specialized pack\n\n Already parameterized generic immutable collection
@def  ><         ->  Type companion \n\n Holds methods to construct type instances
@type Lookup     ->  Specialized lookup collection \n\n Already parameterized generic lookup collection
@val  Lookup     ->  Type companion \n\n Holds methods to construct type instances
@type Pro        ->  Specialized property \n\n Already parameterized generic property
@val  Pro        ->  Type companion \n\n Holds methods to construct type instances
@type Promise    ->  Parameterized Val.Promise \n\n Already parameterized generic Val.Promise
@def  Promise    ->  Type companion \n\n Holds methods to construct type instances
@type <>         ->  Specialized range \n\n Already parameterized generic range
@type Result     ->  Parameterized Val.Result \n\n Already parameterized generic Val.Result
@def  Result     ->  Type companion \n\n Holds methods to construct type instances
@type Ordering   ->  Parameterized J.Ordering   \n\n Already parameterized generic J.Ordering
@type ~          ->  Specialized stream \n\n Already parameterized generic stream
@def  ~          ->  Type companion \n\n Holds methods to construct type instances

@type StableSet  ->  Type alias \n\n Shortcut to [[scalqa.lang.Char$.Collection.StableSet Collection.StableSet]]
@def  StableSet  ->  Companion alias \n\n Holds methods to construct type instances
@val  Fun        ->  Specialized functions \n\n Already parameterized set of generic functions
*/