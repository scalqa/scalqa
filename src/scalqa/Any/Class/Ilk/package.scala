package scalqa; package Any; package Class

package object Ilk {
  private[scalqa] def This = this

  def make(c: Class[_]): Ilk = Z.fromClass(c)

  def make(a: Array[_]): Ilk = Z.getByArray(a)

  def all: ~[Ilk] = *(Objects, Booleans, Bytes, Chars, Shorts, Ints, Longs, Floats, Doubles)

  val Booleans: Ilk = Z.A.Booleans
  val Bytes: Ilk = Z.A.Bytes
  val Chars: Ilk = Z.A.Chars
  val Shorts: Ilk = Z.A.Shorts
  val Ints: Ilk = Z.A.Ints
  val Longs: Ilk = Z.A.Longs
  val Floats: Ilk = Z.A.Floats
  val Doubles: Ilk = Z.A.Doubles
  val Objects: Ilk = Z.A.Objects
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
