package scalqa; package Fx

package object Button {

  def make(s: String): Button = makeAct(s, \/)

  def make(s: String, action: => Any): Button = makeAct(s, (b: Button) => action)

  def makeAct(s: String = \/, action: Button => Any = \/): Button = new Button().I(b => {
    s.I.Opt(b.text= _)
    action.I.Opt(f => b.onActionRun(f(b)))
  })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
