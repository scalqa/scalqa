package scalqa; package Coll; package Val; package Z

private object Data {

  class Objects[A <: Any.Value.Ref[B], B <: AnyRef](v: B, companion: Any.Value.Ref.Companion[A, B], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Objects(v._real, companion, this, size + 1)
  }

  class Bytes[A <: Any.Value.Byte](v: Byte, companion: Any.Value.Byte.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Bytes(v._real, companion, this, size + 1)
  }

  class Chars[A <: Any.Value.Char](v: Char, companion: Any.Value.Char.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Chars(v._real, companion, this, size + 1)
  }

  class Shorts[A <: Any.Value.Short](v: Short, companion: Any.Value.Short.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Shorts(v._real, companion, this, size + 1)
  }

  class Ints[A <: Any.Value.Int](v: Int, companion: Any.Value.Int.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Ints(v._real, companion, this, size + 1)
  }

  class Longs[A <: Any.Value.Long](v: Long, companion: Any.Value.Long.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Longs(v._real, companion, this, size + 1)
  }

  class Floats[A <: Any.Value.Float](v: Float, companion: Any.Value.Float.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Floats(v._real, companion, this, size + 1)
  }

  class Doubles[A <: Any.Value.Double](v: Double, companion: Any.Value.Double.Companion[A], val tail: Base[A], val size: Int) extends Base[A] {
    def head = companion.map(v);
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Doubles(v._real, companion, this, size + 1)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/