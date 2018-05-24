package scalqa; package Pipe; package Z; package The

private[scalqa] class One[A](private var o: Opt[A]) extends Pipe.The.Base[A] with Index[A] with Pipe.Iterator[A] {

  override def tagOpt = o.map(_.Class.tag)

  def nextFindOpt(f: A => Boolean) = pumpOpt(f)

  override def pumpOpt(lf: A => Boolean): Opt[A] = o.run(o = \/).let(lf)

  override def apply(i: Int): A = { Assert.idxSized(i, size); o.value }
  override def size = if (o) 1 else 0
  override def sizeOpt = size

  override def letFirst(cnt: Int): Pipe[A] = { if (cnt < 1) o = \/; this }
  override def letLast(cnt: Int): Pipe[A] = { if (cnt < 1) o = \/; this }
  override def letAt(r: Int.Range): Pipe[A] = { if (!r.contains(0)) o = \/; this }
  override def dropFirst(cnt: Int): Pipe[A] = { if (cnt > 0) o = \/; this }
  override def dropLast(cnt: Int): Pipe[A] = { if (cnt > 0) o = \/; this }

  override def buffer = this
  override def reverse = this

  override def previewOpt = o

  override def isMutable = false
  protected override def info = super.info ~ ("value", o)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/