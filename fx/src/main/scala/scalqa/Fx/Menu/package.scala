package scalqa; package Fx

package object Menu {
  type Item = Item._Class

  def make(text: String, enabled: Boolean = true): Menu = new Menu(text, enabled)

  def make(text: String, n: Fx.A.Node.Like): Menu = make(text).I(_.graphicPro() = n)

  def make(text: String, n: Fx.A.Node.Like, its: ~[Item]): Menu = make(text, n).I(_.items +~= its)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
