package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import z._build.{ _map => M }

transparent trait _map:
  self: Stream.type =>

  extension[A](inline x: ~[A])
    /**/            inline def map     [T](inline f: A => T)              (using inline T:Specialized[T]): T.~  = M.map(x,f)
    /**/            inline def MAP     [T](inline f: A => T)              (using inline T:Specialized[T]): T.~  = M.map.APPLY(x,f)

    /**/            inline def flatMap [T](inline f: A => ~[T])           (using inline T:Specialized[T]): T.~  = M.flatMap(x,f)
    /**/            inline def FLAT_MAP[T](inline f: A => ~[T])           (using inline T:Specialized[T]): T.~  = M.flatMap.APPLY(x,f)

    /**/            inline def flatten [T]   (using inline f:A=>Able.~[T])(using inline T:Specialized[T]): T.~  = M.flatMap(x,f(_).~)
    /**/            inline def collect [T](inline f: PartialFunction[A,T])                               : ~[T] = new M.collect(x,f)

    @tn("map_Opt")  inline def map_?   [T,OPT<:Any.Opt[T]](inline f: A=>OPT)
                                          (using inline o:Specialized.Opt[T,OPT],inline T:Specialized[T]): T.~ = M.mapOpt(x,f)
    @tn("MAP_Opt")  inline def MAP_?   [T,OPT<:Any.Opt[T]](inline f: A=>OPT)
                                          (using inline o:Specialized.Opt[T,OPT],inline T:Specialized[T]): T.~ = M.mapOpt.APPLY(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _map -> ### Stream Element Mapping Interface

@def map -> Simple map

     Creates a new [[scalqa.val.Stream ~]] where each element is a result of applying given function to current [[scalqa.val.Stream ~]] elements

     ```
      (0 <>> 26).~.map(i => ('a' + i).toChar).TP

      // Output
      ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
     ```

@def MAP -> Heavy map

      [[MAP]] is functionally equivalent to [[map]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def map_? -> Optional map

     Creates a new [[scalqa.val.Stream ~]] where each element is a result of applying given function to [[scalqa.val.Stream ~]] elements.
     If the function returns void option, the element is dropped.

     ```
     (1 <> 10).~.map_?(i => if(i % 2 == 0) "Even_"+i else \/).TP

     // Output
     ~(Even_2, Even_4, Even_6, Even_8, Even_10)
     ```

     Pattern matching can be used, but the last void case must always be pivided explicitly:
     ```
     (0 <>> 26).~.map_?{
       case i if(i % 2 == 0) => ('a' + i).toChar
       case _                => \/
     }.TP

     // Output
     ~(a, c, e, g, i, k, m, o, q, s, u, w, y)
     ```

     Note:

     - All cases must return the same type, otherwise the operation will not compile.
     - [[map_?]] is functionally similar to [[collect]], but is faster (PartialFunction in [[collect]] has to be evaluated twice)

@def MAP_? -> Heavy optional map

      [[MAP_?]] is functionally equivalent to [[map_?]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def flatMap -> Flat map

      Creates a new [[scalqa.val.Stream ~]] by applying given function to all elements of current [[scalqa.val.Stream ~]] and concatenating the results


     ```
      (1 <> 3).~.flatMap(i => ~~(i, i*10, i*100)).TP

      // Output
      ~(1, 10, 100, 2, 20, 200, 3, 30, 300)
     ```

@def FLAT_MAP -> Heavy flat map

      [[FLAT_MAP]] is functionally equivalent to [[flatMap]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def flatten -> Converts a stream of streams into a flat stream

     ```
      val vs: ~[~[Char]] = ~~(
        'a' <> 'd',
        ><('x', 'y', 'z'),
        Vector('v', 'e', 'c', 't', 'o', 'r'))

      vs.flatten.TP // Prints ~(a, b, c, d, x, y, z, v, e, c, t, o, r)
     ```

@def collect -> Partial map

    Creates a new [[scalqa.val.Stream ~]] by applying a partial function to all elements of current [[scalqa.val.Stream ~]] on which the function is defined.

    ```
    (0 <>> 26).~.collect{
      case i if(i%2==0) => ('a' + i).toChar
    }.TP

    // Output
    ~(a, c, e, g, i, k, m, o, q, s, u, w, y)
    ```

    Note:

     - [[collect]] is functionally similar to [[map_?]], which is prefferable in most cases.
     - 'partialMap' would be a better name for this operation, but 'collect' is an established Scala convention.
*/
