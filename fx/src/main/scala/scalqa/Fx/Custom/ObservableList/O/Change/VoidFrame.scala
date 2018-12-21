package scalqa; package Fx; package Custom; package ObservableList; package O; package Change

object VoidFrame extends Frame[Nothing](\/, null, null) with Void {

  override lazy val getFrom = 0
  override lazy val getTo = 0
  override lazy val getPermutation = Array.emptyIntArray
  override lazy val getRemoved = App.Fail.state
  override lazy val getAddedSubList = App.Fail.state

  override def wasPermutated = false
  override def wasAdded = false
  override def wasRemoved = false

  // ****************************************************
  object BeforeFirst extends Frame[Nothing](\/, null, null) with Void {

    def fail = App.Fail("Was not fetched")

    override lazy val getFrom = fail
    override lazy val getTo = fail
    override lazy val getPermutation = fail
    override lazy val getRemoved = fail
    override lazy val getAddedSubList = fail

    override def wasPermutated = fail
    override def wasAdded = fail
    override def wasRemoved = fail
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
