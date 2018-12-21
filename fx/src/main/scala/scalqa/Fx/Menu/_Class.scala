package scalqa; package Fx; package Menu

import javafx.scene.control.{ Menu => FxMenu }

class _Class protected extends Item with Any.Able.Add[Fx.Action] {
  def this(text: String, enabled: Boolean = true) = { this; _onCreateGuiRun(new FxMenu(text).asInstanceOf[REAL]); this.enable = enabled }

  // --------------------------------------------------------------------------------------------------
  protected type REAL <: FxMenu
  protected override def _createGui: REAL = new FxMenu().asInstanceOf[REAL]
  // --------------------------------------------------------------------------------------------------

  lazy val items: Idx.M[Item] = Idx.M.wrap(real.getItems).asBiMappedView(Item.map)

  def add(a: Fx.Action) = items += Item.make(a)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
