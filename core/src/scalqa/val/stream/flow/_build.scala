package scalqa; package `val`; package stream; package flow; import language.implicitConversions

transparent trait _build[A]:
  self: Flow[A] =>

  @tn("stream")       def ~                                          : ~[A]

  /**/                def takeType[B:ClassTag]                       : Flow[B]
  @tn("map_Opt")      def map_?[B](f: A => Opt[B])                   : Flow[B]
  /**/                def collect[B](f: PartialFunction[A,B])        : Flow[B]
  /**/                def take  (f: A => Boolean)                    : Flow[A]
  /**/                def drop  (f: A => Boolean)                    : Flow[A]
  /**/                def map[B](f: A => B)                          : Flow[B]
  /**/                def flatMap[B](f: A => ~[B])                   : Flow[B]
  /**/                def peek(c: A => Unit)                         : Flow[A]
  /**/                def peekIndexed[U](c: (Int,A)=>U, start:Int=0) : Flow[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _build -> ### Build Interface

@def ~ -> Convert to stream

    Wraps [[scalqa.val.stream.Flow Stream.Flow]] into regular [[scalqa.val.Stream Stream]].

    If [[scalqa.val.stream.Flow Stream.Flow]] is parallel, then this convertion can be very costly,
    and it is always prefferable to consume [[scalqa.val.stream.Flow Stream.Flow]] without going back to [[scalqa.val.Stream Stream]]

@def take -> Filter

    Only allow [[scalqa.val.stream.Flow Stream.Flow]] elements satisfying the given function

@def takeType -> Type filter

      Only lets elements of specified type

@def drop -> Reverse filter

    Disallows [[scalqa.val.stream.Flow Stream.Flow]] elements satisfying the given function


@def map -> Simple map

      Creates a new [[scalqa.val.stream.Flow Stream.Flow]] where each element is a result of applying given function to current [[scalqa.val.stream.Flow Stream.Flow]] elements

@def map_? -> Optional map

      Creates a new [[scalqa.val.stream.Flow Stream.Flow]] where each element is a result of applying given function to current [[scalqa.val.stream.Flow Stream.Flow]] elements

      It the function returns void option, the elements are dropped

@def flatMap -> Flat map

      Creates a new [[scalqa.val.stream.Flow Stream.Flow]] by applying given function to all elements of current [[scalqa.val.stream.Flow Stream.Flow]] and concatenating the results

@def collect -> Partial map

    Creates a new [[scalqa.val.stream.Flow Stream.Flow]] by applying a partial function to all elements of current [[scalqa.val.stream.Flow Stream.Flow]] on which the function is defined.

@def peek -> Inspect

      The given function will be run for every passing stream flow element.

@def peekIndexed -> Indexed peek

     The given function will be executed for every passing element and its index.

*/