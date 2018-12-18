package scalqa; package Custom; package Array

trait Like[@specialized(DATA) A] extends Any with View[A] {

  def applyUpdateIf(position: Int, updateIf: A => Boolean, newValue: A => A): A = { var b = apply(position); if (updateIf(b)) { b = newValue(b); base.update(position, b) }; b }
  def applyUpdateNull(position: Int, newValue: => A): A = applyUpdateIf(position, _ == null, _ => newValue)

  def sort(implicit o: math.Ordering[A]): Unit = if (!o.isVoid) scala.util.Sorting.quickSort(base)(o.I.asInstanceOfTarget)

  def fill(value: A): Unit = fillAt(size.Range, value)
  def fillAt(r: scalqa.Idx.Range, value: A): Unit = { var i = r.start; val end = r.end; while (i < end) { base.update(i, value); i += 1 } }

  def updateAll(stream: ~[A], controlSize: Opt.Int = \/): Unit = Z.updateAll.at(base, 0, stream, controlSize)
  def updateAllAt(position: Int, stream: ~[A], controlSize: Opt.Int = \/): Unit = Z.updateAll.at(base, position, stream, controlSize)

  def copyResize(newSize: Int) = make(Z.copy.resize(base, newSize))

  def toPrimitive(implicit i: Ilk[A]): scalqa.Idx.I[A] = i.mkValue(base)
  def toRefs: Refs[A] = Refs.copy(base)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
