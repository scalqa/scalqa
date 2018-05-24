package scalqa; package Index; package Z; package The

private[scalqa] trait Stack[A] extends Index[A] with Able.Seal {
  private var first, last: Element = null
  private var _size = 0
  private var listOpt: Opt[Refs[A]] = \/

  def firstOpt: Opt[A] = first.Opt.map(_.value)

  def size = _size

  override def all = new Pipe.The.Base[A] {
    var l = Stack.this.first; var i = 0
    def pumpOpt(f: A => Boolean): Opt[A] = { while (l != null) { val v = l.value; l = l.next; i += 1; if (f(v)) return v }; \/ }
    override def sizeOpt = _size - i
  }

  def popOpt: Opt[A] = firstOpt.swap(pop)

  def add(a: A): Unit = new Element { def value = a }

  def pop: A = first.value.I.run { first = first.next; _size -= 1; listOpt = \/ }

  def toList: Refs[A] = listOpt.default(Array.getByClass[A](first.value.Class, size).load(all).Refs.I(listOpt = _)).value

  def apply(i: Int) = toList(i)

  // ************************************************************************************************************************************
  protected trait Element {
    var next: Element = null
    _failIfSealed
    if (first == null) first = this
    if (last != null) last.next = this
    last = this
    listOpt = \/
    _size += 1

    def value: A
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
