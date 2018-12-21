package scalqa; package Fx; package A

package object Node {
  private[A] type _events = _events._Trait

  def make(v: javafx.scene.Node): A.Node = new A.Node {
    protected type REAL = javafx.scene.Node
    def _createGui = v
  }

  val Map = BiMap[javafx.scene.Node, Node](v => Delegate.Gui.make(v.onZoomStartedProperty), _.real)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
