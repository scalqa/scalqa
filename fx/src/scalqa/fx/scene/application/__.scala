package scalqa; package fx; package scene; import Application.*; import language.implicitConversions

import javafx.stage.{ Stage => JStage }

abstract class Application(width: Int.Opt, height: Int.Opt, private val title: String=VOID, private val show: Boolean = true, verbose: Boolean = true) :
  self =>
  def this(title: String, show: Boolean, verbose: Boolean)  = this(VOID,VOID,title,show,verbose)
  def this(title: String, show: Boolean)                    = this(title,show,true)
  def this(title: String)                                   = this(title,true)
  def this()                                                = this("")
  protected       val eventStore            : Event.Store   = new Event.Store()
  protected       def arguments             : Pack[String]  = stage.args
  protected       def lazySetup[U](f: => U) : Event.Control = eventStore.onEvent0(UiReadyEvent, () => f)
  protected       def onStop[U](l: () => U) : Event.Control = eventStore.onEvent0(StopEvent, l)
  /**/            def isStopped             : Boolean       = stage.stopped

  /**/      lazy  val stage                 : Stage         = new Stage()
  /**/      lazy  val scene                 : Fx.Scene      = Fx.Scene(width,height,View)
  /**/      lazy  val View                  : Fx.Node.Like

  def main(sa: Array[String]) =
    Application.self = this
    stage.args       = sa.stream.pack
    javafx.application.Application.launch(classOf[z_Starter], sa.toSeq *)

  // *************************************************************************************
  protected class Stage extends Fx.Stage():
    /**/                 def scene              : Fx.Scene     = self.scene
    private[Application] var args               : Pack[String] = null
    private[Application] var stopped            : Boolean      = false
    private[fx]          def stop               : Unit         = { stopped = true; self.eventStore.fireEvent0(StopEvent) }
    private[fx]          def start(s: JStage)   : Unit         = {
      _createRealOverride(s);
      s.setTitle(self.title);
      real.setScene(scene.real);
      self.eventStore.fireEvent0(UiReadyEvent);
      if (self.show) this.show
    }

object Application:
  private object UiReadyEvent
  private object StopEvent
  private[fx] var self: Application = null

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Thread = application.Thread

private class z_Starter extends javafx.application.Application:
  override def start(s: JStage) = Application.self.stage.start(s)
  override def stop()           = Application.self.stage.stop

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class Application -> A convenient way to create GUI main executable class

     ```
       object MyApp extends Fx.Application:
          lazy val  View = Fx.Label("Hello")
     ```

     @param title application window title
     @param show  if `true`, `stage.show` will auto run
     @param verbose if true, console prints application name, start, and end time

@val View -> Application view

     Usually this "lazy val" is implemented as an object

     ```
     object MyApp extends Fx.Application:

       object View extends Fx.Pane.Flow:
         children += Fx.Label("Hello")
     ```
*/
