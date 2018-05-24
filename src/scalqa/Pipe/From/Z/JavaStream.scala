package scalqa; package Pipe; package From; package Z

private[scalqa] object JavaStream extends Pipe.From[java.util.stream.Stream] {

  def apply[A](v: java.util.stream.Stream[A]): Pipe[A] = v.iterator.all

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
