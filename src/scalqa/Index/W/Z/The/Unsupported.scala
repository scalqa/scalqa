package scalqa; package Index; package W; package Z; package The

private[Index] trait Unsupported[A] extends W[A] {

  def addAt(i: Int, e: A): Unit = Fail.unsupported()

  def replaceAt(i: Int, e: A): Unit = Fail.unsupported()

  def removeAt(i: Int.Range): Unit = Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/