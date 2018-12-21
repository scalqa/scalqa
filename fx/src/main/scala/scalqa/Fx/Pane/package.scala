package scalqa; package Fx

package object Pane {
  type Split = Split._Class
  type Tab = Tab._Class

  def make(e1: String, e2: Fx.A.Node.Like): Pane = make(Label.make(e1), e2)

  def make(e1: Fx.A.Node.Like, e2: Fx.A.Node.Like): Pane = new Fx.Pane.Grid { add(0, 0, e1); add(0, 1, e2) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
