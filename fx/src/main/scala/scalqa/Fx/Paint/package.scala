package scalqa; package Fx

import javafx.scene.paint.{ Paint => JPaint }

package object Paint {
  type Color = Color._Class

  def make(v: JPaint) = new Paint { type REAL = JPaint;  def real = v }

  val Map: BiMap[JPaint, Paint] = TheMap; private object TheMap extends BiMap[JPaint, Paint] { def apply(v: JPaint) = make(v); def undo(v: Paint) = v.real }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
