package scalqa; package Idx; package O; package Change

class _library[A] private[Change] (private val real: Change[A]) extends AnyVal {

  def ifAddOpt: Opt[Add[A]] = this.I.letType[Add[A]]

  def ifRemoveOpt: Opt[Remove[A]] = this.I.letType[Remove[A]]

  def ifRefreshOpt: Opt[Refresh[A]] = this.I.letType[Refresh[A]]

  def ifRepositionOpt: Opt[Reposition[A]] = this.I.letType[Reposition[A]]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
