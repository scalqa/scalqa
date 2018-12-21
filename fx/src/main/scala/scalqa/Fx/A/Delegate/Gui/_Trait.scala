package scalqa; package Fx; package A; package Delegate; package Gui

trait _Trait extends _eventBase with Any.Ref.Extra.Property {
  protected type REAL <: AnyRef
  private var fxOpt: Opt[REAL] = \/

  final def real: REAL = fxOpt or synchronized {
    if (fxOpt.isVoid)
      try {
        fxOpt = _removePropertyOpt[() => REAL](_Trait.OnCreateFx).map(_()).default(_createGui)
        _referencePropertyOpt(r => r.set(new Z.EventHandlerRef(this, r.I.asInstanceOfTarget).I.asInstanceOfTarget))
        _fireEvent0(_Trait.OnAfterCreateFx)
      } catch {
        case t: Throwable => {
          ("Exception in Fx setup for " + this.I.Class.name).lp
          throw t
        }
      }
    fxOpt.value
  }

  protected def _createGui: REAL //= App.Fail("_onCreateFx not defined")

  protected def _onCreateGuiRun(real: => REAL) = _setPropertyOpt(_Trait.OnCreateFx, () => real)

  protected def _onAfterCreateGuiRun(f: => Any) = _onEvent0(_Trait.OnAfterCreateFx, () => f).limitRunsTo(1)

  // --------------------------------------------------------------------------------------------------
  private[Fx] def _referencePropertyOpt: Opt[javafx.beans.property.ObjectProperty[_ <: javafx.event.EventHandler[_]]] = \/

}

private object _Trait { object OnCreateFx; object OnAfterCreateFx }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *
 * @def real: -> JavaFX peer
 *
 *     Returns the real JavaFX peer, which makes GUI happen
 *
 *     It can be manipulated directly
 */
