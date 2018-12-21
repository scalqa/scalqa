package scalqa; package Idx; package Z; package A

private[scalqa] class One[A](value: A) extends Idx[A] with scalqa.Void {

  def size = 1

  def apply(i: Int) = if (i == 0) value else App.Fail.argument

  override def all = value.I.~

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
