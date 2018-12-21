package scalqa; package Any; package Ilk; package Z

private[Ilk] object fromClass {

  def apply[A](c: Class[A]): Ilk = c match {
    case v if (v.isPrimitive) => v match {
      case Booleans.RootClass => Booleans
      case Bytes.RootClass    => Bytes
      case Chars.RootClass    => Chars
      case Shorts.RootClass   => Shorts
      case Ints.RootClass     => Ints
      case Longs.RootClass    => Longs
      case Floats.RootClass   => Floats
      case Doubles.RootClass  => Doubles
      case _                  => App.Fail()
    }
    case Booleans.BoxedClass => Booleans
    case Bytes.BoxedClass    => Bytes
    case Chars.BoxedClass    => Chars
    case Shorts.BoxedClass   => Shorts
    case Ints.BoxedClass     => Ints
    case Longs.BoxedClass    => Longs
    case Floats.BoxedClass   => Floats
    case Doubles.BoxedClass  => Doubles
    case _                   => Refs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
