package scalqa; package lang; package char; package z; package stream; import language.implicitConversions

object filter:

  inline def TAKE[A<:Raw](inline s: G.~[A], inline  f: A=>Boolean): G.~[A] =
    class TakeStream(x: G.~[A]) extends G.~[A] with ~~.Custom.Pipeline:
      def base = x
      @tn("readRaw_Opt") def readRaw_? =
        var o=x.readRaw_?
        while(o)
          if(f(o.`val`)) return o
          o=x.readRaw_?
        o
    new TakeStream(s)

  inline def DROP[A<:Raw](inline s: G.~[A], inline f: A=>Boolean): G.~[A] =
    class DropStream(x: G.~[A]) extends G.~[A] with ~~.Custom.Pipeline:
      def base = x
      @tn("readRaw_Opt") def readRaw_? =
        var o=x.readRaw_?
        while(o)
          if(!f(o.`val`)) return o
          o=x.readRaw_?
        o
    new DropStream(s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
