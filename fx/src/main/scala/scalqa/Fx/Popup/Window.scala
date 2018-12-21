package scalqa; package Fx; package Popup

class Window extends Fx.Window {
  protected type REAL <: javafx.stage.PopupWindow

  lazy val scene = new Scene

  lazy val delayPro: Pro.OM[Duration] = Pro.OM.make(\/); def delay = delayPro(); def delay_=(v: Duration) = delayPro() = v

  lazy val targetWindowOptPro: Pro.OM[Opt[Fx.Window]] = Pro.OM.make(\/); def targetWindowOpt = targetWindowOptPro(); def targetWindowOpt_=(v: Opt[Fx.Window]) = targetWindowOptPro() = v

  def show(n: A.Parent, x: Double, y: Double) = { scene.root = n; real.show(n.real, x, y) }

  def show(w: Fx.Window, x: Double, y: Double) = real.show(w.real, x, y)

  def show(w: Fx.Window) = real.show(w.real)

  def show: Unit = targetWindowOpt(show) or App.Fail("targetWindowOptPro is not set, run show with target")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
