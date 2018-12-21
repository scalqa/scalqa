package scalqa; package Fx; package Paint

import javafx.scene.paint.{ Color => JColor }

package object Color extends Z.Named {
  private[Fx] def This = this

  def make(red: Int, green: Int, blue: Int) = _Class.make(JColor.rgb(red, green, blue))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
