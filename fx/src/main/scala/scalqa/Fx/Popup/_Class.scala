package scalqa; package Fx; package Popup

class _Class extends Window {
  protected type REAL = javafx.stage.Popup
  protected override def _createGui: REAL = new REAL
  // --------------------------------------------------------------------------------------------------

  def children: Idx.M[A.Node.Like] = Idx.M.wrap(real.getContent).asBiMappedView(A.Node.Like.Map)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
