package scalqa; package Coll; package Val; package Z

private object Basic {

  class Objects[A](val head: A, val tail: Base[A], val size: Int) extends Base[A] {
    @inline override def +(v: A)(implicit t: Tag[A] = \/) = new Objects(v, this, size + 1)
  }

  class Booleans(val head: Boolean, val tail: Base[Boolean], val size: Int) extends Base[Boolean] {
    override def tag = Tag.Boolean
    @inline override def +(v: Boolean)(implicit t: Tag[Boolean] = Tag.Boolean) = new Booleans(v, this, size + 1)
  }

  class Bytes(val head: Byte, val tail: Base[Byte], val size: Int) extends Base[Byte] {
    override def tag = Tag.Byte
    @inline override def +(v: Byte)(implicit t: Tag[Byte] = Tag.Byte) = new Bytes(v, this, size + 1)
  }

  class Chars(val head: Char, val tail: Base[Char], val size: Int) extends Base[Char] {
    override def tag = Tag.Char
    @inline override def +(v: Char)(implicit t: Tag[Char] = Tag.Char) = new Chars(v, this, size + 1)
  }

  class Shorts(val head: Short, val tail: Base[Short], val size: Int) extends Base[Short] {
    override def tag = Tag.Short
    @inline override def +(v: Short)(implicit t: Tag[Short] = Tag.Short) = new Shorts(v, this, size + 1)
  }

  class Ints(val head: Int, val tail: Base[Int], val size: Int) extends Base[Int] {
    override def tag = Tag.Int
    @inline override def +(v: Int)(implicit t: Tag[Int] = Tag.Int) = new Ints(v, this, size + 1)
  }

  class Longs(val head: Long, val tail: Base[Long], val size: Int) extends Base[Long] {
    override def tag = Tag.Long
    @inline override def +(v: Long)(implicit t: Tag[Long] = Tag.Long) = new Longs(v, this, size + 1)
  }

  class Floats(val head: Float, val tail: Base[Float], val size: Int) extends Base[Float] {
    override def tag = Tag.Float
    @inline override def +(v: Float)(implicit t: Tag[Float] = Tag.Float) = new Floats(v, this, size + 1)
  }

  class Doubles(val head: Double, val tail: Base[Double], val size: Int) extends Base[Double] {
    override def tag = Tag.Double
    @inline override def +(v: Double)(implicit t: Tag[Double] = Tag.Double) = new Doubles(v, this, size + 1)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/