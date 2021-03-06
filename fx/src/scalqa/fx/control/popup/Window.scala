package scalqa; package fx; package control; package popup; import language.implicitConversions

abstract class Window extends Fx.Window:
  protected type REAL <: javafx.stage.PopupWindow

  lazy  val scene = Fx.Scene()

  def show(n: Abstract.Parent, x: Double, y: Double): Unit = real.show(n.real, x, y)
  def show(w: Fx.Window, x: Double, y: Double)      : Unit = real.show(w.real, x, y)
  def show(w: Fx.Window)                            : Unit = real.show(w.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
