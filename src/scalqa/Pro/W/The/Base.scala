package scalqa; package Pro; package W; package The

import scala.{ Boolean => BOOL, Byte => BYTE, Char => CHAR, Short => SHORT, Int => INT, Long => LONG, Float => FLOAT, Double => DBLE }

trait Base[A] extends W[A] {

  @inline protected def fireChange(v: A): Unit = ()

}

object Base {

  class Any[A](private var p: A) extends Base[A] { def apply = p; def update(v: A) = if (p != v) { p = v; fireChange(v) } }

  class Boolean(private var p: BOOL) extends Base[BOOL] { def apply = p; def update(v: BOOL) = if (p != v) { p = v; fireChange(v) } }

  class Byte(private var p: BYTE) extends Base[BYTE] { def apply = p; def update(v: BYTE) = if (p != v) { p = v; fireChange(v) } }

  class Char(private var p: CHAR) extends Base[CHAR] { def apply = p; def update(v: CHAR) = if (p != v) { p = v; fireChange(v) } }

  class Short(private var p: SHORT) extends Base[SHORT] { def apply = p; def update(v: SHORT) = if (p != v) { p = v; fireChange(v) } }

  class Int(private var p: INT) extends Base[INT] { def apply = p; def update(v: INT) = if (p != v) { p = v; fireChange(v) } }

  class Long(private var p: LONG) extends Base[LONG] { def apply = p; def update(v: LONG) = if (p != v) { p = v; fireChange(v) } }

  class Float(private var p: FLOAT) extends Base[FLOAT] { def apply = p; def update(v: FLOAT) = if (p != v) { p = v; fireChange(v) } }

  class Double(private var p: DBLE) extends Base[DBLE] { def apply = p; def update(v: DBLE) = if (p != v) { p = v; fireChange(v) } }

  class ByteValue[A <: Any.Value.Byte] private (private var p: BYTE, m: BiMap[BYTE, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class CharValue[A <: Any.Value.Char] private (private var p: CHAR, m: BiMap[CHAR, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class ShortValue[A <: Any.Value.Short] private (private var p: SHORT, m: BiMap[SHORT, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class IntValue[A <: Any.Value.Int] private (private var p: INT, m: BiMap[INT, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class LongValue[A <: Any.Value.Long] private (private var p: LONG, m: BiMap[LONG, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class FloatValue[A <: Any.Value.Float] private (private var p: FLOAT, m: BiMap[FLOAT, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class DoubleValue[A <: Any.Value.Double] private (private var p: DBLE, m: BiMap[DBLE, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
  class RefValue[A <: Any.Value.Ref[B], B <: AnyRef] private (private var p: B, m: BiMap[B, A]) extends Base[A] { /**/ def this(a: A) = this(a._real, a.kin.map cast)
    def apply = m(p); def update(v: A) { val a = m.undo(v); if (a != p) { p = a; fireChange(v) } }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
