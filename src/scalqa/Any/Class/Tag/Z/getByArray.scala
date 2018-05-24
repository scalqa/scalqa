package scalqa; package Any; package Class; package Tag; package Z

private[Class] object getByArray {

  def apply[A](a: Array.Raw[A]): Tag[A] = a match {
    case Array.VoidRaw    => Void
    case a: Array.Raw[Int]     => Int
    case a: Array.Raw[Double]  => Double
    case a: Array.Raw[Long]    => Long
    case a: Array.Raw[Float]   => Float
    case a: Array.Raw[Byte]    => Byte
    case a: Array.Raw[Char]    => Char
    case a: Array.Raw[Boolean] => Boolean
    case a: Array.Raw[Short]   => Short
    case _                     => AnyRef.cast
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/