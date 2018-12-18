package scalqa; package App; package Event; package Z

private[Event] object Void extends Event with Void {

  def cancel = true;

  def isCancelled = true

  def cancelIf(b: () => Boolean) = this;

  def onCancel(b: () => Any) = this;

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
