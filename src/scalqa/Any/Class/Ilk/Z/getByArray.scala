package scalqa; package Any; package Class; package Ilk; package Z

private[Ilk] object getByArray {

  def apply(a: Array[_]): Ilk = a match {
    case a: Array[Int]     => Ints
    case a: Array[Double]  => Doubles
    case a: Array[Long]    => Longs
    case a: Array[Float]   => Floats
    case a: Array[Byte]    => Bytes
    case a: Array[Char]    => Chars
    case a: Array[Boolean] => Booleans
    case a: Array[Short]   => Shorts
    case _                 => Objects
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
