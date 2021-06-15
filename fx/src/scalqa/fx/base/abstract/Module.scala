package scalqa; package fx; package base; package `abstract`; import language.implicitConversions

abstract class Module extends Node.Like:
  private[fx] override def _refPropertyOpt = real.onZoomFinishedProperty

object Module:
  def apply[T <: Module](r: javafx.scene.Node) : T                                 = Delegate.Gui(r.onZoomFinishedProperty)

  given FxConverter: ReversibleFunction[javafx.scene.Node, Module]  = ReversibleFunction(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
