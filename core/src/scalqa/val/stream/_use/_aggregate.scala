package scalqa; package `val`; package stream; package _use; import language.implicitConversions

import z._use.{ _aggregate as Z }

transparent trait _aggregate:

  extension[A](inline x: Stream[A])
    /**/        inline def fold     (inline start:A)(inline f:(A,A)=>A) : A      = Z.fold.any(x,start,f)
    transparent inline def foldAs[B](inline start:B)(inline f:(B,A)=>B) : B      = Z.foldAs.any(x,start,f)
    /**/        inline def FOLD(inline start:A)(inline f:(A,A)=>A)      : A      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/        inline def FOLD_AS[B](inline start:B)(inline f:(B,A)=>B): B      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/        inline def reduceOpt(inline f: (A,A) => A)              : Opt[A] = Z.reduce.opt(x,f)
    /**/        inline def reduce(  inline f: (A,A) => A)               : A      = x.reduceOpt(f).get
    /**/        inline def REDUCE(  inline f: (A,A) => A)               : A      = x.REDUCE_OPT(f).get
    /**/        inline def REDUCE_OPT(inline f: (A,A) => A)             : Opt[A] = {val s=x; s.readOpt.map(v => s.FOLD(v)(f))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _aggregate -> ### Stream Aggregation Interface

@def reduce -> Reduce

     Folds elements with a binary function

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).stream.reduce(_ + _) // Returns 500500
     ```

     Note. Threre is no default value, and if stream is empty, operation fails. Use [[reduceOpt]] as safer option

     @param f binary function to fold elements with

@def REDUCE -> Heavy reduce

    Folds elements with a binary function

    [[REDUCE]] is functionally equivalent to [[reduce]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def reduceOpt -> Optional reduce

     Folds elements with a binary function or returns empty option when stream is empty

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).stream.reduceOpt(_ + _) // Returns Opt(500500)
     ```

    @param f binary function to fold elements with


@def REDUCE_OPT -> Heavy optional reduce

    Folds elements with a binary function

    [[REDUCE_OPT]] is functionally equivalent to [[reduceOpt]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def foldAs -> Fold and convert

     Folds and converts elements with a binary function

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).stream.foldAs(0L)(_ + _) // Returns 500500
     ```

    @param start seed value to start with
    @param f binary function to fold elements with

    Note. When folding AnyRef stream as a primitive value, there will be value boxing. Use FOLD_AS instead, which will be perfectly specialized.

@def FOLD_AS -> Heavy Fold and convert

    Folds and converts elements with a binary function

    [[FOLD_AS]] is functionally equivalent to [[foldAs]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def fold -> Fold

     Folds elements with a binary function

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).stream.fold(0)(_ + _) // Returns 500500
     ```

    @param start seed value to start with
    @param f binary function to fold elements with

@def FOLD -> Heavy Fold

    Folds elements with a binary function

    [[FOLD]] is functionally equivalent to [[fold]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

*/
