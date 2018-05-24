package scalqa; package Pro; package WO; package The

trait Base[A] extends WO[A] with W.The.Base[A] with O[A] with Any.Extra.Event0 {

  override def onChange(f: () => Any) = _onEvent0(Base.ChangeId, f)

  protected override def fireChange(a: A) = { _fireEvent0(Base.ChangeId) /*; fireObservableChangeEvent*/ }

}

object Base {
  private object ChangeId

  import scala.{ Boolean => BOOL, Byte => BYTE, Char => CHAR, Short => SHORT, Int => INT, Long => LONG, Float => FLOAT, Double => DBLE }

  class Any[A](v: A) extends W.The.Base.Any(v) with Base[A]
  class Boolean(v: BOOL) extends W.The.Base.Boolean(v) with Base[BOOL]
  class Byte(v: BYTE) extends W.The.Base.Byte(v) with Base[BYTE] { def this() = this(0) }
  class Char(v: CHAR) extends W.The.Base.Char(v) with Base[CHAR] { def this() = this(0) }
  class Short(v: SHORT) extends W.The.Base.Short(v) with Base[SHORT] { def this() = this(0) }
  class Int(v: INT) extends W.The.Base.Int(v) with Base[INT] { def this() = this(0) }
  class Long(v: LONG) extends W.The.Base.Long(v) with Base[LONG] { def this() = this(0) }
  class Float(v: FLOAT) extends W.The.Base.Float(v) with Base[FLOAT] { def this() = this(0) }
  class Double(v: DBLE) extends W.The.Base.Double(v) with Base[DBLE] { def this() = this(0) }

  class ByteValue[A <: Any.Value.Byte](a: A) extends W.The.Base.ByteValue(a) with Base[A]
  class CharValue[A <: Any.Value.Char](a: A) extends W.The.Base.CharValue(a) with Base[A]
  class ShortValue[A <: Any.Value.Short](a: A) extends W.The.Base.ShortValue(a) with Base[A]
  class IntValue[A <: Any.Value.Int](a: A) extends W.The.Base.IntValue(a) with Base[A]
  class LongValue[A <: Any.Value.Long](a: A) extends W.The.Base.LongValue(a) with Base[A]
  class FloatValue[A <: Any.Value.Float](a: A) extends W.The.Base.FloatValue(a) with Base[A]
  class DoubleValue[A <: Any.Value.Double](a: A) extends W.The.Base.DoubleValue(a) with Base[A]
  class RefValue[A <: Any.Value.Ref[B], B <: AnyRef](a: A) extends W.The.Base.RefValue[A, B](a) with Base[A]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
