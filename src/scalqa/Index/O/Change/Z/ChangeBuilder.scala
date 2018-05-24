package scalqa; package Index; package O; package Change; package Z

private[O] class Builder[A](base: Index[A]) extends Index.Z.The.Stack[Change[A]] with Change.Builder[A] {
  private var lastOpt: Opt[Entry] = \/

  def changes = this

  def addAt(r: Int.Range): Unit = lastOpt.let(c => c.indexAddOpt && c.range.end == r.start && !c.listOpt).apply(_.range += r.size).voidRun(new Entry.Add(r))

  def removeAt(r: Int.Range) = removeAt(r.start, base.all.letAt(r).to[Index])

  def removeAt(i: Int, elements: Index[A]): Unit = new Entry.Remove(i, elements)

  def replaceAt(r: Int.Range) { removeAt(r); addAt(r) }

  def reposition(r: Int.Range.Reposition) = new Entry.Reposition(r)

  def refreshAt(r: Int.Range) = new Entry.Refresh(r)

  override def add(c: Change[A]) = super.add(c)

  // ************************************************************************************************************************************
  private abstract class Entry protected (var range: Int.Range) extends Change[A] with Index[A] with Element {
    lastOpt = this
    var listOpt: Opt[Index[A]] = \/
    def value = this
    def items = this
    def apply(i: Int): A = listOpt.map(_(i)) or base(range.start + i)
    def size = range.size
  }

  // ************************************************************************************************************************************
  private object Entry {

    class Add(r: Int.Range) extends Entry(r) with O.Add[A]

    class Remove(p: Int, l: Index[A]) extends Entry(p <>>+ l.size) with O.Remove[A] { listOpt = l }

    class Reposition(r: Int.Range.Reposition) extends Entry(r.range) with O.Reposition[A] { def indexes = r.indexes }

    class Refresh(r: Int.Range) extends Entry(r) with O.Refresh[A]
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/