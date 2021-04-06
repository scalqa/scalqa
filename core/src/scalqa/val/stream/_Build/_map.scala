package scalqa; package `val`; package stream; package _Build; import language.implicitConversions

import z.build.{ map => M }
import Shape.OfStream.Any
import Shape.OfOpt.{Any as AnyOpt}

transparent trait _map:
  self: Stream.type =>

  extension[A,T,STM<:Any[T]](inline x: ~[A])
    /**/            inline def map     [B>:T](inline f: A => B)                 (using inline s:Any.Def[B,STM]): STM  = M.map(x,f,s)
    /**/            inline def MAP     [B>:T](inline f: A => B)                 (using inline s:Any.Def[B,STM]): STM  = M.map.APPLY(x,f,s)
    /**/            inline def flatMap [B>:T](inline f: A => ~[B])              (using inline s:Any.Def[B,STM]): STM  = M.flatMap(x,f,s)
    /**/            inline def FLAT_MAP[B>:T](inline f: A => ~[B])              (using inline s:Any.Def[B,STM]): STM  = M.flatMap.APPLY(x,f,s)
    /**/            inline def flatten                   (using inline f:A=>Able.~[T], inline s:Any.Def[T,STM]): STM  = M.flatMap(x,f(_).~,s)
    @tn("map_Opt")  inline def map_?   [OPT<:AnyOpt[T]](inline f:A=>OPT) (using inline s:Any.OptDef[T,OPT,STM]): STM  = M.mapOpt(x,f,s)
    @tn("MAP_Opt")  inline def MAP_?   [OPT<:AnyOpt[T]](inline f:A=>OPT) (using inline s:Any.OptDef[T,OPT,STM]): STM  = M.mapOpt.APPLY(x,f,s)

  extension[A](inline x: ~[A])
    /**/            inline def collect[B](inline f: PartialFunction[A,B])                                      : ~[B] = new M.collect(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _map -> ### Element Mapping Interface

@def map -> Simple map

     Creates a new [[scalqa.val.Stream Stream]] where each element is a result of applying given function to current [[scalqa.val.Stream Stream]] elements

     ```
      (0 <>> 26).~.map(i => ('a' + i).Char).TP

      // Output
      ~(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
     ```

@def MAP -> Heavy map

      [[MAP]] is functionally equivalent to [[map]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def map_? -> Optional map

     Creates a new [[scalqa.val.Stream Stream]] where each element is a result of applying given function to [[scalqa.val.Stream Stream]] elements.
     If the function returns void option, the element is dropped.

     ```
     (1 <> 10).~.map_?(i => if(i>5) "Str_"+i else \/).TP

     // Output
     ~(Str_6, Str_7, Str_8, Str_9, Str_10)
     ```

     Pattern matching can be used, but the last void case must always be present:
     ```
     (0 <>> 26).~.map_?{
       case i if(i%2==0) => ('a' + i).Char
       case _            => \/
     }.TP

     // Output
     ~(a, c, e, g, i, k, m, o, q, s, u, w, y)
     ```

     Note:

     - [[map_?]] is functionally similar to [[collect]], but is faster (PartialFunction has to be evaluated twice)
     - [[map_?]] can return specialized stream result, but boxing might happen during mapping
     - [[mapRaw_?]] is trully unboxed for raw types

@def MAP_? -> Heavy optional map

      [[MAP_?]] is functionally equivalent to [[map_?]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def flatMap -> Flat map

      Creates a new [[scalqa.val.Stream Stream]] by applying given function to all elements of current [[scalqa.val.Stream Stream]] and concatenating the results


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
        Pack('x', 'y', 'z'),
        Vector('v', 'e', 'c', 't', 'o', 'r'))

      vs.flatten.TP // Prints ~(a, b, c, d, x, y, z, v, e, c, t, o, r)
     ```

@def collect -> Partial map

    Creates a new [[scalqa.val.Stream Stream]] by applying a partial function to all elements of current [[scalqa.val.Stream Stream]] on which the function is defined.

    ```
    (0 <>> 26).~.collect{
      case i if(i%2==0) => ('a' + i).Char
    }.TP

    // Output
    ~(a, c, e, g, i, k, m, o, q, s, u, w, y)
    ```

    Note:

     - [[collect]] is functionally similar to [[map_?]], which is prefferable in most cases.
     - 'partialMap' would be a better name for this operation, but 'collect' is an established Scala convention.
*/
