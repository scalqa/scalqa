package scalqa; package lang; package double; package z; package stream; import language.implicitConversions

object filter:

  inline def TAKE[A<:Raw](inline s: G.Stream[A], inline  f: A=>Boolean): G.Stream[A] =
    class TakeStream(x: G.Stream[A]) extends G.Stream[A] with Stream.Custom.Pipeline:
      def base = x
      def readRawOpt =
        var o=x.readRawOpt
        while(o)
          if(f(o.`val`)) return o
          o=x.readRawOpt
        o
    new TakeStream(s)

  inline def DROP[A<:Raw](inline s: G.Stream[A], inline f: A=>Boolean): G.Stream[A] =
    class DropStream(x: G.Stream[A]) extends G.Stream[A] with Stream.Custom.Pipeline:
      def base = x
      def readRawOpt =
        var o=x.readRawOpt
        while(o)
          if(!f(o.`val`)) return o
          o=x.readRawOpt
        o
    new DropStream(s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
