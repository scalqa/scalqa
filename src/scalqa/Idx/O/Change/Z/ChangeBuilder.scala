package scalqa; package Idx; package O; package Change; package Z

private[O] class ChangeBuilder[A](base: Idx[A]) extends Custom.Proxy.Idx.Like[Change[A]] with Change.Builder[A] {
  private var lastOpt: Opt[Change[A]] = \/
  protected val real: Idx.M[Change[A]] = NEW

  def add(c: Change[A]) = { lastOpt = c; real.add(c) }

  def addAt(r: Idx.Range): Unit = lastOpt.letMap(_.ifAddOpt).letType[Entry].let(_.range.end == r.start).apply(_.range resizeBy r.size, add(new Entry(r) with Change.Add[A]))

  def removeAt(r: Idx.Range) = removeAt(r.start, base.all.letAt(r).to[Idx])

  def removeAt(i: Int, elements: Idx[A]): Unit = add(new Entry(i <>>+ elements.size) with Change.Remove[A] { override def apply(i: Int) = elements(i) })

  def update(r: Idx.Range) { removeAt(r); addAt(r) }

  def reposition(r: Idx.Range.Reposition) = add(new Entry(r.range) with Change.Reposition[A] { def indexes = r.indexes })

  def refreshAt(r: Idx.Range) = add(new Entry(r) with Change.Refresh[A])

  // ************************************************************************************************************************************
  private abstract class Entry protected (var range: Idx.Range) extends Change[A] with Idx[A] {
    def value = this

    def items = this

    def apply(i: Int): A = base(range.start + i)

    def size = range.size

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
