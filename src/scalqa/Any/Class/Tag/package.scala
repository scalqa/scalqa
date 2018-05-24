package scalqa; package Any; package Class

package object Tag {
  private[scalqa] def This = this

  def get[A](c: Class[A]): Tag[_] = Z.getByClass(c)

  def get[A](a: Array[A]): Tag[A] = Z.getByArray(a.raw)

  def getByArrayRaw[A](a: Array.Raw[A]): Tag[A] = Z.getByArray(a)

  // --------------------------------------------------------------------------------------------------------------
  val Void: Tag[Any] = Z.The.Void
  val AnyVal: Tag[AnyVal] = Z.The.AnyVal
  val AnyRef: Tag[AnyRef] = Z.The.AnyRef

  val Boolean: Tag[Boolean] = Z.The.Boolean
  val Byte: Tag[Byte] = Z.The.Byte
  val Char: Tag[Char] = Z.The.Char
  val Short: Tag[Short] = Z.The.Short
  val Int: Tag[Int] = Z.The.Int
  val Long: Tag[Long] = Z.The.Long
  val Float: Tag[Float] = Z.The.Float
  val Double: Tag[Double] = Z.The.Double

  val ByteValue: Tag[Any.Value.Byte with AnyVal] = Z.The.ByteValue
  val CharValue: Tag[Any.Value.Char with AnyVal] = Z.The.CharValue
  val ShortValue: Tag[Any.Value.Short with AnyVal] = Z.The.ShortValue
  val IntValue: Tag[Any.Value.Int with AnyVal] = Z.The.IntValue
  val LongValue: Tag[Any.Value.Long with AnyVal] = Z.The.LongValue
  val FloatValue: Tag[Any.Value.Float with AnyVal] = Z.The.FloatValue
  val DoubleValue: Tag[Any.Value.Double with AnyVal] = Z.The.DoubleValue
  val RefValue: Tag[Any.Value.Ref[_] with AnyVal] = Z.The.RefValue

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/