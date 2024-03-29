package scalqa; package lang; package anyref; import language.implicitConversions

object G:
  transparent inline def Buffer    = g.Buffer;       type Buffer[A] = g.Buffer[A]
  transparent inline def Range     = g.Range;        type Range[A]  = g.Range[A]
  transparent inline def Companion = g.Companion
  transparent inline def Fun       = g.Fun

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object G -> ### AnyRef Generic Container Implementations

Generally containers in the [Val](../../Val$.html) framework by default handle AnyRef values, though some implementations are abstract.
Thus, AnyRef.G provides missing container implementations and definitions relevant to AnyRef types.

*/