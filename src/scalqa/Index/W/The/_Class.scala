package scalqa; package Index; package W; package The

class _Class[A] protected (initSizeOpt: Opt[Int], protected var array: Array.Raw[_ >: A]) extends ArrayBase[A] {
  def this(initSizeOpt: Opt[Int] = \/)(implicit t: Tag[A] = \/) = this(initSizeOpt, if (t.isVoid) Array.VoidRaw.cast else t.newArrayRaw(initSizeOpt or App.Pro.DefaultBufferSize()))

  def apply(i: Int): A = array(i).cast[A]

  @inline protected def _arraySize = array.length: @inline

  @inline protected def _arrayUpdate(i: Int, v: A) = array(i) = v: @inline

  @inline protected def _arrayCopySelf(r: Int.Range, i: Int) = { val a = Array.getByRaw[A](array); a.copyToArray(a, i, r) }

  @inline protected def _arraySetup(v: A) = array = v.Class.tag.newArrayRaw(initSizeOpt or (App.Pro.DefaultBufferSize() max 5))

  @inline protected def _arrayGrow(s: Int) = array = Array.getByRaw(array).copyResize((array.length * 1.5).toInt).raw

  protected override def info = super.info ~ ("array", array)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
