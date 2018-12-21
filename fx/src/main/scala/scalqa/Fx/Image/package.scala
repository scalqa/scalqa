package scalqa; package Fx

import javafx.scene.image.{ Image => JImage }

package object Image {

  def make(i: JImage) = _Class.make(i)

  def make(url: String): Image = make(new JImage(url))

  def Map = _Class.Map

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
