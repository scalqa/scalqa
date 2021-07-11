package scalqa; package fx; package scene; package pane; import language.implicitConversions

class Tab extends Control:
  protected type REAL = javafx.scene.control.TabPane
  protected override def _createReal = new REAL

  /**/       lazy val tabs            : Idx.M[Tab.Panel]        = Idx.M.wrap(real.getTabs).mutableMap_^[Tab.Panel]
  /**/       lazy val selection       : Fx.Selection[Tab.Panel] = Fx.Selection(Idx.wrap(real.getTabs), real.getSelectionModel).map_^(Tab.Panel.FxConverter.apply)
  @tn("size_Pro") def side_*          : Pro.OM[Side]            = Fx.JavaFx.To.pro_OM(real.sideProperty).mutableMap_^[Side]
  /**/            def side            : Side                    = real.getSide
  /**/            def side_=(s: Side) : Unit                    = real.setSide(s)

  // ------------------------------------------------------------------------------------------------------
  def add(pos: Int, t: Tab.Panel)                 : Unit = tabs.addAt(pos, t)
  def add(t: Tab.Panel)                           : Unit = tabs += t
  def add(pos: Int, text: String, n: Fx.Node.Like): Unit = add(pos, new Tab.Panel(text, n))
  def add(text: String, n: Fx.Node.Like)          : Unit = add(new Tab.Panel(text, n))

object Tab:
  def apply()        : Pane.Tab = new Pane.Tab
  def apply(s: Side) : Pane.Tab = apply().^(_.side = s)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Panel = tab.Panel;  transparent inline def Panel = tab.Panel


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
