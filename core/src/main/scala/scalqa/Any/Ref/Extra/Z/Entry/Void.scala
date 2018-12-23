package scalqa; package Any; package Ref; package Extra; package Z; package Entry

private[Extra] object Void extends _Class(null, null, null) with Void {

  override def child = this

  override def cancel = App.Fail();

  override def all(scope: AnyRef): ~[Entry] = \/

  override def toInfo = super.toInfo += (("", "void"))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
