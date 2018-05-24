package scalqa; package Pipe; package Z; package process

private class sized[A](a: Pipe[A]) extends process.buffer[A](a)

private class tagged[A](a: Pipe[A]) extends Iterator[A](a)

private[Pipe] object sized {

  def apply[A](src: Pipe[A]): (Pipe[A], Int) = src.sizeOpt.map((src, _)) or new sized(src).I.to(a => (a, a.sizeOpt.value))

  def andKing[A](src: Pipe[A]): (Pipe[A], Int, Tag[A]) = apply(src).to((all, size) =>
    if (size == 0) (all, size, Tag.Void)
    else all.tagOpt.map((all, size, _)) or new tagged(all).I.to(a => (a, size, a.preview.Class.tag)))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
