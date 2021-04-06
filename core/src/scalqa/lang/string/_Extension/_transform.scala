package scalqa; package lang; package string; package _Extension; import language.implicitConversions

transparent trait _transform[A <: String | Opaque.String]:
  self: z.Lib[A] =>

  extension(x: A)
    @tn("char_Stream")      def char_~                         : Char.~          = z.CharStream(x.real)
    @tn("split_Stream")     def split_~(separator: Char)       : ~[A]            = x.real.split(separator).~.cast[~[A]]
    @tn("split_Stream")     def split_~(separators:Array[Char]): ~[A]            = x.real.split(separators).~.cast[~[A]]
    @tn("line_Stream")      def line_~                         : ~[A]            = z.LineStream(x).cast[~[A]]
    inline                  def indent(tag: A|String)          : A               = Z.indent(x, tag).cast[A]
    @tn("tokenized_Stream") def tokenized_~(separators: ~[A])  : ~[(A,Int.<>,A)] = Z.tokenizedStream(x, separators.cast[~[String]]).cast[~[(A,Int.<>,A)]]
    @tn("toDouble_Opt")     def toDouble_?                     : Double.Opt      = try{x.real.toDouble } catch{ case _ => \/}
    @tn("toDouble_Result")  def toDouble_??                    : Result[Double]  = try{x.real.toDouble } catch{ case v:Throwable => Result.Problem(v) }
    @tn("toInt_Opt")        def toInt_?                        : Int.Opt         = try{x.real.toInt    } catch{ case _ => \/}
    @tn("toInt_Result")     def toInt_??                       : Result[Int]     = try{x.real.toInt    } catch{ case v:Throwable => Result.Problem(v) }
    @tn("toLong_Opt")       def toLong_?                       : Long.Opt        = try{x.real.toLong   } catch{ case _ => \/}
    @tn("toLong_Result")    def toLong_??                      : Result[Long]    = try{x.real.toLong   } catch{ case v:Throwable => Result.Problem(v) }
    @tn("toBoolean_Opt")    def toBoolean_?                    : Boolean.Opt     = try{x.real.toBoolean} catch{ case _ => \/}
    @tn("toBoolean_Result") def toBoolean_??                   : Result[Boolean] = try{x.real.toBoolean} catch{ case v:Throwable => Result.Problem(v) }
    @tn("nonEmpty_Opt")     def nonEmpty_?                     : Opt[A]          = if (x != null && x.trim.length > 0) x else \/

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
        "abc\nde\nxyz".indent("Idxs: ").TP
        // Output
        Idxs: abc
               de
               xyz
     ```


@def line_~ -> Source of lines

     Creates a [[Source]] of Strings representing lines (delimited by '\n') of this text

     ```  "abc\n def\n xyz".line_~.TP // Prints ~(abc,  def,  xyz) ```



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
         str.replace("\n", "_").tokenized_~(Stream("000","111","222","333","444")).TP

         // Output

         Text to Tokenize:

         12345678910111213141516171819202122232425262728293031323334353637383940

         (Token,Range,String)
         --- --------- -------------------
         ?   ?         ?
         --- --------- -------------------
             0 <>> 11  12345678910
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
