package scalqa; package Any; package Datum

abstract class Setup[TYPE] private[scalqa] {
  private[scalqa] type VALUE

  protected def make(v: VALUE): TYPE

  protected def undo(v: TYPE): VALUE

  implicit val Setup: Setup[TYPE] = this

  val Map: BiMap[VALUE, TYPE] = new BiMap[VALUE, TYPE] {
    @inline final def apply(v: VALUE): TYPE = Setup.this.make(v)
    @inline final def undo(v: TYPE): VALUE = Setup.this.undo(v)
  }

  private[scalqa] def ilk: Ilk
  private[scalqa] def This: this.type = this
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
