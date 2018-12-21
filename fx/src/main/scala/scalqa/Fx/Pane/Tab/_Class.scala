package scalqa; package Fx; package Pane; package Tab

class _Class extends Fx.A.Control {
  protected type REAL = javafx.scene.control.TabPane

  protected override def _createGui = new REAL

  def sidePro = Custom.ProWO(real.sideProperty).asBiMappedView(Side); def side = real.getSide; def side_=(s: Side) = real.setSide(s)

  lazy val tabs = Idx.M.wrap(real.getTabs).asBiMappedView(Panel.biMap)

  lazy val selection = Selection.make(Idx.wrap(real.getTabs), real.getSelectionModel).asMappedView(Panel.biMap.apply)

  // ------------------------------------------------------------------------------------------------------
  def add(pos: Int, t: Panel) = tabs.addAt(pos, t)

  def add(t: Panel) = tabs += t

  def add(pos: Int, text: String, n: Fx.A.Node.Like): Unit = add(pos, new Panel(text, n))

  def add(text: String, n: Fx.A.Node.Like): Unit = add(new Panel(text, n))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
