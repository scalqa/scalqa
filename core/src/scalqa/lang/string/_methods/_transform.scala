package scalqa; package lang; package string; package _methods; import language.implicitConversions

transparent trait _transform:

  extension(inline x: String)
    @tn("char_Stream")      inline def char_~                                   : Char.~                    = Z.char_Stream( x)
    @tn("split_Stream")     inline def split_~(inline sep: Char, more: Char *)  : ~[String]                 = Z.split_Stream(x,sep,more)
    @tn("line_Stream")      inline def line_~                                   : ~[String]                 = Z.line_Stream( x)
    /**/                    inline def indent(inline tag: String)               : String                    = Z.indent(x, tag)
    @tn("tokenized_Stream") inline def tokenized_~(inline separators: ~[String]): ~[(String,Int.<>,String)] = z.tokenizedStream(x,separators)
    @tn("toDouble_Opt")     inline def toDouble_?                               : Double.Opt                = Z.toDouble_Opt(    x)
    @tn("toDouble_Result")  inline def toDouble_??                              : Result[Double]            = Z.toDouble_Result( x)
    @tn("toInt_Opt")        inline def toInt_?                                  : Int.Opt                   = Z.toInt_Opt(       x)
    @tn("toInt_Result")     inline def toInt_??                                 : Result[Int]               = Z.toInt_Result(    x)
    @tn("toLong_Opt")       inline def toLong_?                                 : Long.Opt                  = Z.toLong_Opt(      x)
    @tn("toLong_Result")    inline def toLong_??                                : Result[Long]              = Z.toLong_Result(   x)
    @tn("toBoolean_Opt")    inline def toBoolean_?                              : Boolean.Opt               = Z.toBoolean_Opt(   x)
    @tn("toBoolean_Result") inline def toBoolean_??                             : Result[Boolean]           = Z.toBoolean_Result(x)
    /**/                    inline def Problem                                  : Result.Problem            = Result.Problem(x)

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


@def line_~ -> Stream of lines

     Creates a [[Stream]] of Strings representing lines (delimited by '\n') of this text

     ```
     "abc\\n def\\n xyz".line_~.TP // Prints ~(abc,  def,  xyz)
     ```

@def tokenized_~ -> Stream of tokens

      Multi token tokenizetion

      Returns a Tuple including:

        - Separator preceding the token, empty for the first token
        - [[!.Range]] of the token in the text
        - String token

      ```
         val str: String = (1 <> 40).~.makeString("")
         "Text to Tokenize:".TP.TP
         str.TP.TP
         ("Token", "Range", "String").TP
         str.tokenized_~(~~("000","111","222","333","444")).print

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



@def char_~ -> Stream of Chars

      Returns String as a [[Stream]] of [Char]]
      ```
      "abcd".char_~.TP // Prints ~(a, x, c, d)
      ```

@def toBoolean_?? -> Boolean result conversion

       Converts String to Boolean result

       ```
         "true".toBoolean_??.TP

         "abc".toBoolean_??.TP

         // Output
         Result(true)
         Result(Problem(For input string: "abc"))
       ```

@def toBoolean_? -> Boolean option conversion

       Converts String to Boolean option

       ```
         "true".toBoolean_?.TP

         "abc".toBoolean_?.TP

         // Output
         Boolean.Opt(true)
         Boolean.Opt(\/)
       ```


@def toDouble_?? -> Double result conversion

       Converts String to Double result

       ```
         "123.45".toDouble_??.TP

         "abc".toDouble_??.TP

         // Output
         Result(123.45)
         Result(Problem(For input string: "abc"))
       ```

@def toDouble_? -> Double option conversion

       Converts String to Double option

       ```
         "123.45".toDouble_?.TP

         "abc".toDouble_?.TP

         // Output
         Double.Opt(123.45)
         Double.Opt(\/)
       ```

@def toLong_?? -> Long result conversion

       Converts String to Long result

       ```
         "123".toLong_??.TP

         "abc".toLong_??.TP

         // Output
         Result(123)
         Result(Problem(For input string: "abc"))
      ```

@def toLong_? -> Long option conversion

       Converts String to Long option

       ```
         "123".toLong_?.TP

         "abc".toLong_?.TP

         // Output
         Long.Opt(123)
         Long.Opt(\/)
      ```

@def toInt_?? -> Int result conversion

       Converts String to Int result

       ```
         "123".toInt_??.TP

         "abc".toInt_??.TP

         // Output
         Result(123)
         Result(Problem(For input string: "abc"))
       ```

@def toInt_? -> Int opt conversion

       Converts String to Int option

       ```
         "123".toInt_?.TP

         "abc".toInt_?.TP

         // Output
         Int.Opt(123)
         Int.Opt(\/)
       ```

@def Problem -> To Problem

      Creates Result.Problem, where the base String becomes problem message

*/
