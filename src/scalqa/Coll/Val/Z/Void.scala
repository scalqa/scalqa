package scalqa; package Coll; package Val; package Z

private[Val] object Void extends Base[Any] with Void {

  def head = Fail("No head for Void Index")
  def tail = Fail("No tail for Void Index")

  final override def size = 0
  final override def all = \/
  final override def allReversed = \/

  final protected override def _minus(a: Any) = this
  final protected override def _minusAll(a: ~[Any]) = this

  final override def +(a: Any)(implicit t: Tag[Any] = Tag.Void): Val[Any] = {
    val tag = (if (t.isVoid) a.Class.tag else t).cast[Tag[_]]
    @inline def This[A]: Base[A] = this.cast
    @inline def v[A] = a.cast[A];
    if (tag.isValue) {
      val d: Any.Value = a.cast
      @inline def w[A] = d._real.cast[A]
      @inline def i[A] = d.kin.cast[A]
      tag match {
        case Tag.RefValue    => new Data.Objects(w, i, This, 1)
        case Tag.ByteValue   => new Data.Bytes(w, i, This, 1)
        case Tag.CharValue   => new Data.Chars(w, i, This, 1)
        case Tag.ShortValue  => new Data.Shorts(w, i, This, 1)
        case Tag.IntValue    => new Data.Ints(w, i, This, 1)
        case Tag.LongValue   => new Data.Longs(w, i, This, 1)
        case Tag.FloatValue  => new Data.Floats(w, i, This, 1)
        case Tag.DoubleValue => new Data.Doubles(w, i, This, 1)
        case _               => Fail()
      }
    } else if (tag.isPrimitive) {
      tag match {
        case Tag.Boolean => new Basic.Bytes(v, This, 1)
        case Tag.Byte    => new Basic.Bytes(v, This, 1)
        case Tag.Char    => new Basic.Chars(v, This, 1)
        case Tag.Short   => new Basic.Shorts(v, This, 1)
        case Tag.Int     => new Basic.Ints(v, This, 1)
        case Tag.Long    => new Basic.Longs(v, This, 1)
        case Tag.Float   => new Basic.Floats(v, This, 1)
        case Tag.Double  => new Basic.Doubles(v, This, 1)
        case _           => Fail()
      }
    } else
      new Basic.Objects(a, This, 1)
  }.cast
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/