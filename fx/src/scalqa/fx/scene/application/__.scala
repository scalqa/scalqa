package scalqa; package fx; package scene; import Application.*; import language.implicitConversions

import javafx.stage.{ Stage => JStage }

abstract class Application(width: Int.Opt, height: Int.Opt, private val title: String = \/, private val show: Boolean = true, verbose: Boolean = true) :
  self =>
  def this(title: String, show: Boolean, verbose: Boolean)  = this(\/,\/,title,show,verbose)
  def this(title: String, show: Boolean)                    = this(title,show,true)
  def this(title: String)                                   = this(title,true)
  def this()                                                = this("")
  protected       val eventStore            : Event.Store   = new Event.Store()
  protected       def arguments             : String.><     = stage.args
  protected       def lazySetup[U](f: => U) : Event.Control = eventStore.onEvent0(UiReadyEvent, () => f)
  protected       def onStop[U](l: () => U) : Event.Control = eventStore.onEvent0(StopEvent, l)
  /**/            def isStopped             : Boolean       = stage.stopped

  /**/      lazy  val stage                 : Stage         = new Stage()
  /**/      lazy  val scene                 : Fx.Scene      = Fx.Scene(width,height,View)
  protected lazy  val View                  : Node.Like

  def main(sa: Array[String]) =
    Application.self = this
    stage.args       = sa.~.><
    javafx.application.Application.launch(classOf[zStarter], sa.toSeq *)

  // *************************************************************************************
  protected class Stage extends Fx.Stage():
    /**/                 def scene              : Fx.Scene         = self.scene
    private[Application] var args               : ><[String] = null
    private[Application] var stopped            : Boolean          = false
    private[fx]          def start(s: JStage)   : Unit             = { _createRealOverride(s);

      s.setTitle(self.title);

      real.setScene(scene.real);

      self.eventStore.fireEvent0(UiReadyEvent);

      if (self.show) this.show }
    private[fx]          def stop               : Unit             = { stopped = true; self.eventStore.fireEvent0(StopEvent) }

object Application:
  private object UiReadyEvent
  private object StopEvent
  private[fx] var self: Application = null
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Thread = application.Thread

private class zStarter extends javafx.application.Application:
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
       object MyApp extends fx.Application {

         scene = "Hello World"

       }
     ```
     @param title application window title
     @param show  if `true`, `stage.show` will auto run
     @param verbose if true, console prints application name, start, and end time



@val` stage -> Stage

       Current [[fx.Stage]]


@def scene -> Scene to create

     The `scene` must be assigned within [[fx.Application]] code

     Generally [[fx.Scene]] is expected

     However for simple cases anything can be assigned with default scene auto created

     ```
       {
         scene = "Hello World"

         // gets translated to

         scene = fx.Label("Hello World")

         // gets translated to

         scene = fx.Scene(600, 400, fx.Pane.Border.withCenter(Fx.Label("Hello World")))
       }
     ```

*/
