package scalqa; package Any; package Extra; package Z; package Entry

private[Extra] object Void extends _Class(null, null, null) with Void {

  override def child = this

  override def isCancelled = false;

  override def cancel = Fail();

  override def all(scope: AnyRef): ~[Entry] = \/;

  protected override def info = super.info ~ (null, "void")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/