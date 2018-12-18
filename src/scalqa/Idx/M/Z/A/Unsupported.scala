package scalqa; package Idx; package M; package Z; package A

private[Idx] trait Unsupported[A] extends M[A] {

  def addAt(i: Int, e: A): Unit = App.Fail.unsupported()

  def update(i: Int, e: A): Unit = App.Fail.unsupported()

  def removeAt(i: Idx.Range): Unit = App.Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/