package scalqa; package Index; package W; package The

class ValWrap[A](initSizeOpt: Opt[Int])(implicit tag: Tag[A]) extends ArrayBase[A] {
  private type T = tag.valueTag.TYPE
  private var raw: Array.Raw[T] = tag.valueTag.newArrayRaw(0).cast
  private var companion: Any.Value.Companion[A, T] = null

  def apply(i: Int): A = companion.map(raw(i))

  @inline protected def _arraySize = raw.length

  @inline protected def _arrayUpdate(i: Int, v: A) = raw(i) = companion.undo(v)

  @inline protected def _arrayCopySelf(r: Int.Range, i: Int) = { val a = Array.getByRaw[T](raw); a.copyToArray(a, i, r) }

  @inline protected def _arraySetup(v: A) = { companion = v.cast[Any.Value].kin.cast; raw = tag.valueTag.newArrayRaw(initSizeOpt or App.Pro.DefaultBufferSize()).cast }

  @inline protected def _arrayGrow(s: Int) = raw = Array.getByRaw[T](raw).copyResize((raw.length * 1.5).toInt).raw.cast

  protected override def info = super.info ~ ("array", raw)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
