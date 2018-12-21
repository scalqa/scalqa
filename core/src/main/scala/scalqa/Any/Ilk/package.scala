package scalqa; package Any

package object Ilk {
  private[scalqa] def This = this

  def fromClass(c: Class[_]): Ilk = Z.fromClass(c)

  def fromArray(a: Array[_]): Ilk = Z.fromArray(a)

  def all: ~[Ilk] = ~.*(Refs, Booleans, Bytes, Chars, Shorts, Ints, Longs, Floats, Doubles)

  val Booleans: Ilk = Z.A.Booleans
  val Bytes: Ilk = Z.A.Bytes
  val Chars: Ilk = Z.A.Chars
  val Shorts: Ilk = Z.A.Shorts
  val Ints: Ilk = Z.A.Ints
  val Longs: Ilk = Z.A.Longs
  val Floats: Ilk = Z.A.Floats
  val Doubles: Ilk = Z.A.Doubles
  val Refs: Ilk = Z.A.Refs
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
