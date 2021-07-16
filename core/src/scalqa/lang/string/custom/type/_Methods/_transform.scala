package scalqa; package lang; package string; package custom; package `type`; package `_Methods`; import language.implicitConversions

transparent trait _transform[A <: String | Opaque.String]:

  extension(inline x: A)
    @tn("char_Stream")      inline def char_~                                : Char.~          = Z.char_Stream( x.cast[String])
    @tn("split_Stream")     inline def split_~(inline separator: Char)       : ~[A]            = Z.split_Stream(x.cast[String],separator).cast[~[A]]
    @tn("split_Stream")     inline def split_~(inline separators:Array[Char]): ~[A]            = Z.split_Stream(x.cast[String],separators).cast[~[A]]
    @tn("line_Stream")      inline def line_~                                : ~[A]            = Z.line_Stream( x.cast[String]).cast[~[A]]
    /**/                    inline def indent(inline tag: A|String)          : A               = Z.indent(x.cast[String], tag.cast[String]).cast[A]
    @tn("tokenized_Stream") inline def tokenized_~(inline separators: ~[A])  : ~[(A,Int.<>,A)] = z.tokenizedStream(x, separators.cast[~[String]]).cast[~[(A,Int.<>,A)]]
    @tn("toDouble_Opt")     inline def toDouble_?                            : Double.Opt      = Z.toDouble_Opt(    x.cast[String])
    @tn("toDouble_Result")  inline def toDouble_??                           : Result[Double]  = Z.toDouble_Result( x.cast[String])
    @tn("toInt_Opt")        inline def toInt_?                               : Int.Opt         = Z.toInt_Opt(       x.cast[String])
    @tn("toInt_Result")     inline def toInt_??                              : Result[Int]     = Z.toInt_Result(    x.cast[String])
    @tn("toLong_Opt")       inline def toLong_?                              : Long.Opt        = Z.toLong_Opt(      x.cast[String])
    @tn("toLong_Result")    inline def toLong_??                             : Result[Long]    = Z.toLong_Result(   x.cast[String])
    @tn("toBoolean_Opt")    inline def toBoolean_?                           : Boolean.Opt     = Z.toBoolean_Opt(   x.cast[String])
    @tn("toBoolean_Result") inline def toBoolean_??                          : Result[Boolean] = Z.toBoolean_Result(x.cast[String])
    @tn("nonEmpty_Opt")     inline def nonEmpty_?                            : Opt[A]          = Z.nonEmpty_Opt(    x.cast[String]).cast[Opt[A]]

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


@def line_~ -> Source of lines

     Creates a [[Source]] of Strings representing lines (delimited by '\n') of this text

     ```  "abc\\n def\\n xyz".line_~.TP // Prints ~(abc,  def,  xyz) ```



@def tokenized_~ -> Source of tokens

      Multi token tokenizetion

      Returns a Tuple including:

        - Separator preceding the token, empty for the first token
        - [[!.Range]] of the token in the text
        - String token

      ```
         val str: String = (1 <> 40).~.makeString()
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

      @param separators a [[Source]] of text separators to consider



@def char_~ -> Source of Chars

      Returns String as a [[Source]] of [Char]]
      ``` "abcd".char_~ TP // Prints ~(a, x, c, d) ```



@def toBoolean_?? -> Boolean result conversion

       Converts String to Boolean result

       ```
         "true".toBoolean_?? TP

         "abc".toBoolean_?? TP

         // Output
         Result(true)
         Result(failure=For input string: "abc")
       ```


@def toDouble_?? -> Double result conversion

       Converts String to Double result

       ```
         "123.45".toDouble_?? TP

         "abc".toDouble_?? TP

         // Output
         Result(123.45)
         Result(failure=For input string: "abc")
       ```


@def toLong_?? -> Long result conversion

       Converts String to Long result

       ```
         "123".toLong_?? TP

         "abc".toLong_?? TP

         // Output
         Result(123)
         Result(failure=For input string: "abc")
      ```


@def toInt_?? -> Int result conversion

       Converts String to Int result

       ```
         "123".toInt_?? TP

         "abc".toInt_?? TP

         // Output
         Result(123)
         Result(failure=For input string: "abc")
       ```
*/
