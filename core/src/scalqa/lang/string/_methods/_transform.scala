package scalqa; package lang; package string; package _methods; import language.implicitConversions

transparent trait _transform:

  extension(inline x: String)
    inline def charStream                                       : Char.Stream                       = Z.char_Stream( x)
    inline def splitStream(inline sep: Char, more: Char *)      : Stream[String]                    = Z.split_Stream(x,sep,more)
    inline def lineStream                                       : Stream[String]                    = Z.line_Stream( x)
    inline def indent(inline tag: String)                       : String                            = Z.indent(x, tag)
    inline def tokenizedStream(inline separators:Stream[String]): Stream[(String,Int.Range,String)] = z.tokenizedStream(x,separators)
    inline def toDoubleOpt                                      : Double.Opt                        = Z.toDoubleOpt(    x)
    inline def toDoubleResult                                   : Result[Double]                    = Z.toDoubleResult( x)
    inline def toIntOpt                                         : Int.Opt                           = Z.toIntOpt(       x)
    inline def toIntResult                                      : Result[Int]                       = Z.toIntResult(    x)
    inline def toLongOpt                                        : Long.Opt                          = Z.toLongOpt(      x)
    inline def toLongResult                                     : Result[Long]                      = Z.toLongResult(   x)
    inline def toBooleanOpt                                     : Boolean.Opt                       = Z.toBooleanOpt(   x)
    inline def toBooleanResult                                  : Result[Boolean]                   = Z.toBooleanResult(x)
    inline def Problem                                          : Result.Problem                    = Result.Problem(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def indent -> Indents text with the lines

     Indents text with the tag.

     Prefixes first line with the tag, other lines with tag equal space

     ```
        "abc\\nde\\nxyz".indent("Idxs: ").TP
        // Output
        Idxs: abc
              de
              xyz
     ```


@def lineStream -> Stream of lines

     Creates a [[Stream]] of Strings representing lines (delimited by '\n') of this text

     ```
     "abc\\n def\\n xyz".lineStream.TP // Prints Stream(abc,  def,  xyz)
     ```

@def tokenizedStream -> Stream of tokens

      Multi token tokenizetion

      Returns a Tuple including:

        - Separator preceding the token, empty for the first token
        - [[!.Range]] of the token in the text
        - String token

      ```
         val str: String = (1 <> 40).stream.makeString("")
         "Text to Tokenize:".TP.TP
         str.TP.TP
         ("Token", "Range", "String").TP
         str.tokenizedStream(Stream("000","111","222","333","444")).print

         // Output

         Text to Tokenize:

        12345678910111213141516171819202122232425262728293031323334353637383940

         (Token,Range,String)
         --- --------- -------------------
         ?   ?         ?
         --- --------- -------------------
              0 <>> 11 12345678910
         111 14 <>> 33 2131415161718192021
         222 36 <>> 55 3242526272829303132
         333 58 <>> 71 4353637383940
         --- --------- -------------------
      ```

      @param separators a [[Stream]] of text separators to consider



@def charStream -> Stream of Chars

      Returns String as a [[Stream]] of [Char]]
      ```
      "abcd".charStream.TP // Prints Stream(a, x, c, d)
      ```

@def toBooleanResult -> Boolean result conversion

       Converts String to Boolean result

       ```
         "true".toBooleanResult.TP

         "abc".toBooleanResult.TP

         // Output
         Result(true)
         Result(Problem(For input string: "abc"))
       ```

@def toBooleanOpt -> Boolean option conversion

       Converts String to Boolean option

       ```
         "true".toBooleanOpt.TP

         "abc".toBooleanOpt.TP

         // Output
         Boolean.Opt(true)
         Boolean.Opt(\/)
       ```


@def toDoubleResult -> Double result conversion

       Converts String to Double result

       ```
         "123.45".toDoubleResult.TP

         "abc".toDoubleResult.TP

         // Output
         Result(123.45)
         Result(Problem(For input string: "abc"))
       ```

@def toDoubleOpt -> Double option conversion

       Converts String to Double option

       ```
         "123.45".toDoubleOpt.TP

         "abc".toDoubleOpt.TP

         // Output
         Double.Opt(123.45)
         Double.Opt(\/)
       ```

@def toLongResult -> Long result conversion

       Converts String to Long result

       ```
         "123".toLongResult.TP

         "abc".toLongResult.TP

         // Output
         Result(123)
         Result(Problem(For input string: "abc"))
      ```

@def toLongOpt -> Long option conversion

       Converts String to Long option

       ```
         "123".toLongOpt.TP

         "abc".toLongOpt.TP

         // Output
         Long.Opt(123)
         Long.Opt(\/)
      ```

@def toIntResult -> Int result conversion

       Converts String to Int result

       ```
         "123".toIntResult.TP

         "abc".toIntResult.TP

         // Output
         Result(123)
         Result(Problem(For input string: "abc"))
       ```

@def toIntOpt -> Int opt conversion

       Converts String to Int option

       ```
         "123".toIntOpt.TP

         "abc".toIntOpt.TP

         // Output
         Int.Opt(123)
         Int.Opt(\/)
       ```

@def Problem -> To Problem

      Creates Result.Problem, where the base String becomes problem message

*/
