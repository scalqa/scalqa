package scalqa; package Any; package Ilk; package Z

private[Ilk] object fromArray {

  def apply(a: Array[_]): Ilk = a match {
    case _: Array[Int]     => Ints
    case _: Array[Double]  => Doubles
    case _: Array[Long]    => Longs
    case _: Array[Float]   => Floats
    case _: Array[Byte]    => Bytes
    case _: Array[Char]    => Chars
    case _: Array[Boolean] => Booleans
    case _: Array[Short]   => Shorts
    case _                 => Refs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
