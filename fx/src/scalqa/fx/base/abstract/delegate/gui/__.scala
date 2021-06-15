package scalqa; package fx; package base; package `abstract`; package delegate; import gui.*; import language.implicitConversions

import javafx.beans.property.{ ObjectProperty => OP }
import javafx.event.{ Event => E , EventHandler => EH }

trait Gui extends Gen.Event.Store.Provider:
  protected     type REAL <: AnyRef
  private       var realOpt                                           : Opt[REAL]         = \/
  protected     def _createReal                                       : REAL
  protected     def _createRealOverride(real: => REAL)                : Unit              = eventStore.setProperty_?(Gui.CreateRealOverrideEvent, () => real)
  protected     def _onRealCreated[U](f: REAL => U)                   : Gen.Event.Control     = eventStore.onEvent1(Gui.RealCreatedEvent, f).limitRunsTo(1)
  protected[fx] def _onFxEvent[T<:E,U]  (p:OP[EH[T]], l: () => U)     : Gen.Event.Control     = _onFxEvent[T,U](p, Gen.Event.Id.map1[T,U](l, _ => l()))
  protected[fx] def _onFxEvent[T<:E,M,U](p:OP[EH[T]], as:T=>M,l: M=>U): Gen.Event.Control     = _onFxEvent[T,U](p, Gen.Event.Id.map1[T,U](l, new Z.MappedEvent(as,l)))
  protected[fx] def _onFxEvent[T<:E,U](  p:OP[EH[T]], l: T => U)      : Gen.Event.Control     = {val s=eventStore; if(p.get==null) p.set(new Z.EventDispatch[T,U](s,p)); s.setupEvent(p,l)}
  private  [fx] def _refPropertyOpt                                   : Opt[OP[_ <:EH[_]]]= \/
  /**/          def scene_?                                           : Opt[Scene]
  override      def toString                                          : String            = this.^.id + (realOpt.map(_.toString.takeFrom("[", "")) or "")

  final def real: REAL = realOpt or synchronized { // cannot use lazy val, it fails on recursive calls
    realOpt or {
      try {
        val r = eventStore.removeProperty_?[() => REAL](Gui.CreateRealOverrideEvent).map(_()) or _createReal
        realOpt = r
        _refPropertyOpt.map(_.cast[OP[EH[E]]]).forval(p => p.set(Z.RefEventDispatch(this,eventStore,p)))
        eventStore.fireEvent1(Gui.RealCreatedEvent,r)
        r
      } catch {
        case t: Throwable => { println("Exception in Fx setup for " + this.^.id); throw t }
      }
    }
  }

object Gui:
  private object CreateRealOverrideEvent
  private object RealCreatedEvent

  def apply[A <: Delegate.Gui](p: OP[_ <: EH[_]]): A = p.get.cast[gui.Z.RefEventDispatch].gui.cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Gui -> ###

@def real -> JavaFX peer

       Returns the real JavaFX peer, which makes GUI happen

       JavaFx controls can be manipulated directly, especially for functionality not implemented in ScalqaFx
*/
