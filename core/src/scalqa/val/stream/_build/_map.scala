package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import z._build.{ _map => Z }

transparent trait _map:
  self: Stream.type =>

  extension[A](inline x: ~[A])
    /**/            inline def map     [B](inline f: A => B)              (using inline B:Specialized[B]): B.~     = Z.map(x,f)
    /**/            inline def MAP     [B](inline f: A => B)              (using inline B:Specialized[B]): B.~     = Z.map.APPLY(x,f)

    /**/            inline def mapIf(inline condition:A=>Boolean,inline fun:A=>A)                        : ~[A]    = x.map[A](v => if(condition(v)) fun(v) else v)

    /**/            inline def flatMap [B](inline f: A => ~[B])           (using inline B:Specialized[B]): B.~     = Z.flatMap(x,f)
    /**/            inline def FLAT_MAP[B](inline f: A => ~[B])           (using inline B:Specialized[B]): B.~     = Z.flatMap.APPLY(x,f)

    @tn("map_Opt")  inline def map_?   [B,OPT<:Any.Opt[B]](inline f: A=>OPT)
                                          (using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.~    = Z.mapOpt(x,f)
    @tn("MAP_Opt")  inline def MAP_?   [B,OPT<:Any.Opt[B]](inline f: A=>OPT)
                                          (using inline o:Specialized.Opt[B,OPT],inline B:Specialized[B]): B.~    = Z.mapOpt.APPLY(x,f)

    /**/            inline def collect[B](inline f: PartialFunction[A,B])                                : ~[B]   = new Z.collect(x,f)

    /**/            inline def flatten [B]             (using d: Any.Def.ToStream[A,B], B:Specialized[B]): B.~    = x.flatMap(d.value_toStream)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _map -> ### Stream Element Mapping Interface

@def mapIf -> Conditional map

     This is a synthetic oeration which is inlined as:

    ```
    map(v => if(condition(v)) fun(v) else v)
    ```

    In some cicumstances using "mapIf" does not make sense, in some it is really usefull.

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

     Pattern matching can be used, but the last void case must always be provided explicitly:
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

     The operation will only compile if stream elements are streams or stream convertible entities, like [[scalqa.gen.able.Stream Able.~]], Iterable, Iterator, etc.

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
