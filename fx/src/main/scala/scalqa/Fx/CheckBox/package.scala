package scalqa; package Fx

package object CheckBox {

  def make(text: Opt[String] = \/, checked: Opt[Boolean] = \/, action: CheckBox => Any = \/): CheckBox = new CheckBox().I(c => {
    text(c.text= _)
    checked(c.selected= _)
    action.I.Opt(a => c.onActionRun(a(c)))
  })

  def fromPro(s: String, p: Pro.M[Boolean]): CheckBox = make(s, p()).I(_.bind(p))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
