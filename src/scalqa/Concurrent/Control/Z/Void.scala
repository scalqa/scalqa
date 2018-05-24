package scalqa; package Concurrent; package Control; package Z

private[Control] object Void extends Control with Void {

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
