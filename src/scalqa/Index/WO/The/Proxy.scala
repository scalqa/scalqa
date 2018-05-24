package scalqa; package Index; package WO; package The

trait Proxy[A] extends WO[A] with Index.W.The.Proxy.Like[A] with Index.O.The.Proxy.Like[A] {

  protected def real: WO[A]

  def refreshAt(i: Int.Range) = real.refreshAt(i)

  def multiChange(ch: W[A] => Any) = real.multiChange(ch)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
