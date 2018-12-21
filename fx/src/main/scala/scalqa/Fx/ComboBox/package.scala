package scalqa; package Fx

package object ComboBox {

  def make[A](p: ~[A] = \/, selected: Opt[A] = \/, action: ComboBox[A] => Any = \/): ComboBox[A] = new ComboBox[A].I(c => {
    c.items +~= p
    selected(c.selection.select(_))
    action.I.Opt(a => c.onActionRun(a(c)))
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
