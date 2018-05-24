package scalqa; package Pipe; package Z; package transform

private[Pipe] class sized[A](all: Pipe[A]) extends toIndex[A](all)

private[Pipe] object sized {

  def apply[A](src: Pipe[A]): Pipe[A] = if (src.sizeOpt) src else new sized(src).all

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/