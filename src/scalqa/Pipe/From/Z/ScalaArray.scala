package scalqa; package Pipe; package From; package Z

private[scalqa] object ScalaArray extends Pipe.From[scala.Array] {

  def apply[A](v: scala.Array[A]): Pipe[A] = new all(v)

  // ******************************************************************
  private class all[A](a: scala.Array[A]) extends Pipe.The.ArrayBasic[A](a)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
