package scalqa; package Index; package WO; package Z; package The

private[Index] trait Unsupported[A] extends WO[A] with W.Z.The.Unsupported[A] with O.Z.The.Unsupported[A] {

  def refreshAt(i: Int.Range): Unit = Fail.unsupported()

  def multiChange(ch: W[A] => Any): Unit = Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/