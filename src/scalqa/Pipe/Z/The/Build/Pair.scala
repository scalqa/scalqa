package scalqa; package Pipe; package Z; package The; package Build

private[Pipe] abstract class Pair[A, B, C](val one: Pipe[A], val two: Pipe[B]) extends Pipe.The.Base[C] {

  override def isMutable = one.isMutable || two.isMutable

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/