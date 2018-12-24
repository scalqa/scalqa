package scalqa; package Fx

import javafx.scene.control.MenuItem

package object Action {

  def make(mi: MenuItem): Action = mi.getUserData.asInstanceOf[Action]

  def make(n: A.Node): Action = n.I.as[Action](new Menu.Item.A.Basic(_))

  def make(s: SEPARATOR.type): Action = new Z.Separator

  def make(n: A.Node.Like): Action = new Z.Basic(n)

  def make(n1: A.Node.Like, n2: A.Node.Like): Action = make(Pane.make(n1, n2))

  def make(label: String, enabled: Boolean, on: => Any): Action = new Action(label).I(a => { a.enable = enabled; a.onActionRun(on) })

  def make(label: String, on: => Any): Action = make(label, true, on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
