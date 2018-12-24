package scalqa; package Fx; package Application

abstract class _Class(title: String = \/, show: Boolean = ON, verbose: Boolean = ON) extends App(verbose) {

  def stage: Stage = _Class

  def scene: Scene = stage.scene;

  def scene_=(v: Any): Unit = v match {
    case s: Scene             => _Class._scene = s
    case e: A.Node.Like       => scene = new Fx.Scene(600, 400, Fx.Pane.Border.withCenter(e))
    case n: javafx.scene.Node => scene = A.Node.make(n)
    case v                    => scene = Label.make(v.I.toString)

  }

  override def main(sa: Array[String]) = {
    _Class._app = this
    _Class._args = sa
    javafx.application.Application.launch(classOf[Starter], sa.toSeq: _*)
  }

  private def superMain(sa: Array[String]): Unit = super.main(sa)
  private def _title = title
  private def _show = show
}

// *****************************************************************************************************
private object _Class extends Fx.Stage() {
  var _app: Application = null
  var _args: Array[String] = null
  var _scene: Scene = null

  lazy val scene = _scene.I.Opt(s => real.setScene(s.real)) or App.Fail("Scene was not set yet")

  def start(s: javafx.stage.Stage): Unit = {
    _onCreateGuiRun(s)
    _app._title.I.Opt(s.setTitle)
    _app.superMain(_args)
    this.scene
    if (_app._show) show
  }
}

// *****************************************************************************************************
private class Starter extends javafx.application.Application { def start(s: javafx.stage.Stage): Unit = _Class.start(s) }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> A convenient way to create GUI main executable class
 *
 *   {{{
 *     object MyApp extends Fx.Application {
 *
 *       scene = "Hello World"
 *
 *     }
 *   }}}
 *   @param title application window title
 *   @param show  if `true`, `stage.show` will auto run
 *   @param verbose if true, console prints application name, start, and end time
 *
 *
 *  @def stage -> Stage
 *
 *     Current [[Fx.Stage]]
 *
 *  @def scene: -> Scene to create
 *
 *   The `scene` must be assigned within [[Fx.Application]] code
 *
 *   Generally [[Fx.Scene]] is expected
 *
 *   However for simple cases anything can be assigned with default scene auto created
 *
 *   {{{
 *     {
 *       scene = "Hello World"
 *
 *       // gets translated to
 *
 *       scene = Fx.Label.make("Hello World")
 *
 *       // gets translated to
 *
 *       scene = new Fx.Scene(600, 400, Fx.Pane.Border.withCenter(Fx.Label.make("Hello World")))
 *     }
 *   }}}
 */
