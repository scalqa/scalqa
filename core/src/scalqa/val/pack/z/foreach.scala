package scalqa; package `val`; package pack; package z; import language.implicitConversions

object foreach:

  inline def apply[A,U](inline x: Pack[A], inline f: A => U): Unit =
    inline x match
      case x : Boolean.G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Byte   .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Char   .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Short  .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Int    .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Long   .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Float  .G.Pack[A] => x.z_foreachRaw(f(_))
      case x : Double .G.Pack[A] => x.z_foreachRaw(f(_))
      case x                     => x.z_foreach(f(_))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
