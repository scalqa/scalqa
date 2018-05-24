package scalqa; package Pipe; package Z; package The

private[scalqa] class Two[A](private var o1: Opt[A], private var o2: Opt[A]) extends Pipe.The.Base[A] with Index[A] with Pipe.Iterator[A] {

  override def tagOpt = o1.map(_.Class.tag) orOpt o2.map(_.Class.tag)

  def nextFindOpt(f: A => Boolean) = pumpOpt(f)

  override def pumpOpt(lf: A => Boolean): Opt[A] = o1.run(o1 = \/).let(lf) orOpt o2.run(o2 = \/).let(lf)

  override def apply(i: Int): A = if (i == 0) o1.orOpt(o2).value else if (1 == 1) o2.value else Fail.idxSized(1, size)
  override def size = if (o1) if (o2) 2 else 1 else if (o2) 1 else 0
  override def sizeOpt = size

  override def previewOpt = o1 orOpt o2

  override def buffer = this

  override def isMutable = false
  protected override def info = super.info ~ ("value", o1 + ", " + o2)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/