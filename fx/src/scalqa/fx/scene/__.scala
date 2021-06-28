package scalqa; package fx; import language.implicitConversions

import javafx.{ scene as JFX}
import base.`abstract`.Parent

class Scene(width: Int.Opt = \/, height: Int.Opt = \/, e: Opt[Node.Like] = \/) extends Abstract.Delegate.Gui:
  protected type REAL = JFX.Scene
  protected def _createReal = new JFX.Scene(e.map(_.real.cast[JFX.Parent]) or control.Label("No Root").real, width or -1, height or -1)
  _onRealCreated(real => Style.Default.~.map(_.toString).foreach(real.getStylesheets.add(_)))
  private[fx] override def _refPropertyOpt = real.onZoomFinishedProperty

  def scene_?                             : Opt[Scene]      = this
  def window                              : Window          = Window(real.getWindow)
  def root                                : Parent          = Node.FxConverter(real.getRoot).cast[Parent]; def root_=(p: Parent) = real.setRoot(p.real)
  def onKeyPressed [U](l: Fx.Event.Key => U) : Unit            = Fx.Event.Key.subscribe(this, l, real.onKeyPressedProperty)
  def onKeyReleased[U](l: Fx.Event.Key => U) : Unit            = Fx.Event.Key.subscribe(this, l, real.onKeyReleasedProperty)
  def onKeyTyped   [U](l: Fx.Event.Key => U) : Unit            = Fx.Event.Key.subscribe(this, l, real.onKeyTypedProperty)
  val styleSheets                         : Idx.OM[J.Url]   = Fx.JavaFx.To.idx_OM(real.getStylesheets).mutableMap_^(J.Url(_), _.toString)

object Scene extends Gen.Void.Setup[Scene](new Scene(\/, \/, Control.Label("void")) with Gen.Void):
  def apply(r: JFX.Scene)                                                      : Scene = Abstract.Delegate.Gui(r.onZoomFinishedProperty)
  def apply(width: Int.Opt = \/, height: Int.Opt = \/, e: Opt[Node.Like] = \/) : Scene = new Scene(width, height, e)
  def apply(e: Opt[Node.Like])                                                 : Scene = apply(\/,\/, e)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @fast lazy val Application = scene.Application;          type Application  = scene.Application
  @fast lazy val Chart       = scene.Chart;                type Chart        = scene.Chart
  @fast lazy val Image       = scene.Image;                type Image        = scene.Image.opaque.`type`
  @fast lazy val Paint       = scene.Paint;                type Paint        = scene.Paint.opaque.`type`
  @fast lazy val Pane        = scene.Pane;                 type Pane         = scene.Pane
  @fast lazy val Shape       = scene.Shape;                type Shape        = scene.Shape
  @fast lazy val Stage       = scene.Stage;                type Stage        = scene.Stage
  @fast lazy val Window      = scene.Window;               type Window       = scene.Window


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Scene -> ### GUI Layout

   [[Scene]] object also contains types responsible for building GUI layout, except for widgets (which are defined in [[scalqa.fx.Control Fx.Control]])

   All the [[Scene]] children are aliased in [[Fx]] root and usually called without `Scene.` prefix

   For example:
   ```
   val w: Fx.Scene.Window = ?_?_?
   // is usually defined as
   val w: Fx.Window = ?_?_?

   val b: Fx.Scene.Pane.Border = ?_?_?
   // is usually defined as
   val b: Fx.Pane.Border = ?_?_?
   ```
 */
