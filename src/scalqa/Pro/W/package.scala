package scalqa; package Pro

package object W {
  type The[A] = The._Class[A]

  def get[A](a: A): W[A] = {
    def v[T] = a.cast[T]
    a.Class.tag match {
      case Tag.AnyRef      => new The(v)
      case Tag.Boolean     => new The.Base.Boolean(v)
      case Tag.Byte        => new The.Base.Byte(v)
      case Tag.Char        => new The.Base.Char(v)
      case Tag.Short       => new The.Base.Short(v)
      case Tag.Int         => new The.Base.Int(v)
      case Tag.Long        => new The.Base.Long(v)
      case Tag.Float       => new The.Base.Float(v)
      case Tag.Double      => new The.Base.Double(v)
      case Tag.RefValue    => new The.Base.RefValue(v)
      case Tag.ByteValue   => new The.Base.ByteValue(v)
      case Tag.CharValue   => new The.Base.CharValue(v)
      case Tag.ShortValue  => new The.Base.ShortValue(v)
      case Tag.IntValue    => new The.Base.IntValue(v)
      case Tag.LongValue   => new The.Base.LongValue(v)
      case Tag.FloatValue  => new The.Base.FloatValue(v)
      case Tag.DoubleValue => new The.Base.DoubleValue(v)
      case _               => Fail.state()
    }
  }.cast

  def getNamed[A](name: String, value: A): W[A] with Able.Name = new The.Z.Named(name, value)

  def getSealable[A](value: A): W[A] with Able.Seal = new The.Z.Sealable(value)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/