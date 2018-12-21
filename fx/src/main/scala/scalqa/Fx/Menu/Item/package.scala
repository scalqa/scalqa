package scalqa; package Fx; package Menu

import javafx.scene.control.MenuItem;

package object Item {

  def make(a: Action): Item = a match { case c: _Class => c; case _ => new Item(a) }

  def make(text: String): Item = new Item(text)

  def make(text: String, n: Fx.A.Node.Like): Item = make(text).I(_.graphicPro() = n)

  def make(text: String, on: Action.Event => Any): Item = make(text).I(_.onAction(on))

  def make(text: String, enabled: Boolean, on: Action.Event => Any): Item = make(text, on).I(_.enable = enabled)

  def make(real: MenuItem): Item = real.getUserData.asInstanceOf[Item]

  def separator: Item = new Z.Separator

  val map: BiMap[MenuItem, Item] = Map; private object Map extends BiMap[MenuItem, Item] { def apply(real: MenuItem) = make(real); def undo(i: Item): MenuItem = i.real }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
