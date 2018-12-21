package scalqa; package Fx; package A; package Group

class _Class extends Parent {
  protected type REAL <: javafx.scene.Group; override def _createGui: REAL = new javafx.scene.Group().asInstanceOf[REAL]
  // --------------------------------------------------------------------------------------------------

  lazy val children: Idx.M[Node.Like] = Idx.M.wrap(real.getChildren).asBiMappedView(Node.Like.Map)

  def autoSizeChildrenPro: Pro.OM[Boolean] = Custom.ProWO(real.autoSizeChildrenProperty)

  def autoSizeChildren = real.isAutoSizeChildren; def autoSizeChildren_=(v: Boolean) = real.setAutoSizeChildren(v)

  def +=(e: Node.Like): this.type = { children.add(e); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
