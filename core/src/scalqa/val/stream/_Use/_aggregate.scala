package scalqa; package `val`; package stream; package _Use; import language.implicitConversions

transparent trait _aggregate:

  extension[A](x: ~[A])
    /**/                     def fold(  start: A)(f: (A,A) => A)              : A      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/              inline def FOLD(inline start:A)(inline f:(A,A)=>A)      : A      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/                     def foldAs[B](start: B)(f: (B,A) => B)           : B      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/              inline def FOLD_AS[B](inline start:B)(inline f:(B,A)=>B): B      = { var rv = start; x.FOREACH(fv => rv = f(rv,fv)); rv}
    /**/                     def reduce(  f: (A,A) => A)                      : A      = x.REDUCE_?(f).get
    /**/              inline def REDUCE(  inline f: (A,A) => A)               : A      = x.REDUCE_?(f).get
    @tn("reduce_Opt")        def reduce_?(f: (A,A) => A)                      : Opt[A] = x.REDUCE(f)
    @tn("REDUCE_Opt") inline def REDUCE_?(inline f: (A,A) => A)               : Opt[A] = x.read_?.map(v => x.FOLD(v)(f))

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

         (1 <> 1000).~.reduce(_ + _) // Returns 500500
     ```

     Note. Threre is no default value, and if stream is empty, operation fails. Use [[reduce_?]] as safer option

     @param f binary function to fold elements with

@def REDUCE -> Heavy reduce

    Folds elements with a binary function

    [[REDUCE]] is functionally equivalent to [[reduce]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def reduce_? -> Optional reduce

     Folds elements with a binary function or returns empty option when stream is empty

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).~.reduce_?(_ + _) // Returns Opt(500500)
     ```

    @param f binary function to fold elements with


@def REDUCE_? -> Heavy optional reduce

    Folds elements with a binary function

    [[REDUCE_?]] is functionally equivalent to [[reduce_?]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def foldAs -> Fold and convert

     Folds and converts elements with a binary function

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).~.foldAs(0L)(_ + _) // Returns 500500
     ```

    @param start seed value to start with
    @param f binary function to fold elements with

@def FOLD_AS -> Heavy Fold and convert

    Folds and converts elements with a binary function

    [[FOLD_AS]] is functionally equivalent to [[foldAs]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def fold -> Fold

     Folds elements with a binary function

     ```
         // Calculate sum of first 1000 Ints

         (1 <> 1000).~.fold(0)(_ + _) // Returns 500500
     ```

    @param start seed value to start with
    @param f binary function to fold elements with

@def FOLD -> Heavy Fold

    Folds elements with a binary function

    [[FOLD]] is functionally equivalent to [[fold]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

*/
