package scalqa; package Fx; package Ui

abstract class Module extends Fx.A.Module {
  protected type REAL = javafx.scene.Parent; protected final override def _createGui: REAL = view.real
  private var parentOpt: Opt[Module] = \/
  private val children: Idx.M[Module] = NEW

  protected def addChild(e: Module) {
    if (e.parentOpt) App.Fail()
    e.parentOpt = this
    children += e
  }

  protected def view: A.Parent

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
