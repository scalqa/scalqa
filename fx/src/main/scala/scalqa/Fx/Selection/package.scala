package scalqa; package Fx

import javafx.scene.control.SelectionModel

package object Selection {

  def make[A](x: Idx[A], m: SelectionModel[_ <: Any]) = new Selection[A](x, m)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
