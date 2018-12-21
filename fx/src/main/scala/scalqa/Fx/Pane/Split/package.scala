package scalqa; package Fx; package Pane

package object Split {

  def make = new Split

  def make(o: Orientation): Split = make.I(_.orientation = o)

  def make(e1: Fx.A.Node.Like, e2: Fx.A.Node.Like): Split = make.I(_.items += e1 += e2)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
