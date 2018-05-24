package scalqa; package Pipe; package Z; package process

private[Pipe] object Yield {

  def sizeAndTag[A](src: Pipe[A]): (Pipe[A], Int, Tag[A]) = { val (sa, sz) = size(src); val (ta, tg) = tag(sa); (ta, sz, tg) }

  // -------------------------------------------------------------------------------------------------
  // if returned Tag.isVoid, then the Pipe is CONFIRMED empty
  def tag[A](src: Pipe[A]): (Pipe[A], Tag[A]) = src.tagOpt.map((src, _)) or new tag(src).I.to(a => a.previewOpt.map(v => (a, v.Class.tag)) or (a, \/))

  private class tag[A](a: Pipe[A]) extends Iterator[A](a)

  // -------------------------------------------------------------------------------------------------
  def size[A](src: Pipe[A]): (Pipe[A], Int) = src.sizeOpt.map((src, _)) or new size(src).I.to(a => (a, a.sizeOpt.value))

  private class size[A](a: Pipe[A]) extends buffer[A](a)

  // -------------------------------------------------------------------------------------------------
  def sizeAtLeast[A](src: Pipe[A], cnt: Int): (Pipe[A], Boolean) = src.sizeOpt.let(_ >= cnt).swap((src, true)) or new sizeAtLeast(src.iterator, cnt).I.to(a => (a, a.buf.sizeOpt.value >= cnt))

  private class sizeAtLeast[A](it: Pipe.Iterator[A], cnt: Int) extends The.Build[A] {
    val buf = it.next(cnt).pipe
    val real = buf ? (_ => it.hasNext, _ ~~ it)
    def pumpOpt(f: A => Boolean): Opt[A] = real.pumpOpt(f)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
