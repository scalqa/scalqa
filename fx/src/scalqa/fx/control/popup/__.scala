package scalqa; package fx; package control; import language.implicitConversions

class Popup extends Popup.Window:
  protected type REAL = javafx.stage.Popup
  protected override def _createReal: REAL = new REAL

  @fast lazy val children: Idx.M[Node.Like] =  Idx.M.wrap(real.getContent).mutableMap_^[Node.Like]

object Popup:

  def promise(promise: Val.Promise[Any], message: Any, delay: Gen.Time.Length, target: fx.Window): Unit =
    val p = message match
      case p: Popup => p
      case v        => new Popup { children += v.toString }
    var done = false
    promise.onResult(_ => done = true)
    def show = { p.show(target); promise.onResult(_ => p.hide)(using fx.Thread) }
    if (delay.nonVoid) Thread.scheduleIn(delay, if (!done) show)
    else Thread(show)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Control = popup.Control
  type Menu    = popup.Menu;    inline def Menu    = popup.Menu
  type Window  = popup.Window



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
