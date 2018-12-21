package scalqa; package Fx; package Scene

class _Class(width: Opt[Double] = \/, height: Opt[Double] = \/, e: Opt[A.Node.Like] = \/) extends A.Delegate.Gui {
  def this(e: Opt[A.Node.Like]) = this(-1, -1, e)
  protected type REAL = javafx.scene.Scene

  _onAfterCreateGuiRun { Style.Default.all.map(_.toString).foreach(real.getStylesheets.add(_)) }

  // --------------------------------------------------------------------------------------------------
  protected def _createGui = new javafx.scene.Scene(e.map(_.real.asInstanceOf[javafx.scene.Parent]) or null, width or -1, height or -1)

  // --------------------------------------------------------------------------------------------------
  def window: Window._Class = Window.make(real.getWindow)

  def root: A.Parent = A.Node.Map(real.getRoot).asInstanceOf[A.Parent]; def root_=(p: A.Parent) = real.setRoot(p.real)

  // ------------------------------------------------------------------------------------------------
  def onKeyPressed(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyPressedProperty)
  def onKeyReleased(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyReleasedProperty)
  def onKeyTyped(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyTypedProperty)

  private[Fx] override def _referencePropertyOpt = real.onZoomFinishedProperty.Opt

}

object _Class {

  implicit def zzMake(v: \/) = new Scene(Label.make("void")) with Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
