package scalqa; package Fx

package object Stage {

  def make(titleOpt: Opt[String], w: Int, h: Int, e: A.Node.Like): Stage = new Stage(new javafx.stage.Stage) {

    titleOpt(title = _)

    val scene = new Scene(w, h, e)

  }
}
