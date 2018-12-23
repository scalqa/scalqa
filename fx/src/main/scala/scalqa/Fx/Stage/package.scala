package scalqa; package Fx

package object Stage {

  def make(titleOpt: Opt[String], w: Int, h: Int, e: A.Node.Like): Stage = new Stage(new javafx.stage.Stage) {

    titleOpt(title = _)

    val scene = new Scene(w, h, e)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
