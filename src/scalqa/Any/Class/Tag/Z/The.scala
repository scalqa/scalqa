package scalqa; package Any; package Class; package Tag; package Z

private[Class] object The {

  // General ----------------------------------------------------------------------------------------------------

  object Void extends Tag[Any](null, false) with Void

  object AnyVal extends Tag[AnyVal](null, false) { type TYPE <: AnyVal }

  object AnyRef extends Tag[AnyRef](null, false) { type TYPE <: AnyRef }

  // Primitive ---------------------------------------------------------------------------------------------------

  object Boolean extends Tag[Boolean]() { type TYPE = Boolean; override def _get(s: Int) = Array.Z.Raw.getBoolean(s) }

  object Byte extends Tag[Byte]() { type TYPE = Byte; override def _get(s: Int) = Array.Z.Raw.getByte(s) }

  object Char extends Tag[Char]() { type TYPE = Char; override def _get(s: Int) = Array.Z.Raw.getChar(s) }

  object Short extends Tag[Short]() { type TYPE = Short; override def _get(s: Int) = Array.Z.Raw.getShort(s) }

  object Int extends Tag[Int]() { type TYPE = Int; override def _get(s: Int) = Array.Z.Raw.getInt(s) }

  object Long extends Tag[Long]() { type TYPE = Long; override def _get(s: Int) = Array.Z.Raw.getLong(s) }

  object Float extends Tag[Float]() { type TYPE = Float; override def _get(s: Int) = Array.Z.Raw.getFloat(s) }

  object Double extends Tag[Double]() { type TYPE = Double; override def _get(s: Int) = Array.Z.Raw.getDouble(s) }

  // Values ----------------------------------------------------------------------------------------------------

  object ByteValue extends Tag[Any.Value.Byte with AnyVal](Byte) { type TYPE <: Any.Value.Byte }

  object CharValue extends Tag[Any.Value.Char with AnyVal](Char) { type TYPE <: Any.Value.Char }

  object ShortValue extends Tag[Any.Value.Short with AnyVal](Short) { type TYPE <: Any.Value.Short }

  object IntValue extends Tag[Any.Value.Int with AnyVal](Int) { type TYPE <: Any.Value.Int }

  object LongValue extends Tag[Any.Value.Long with AnyVal](Long) { type TYPE <: Any.Value.Long }

  object FloatValue extends Tag[Any.Value.Float with AnyVal](Float) { type TYPE <: Any.Value.Float }

  object DoubleValue extends Tag[Any.Value.Double with AnyVal](Double) { type TYPE <: Any.Value.Double }

  object RefValue extends Tag[Any.Value.Ref[_] with AnyVal](AnyRef, false) { type TYPE <: Any.Value.Ref[_] }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/