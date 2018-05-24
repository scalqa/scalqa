package scalqa; package Pro; package WO; package The

class Named[A <: AnyRef](name: String, v: A) extends Named.Any(name, v)

object Named {

  def apply[A](n: String, a: A): WO[A] with Able.Name with Any.O.Source = {
    def v[T] = a.cast[T]
    a.Class.tag match {
      case Tag.AnyRef      => new Named(n, v)
      case Tag.Boolean     => new Boolean(n, v)
      case Tag.Byte        => new Byte(n, v)
      case Tag.Char        => new Char(n, v)
      case Tag.Short       => new Short(n, v)
      case Tag.Int         => new Int(n, v)
      case Tag.Long        => new Long(n, v)
      case Tag.Float       => new Float(n, v)
      case Tag.Double      => new Double(n, v)
      case Tag.RefValue    => new RefValue(n, v)
      case Tag.ByteValue   => new ByteValue(n, v)
      case Tag.CharValue   => new CharValue(n, v)
      case Tag.ShortValue  => new ShortValue(n, v)
      case Tag.IntValue    => new IntValue(n, v)
      case Tag.LongValue   => new LongValue(n, v)
      case Tag.FloatValue  => new FloatValue(n, v)
      case Tag.DoubleValue => new DoubleValue(n, v)
      case _               => Fail.state()
    }
  }.cast

  class Any[A](val name: String, v: A) extends The.Base.Any[A](v) with Able.Name
  class Boolean(val name: String, v: scala.Boolean) extends The.Base.Boolean(v) with Able.Name
  class Byte(val name: String, v: scala.Byte) extends The.Base.Byte(v) with Able.Name
  class Char(val name: String, v: scala.Char) extends The.Base.Char(v) with Able.Name
  class Short(val name: String, v: scala.Short) extends The.Base.Short(v) with Able.Name
  class Int(val name: String, v: scala.Int) extends The.Base.Int(v) with Able.Name
  class Long(val name: String, v: scala.Long) extends The.Base.Long(v) with Able.Name
  class Float(val name: String, v: scala.Float) extends The.Base.Float(v) with Able.Name
  class Double(val name: String, v: scala.Double) extends The.Base.Double(v) with Able.Name

  class ByteValue[A <: Any.Value.Byte](val name: String, a: A) extends The.Base.ByteValue(a) with Able.Name
  class CharValue[A <: Any.Value.Char](val name: String, a: A) extends The.Base.CharValue(a) with Able.Name
  class ShortValue[A <: Any.Value.Short](val name: String, a: A) extends The.Base.ShortValue(a) with Able.Name
  class IntValue[A <: Any.Value.Int](val name: String, a: A) extends The.Base.IntValue(a) with Able.Name
  class LongValue[A <: Any.Value.Long](val name: String, a: A) extends The.Base.LongValue(a) with Able.Name
  class FloatValue[A <: Any.Value.Float](val name: String, a: A) extends The.Base.FloatValue(a) with Able.Name
  class DoubleValue[A <: Any.Value.Double](val name: String, a: A) extends The.Base.DoubleValue(a) with Able.Name
  class RefValue[A <: Any.Value.Ref[B], B <: AnyRef](val name: String, a: A) extends The.Base.RefValue[A, B](a) with Able.Name
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
