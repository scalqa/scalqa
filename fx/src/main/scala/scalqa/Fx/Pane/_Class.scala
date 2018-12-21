package scalqa; package Fx; package Pane

abstract class _Class protected extends Fx.A.Region {
  protected type REAL <: javafx.scene.layout.Pane
  protected override def _createGui: REAL = new javafx.scene.layout.Pane().asInstanceOf[REAL]

  val children: Idx.M[Fx.A.Node.Like] = Idx.M.wrap(real.getChildren).asBiMappedView(Fx.A.Node.Like.Map)

  def add(n: Fx.A.Node.Like): Unit = children += n

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
