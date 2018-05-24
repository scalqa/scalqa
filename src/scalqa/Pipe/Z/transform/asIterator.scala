package scalqa; package Pipe; package Z; package transform

private class asIterator[A](src: Pipe[A]) extends scala.Iterator[A] with java.util.Iterator[A] {
  private var o: Opt[A] = \/

  def nextOpt = o orOpt { o = src.pumpOpt(EVERY); o }

  def hasNext = nextOpt

  def next: A = nextOpt.run(o = \/).value

}

private[Pipe] object asIterator {

  def apply[A](src: Pipe[A]): scala.Iterator[A] with java.util.Iterator[A] = new asIterator(src)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/