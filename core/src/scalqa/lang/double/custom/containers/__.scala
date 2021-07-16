package scalqa; package lang; package double; package custom; import language.implicitConversions

import containers.{ companion as C }
import any.ref.custom.containers.{ companion as REF }

transparent trait Containers[A<:RAW]:
  @tn("Stream") type ~            = g.Stream[A];        @tn("Stream") inline def ~          = C.Stream    .cast[C.Stream[A]]
  @tn("Range")  type <>           = g.Range[A]
  /**/          type Opt          = G.Opt[A];                         final  val Opt        = C.Opt       .cast[C.Opt[A]]
  /**/          type Buffer       = G.Buffer[A]
  /**/          type Collection   = G.Collection[A];                  final  val Collection = C.Collection.cast[C.Collection[A]]
  /**/          type Idx          = G.Idx[A];                         final  val Idx        = C.Idx       .cast[C.Idx[A]]
  @tn("Pack")   type ><           = G.><[A];            @tn("Pack")   inline def ><         = C.Pack      .cast[C.Pack[A]]
  /**/          type Lookup[B]    = Val.Lookup[A,B];                  final  val Lookup     = REF.Lookup  .cast[REF.Lookup[A]]
  /**/          type Pro          = G.Pro[A];                         final  val Pro        = C.Pro       .cast[C.Pro[A]]
  /**/          type Promise      = Val.Promise[A];                   inline def Promise    = REF.Promise .cast[REF.Promise[A]]
  /**/          type Result       = Val.Result[A];                    inline def Result     = REF.Result  .cast[REF.Result[A]]
  /**/          type Ordering     = G.Ordering[A];                    final  val Fun        = C.Fun       .cast[C.Fun[A]]
  /**/          type StableSet    = Val.Collection.StableSet[A];      inline def StableSet  = Val.Collection.StableSet

  inline def emptyArray: Array[A] = ZZ.emptyDoubleArray.cast[Array[A]]

object Containers:
  inline def Companion = containers.Companion

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Containers -> ### Double Custom Containers Setup

     This trait customizes generic containers with given Raw type.

     Custom.Containers are already mixed with Custom.Data, so the application code usually uses them indirectly when defining data elements.

@def emptyArray  -> Empty array \n\n Returns singleton scala.Array.emptyDoubleArray

@type Opt        ->  Specialized option \n\n Already parameterized generic option
@val  Opt        ->  Type companion \n\n Holds methods to construct type instances
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

@type StableSet  ->  Type alias \n\n Shortcut to [[scalqa.lang.Double$.Collection.StableSet Collection.StableSet]]
@def  StableSet  ->  Companion alias \n\n Holds methods to construct type instances
@val  Fun        ->  Specialized functions \n\n Already parameterized set of generic functions
*/