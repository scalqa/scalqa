package scalqa; package fx; package base; import language.implicitConversions

import javafx.scene.control.{ MultipleSelectionModel => MSM, SelectionModel, SelectionMode }

sealed class Selection[A](val target: Idx[A], val real: SelectionModel[_ <: Any]) extends Idx.Selection.Observable[A]:
  type THIS_TYPE = Selection[A]
  /**/     lazy  val indexes                    : Idx[Int]          = real match { case v: MSM[_] => Idx.wrap(v.getSelectedIndices).mapView(_.intValue); case v => z_TwoWay}
  /**/           def mode                       : Selection.Mode    = real match { case v: MSM[_] if v.getSelectionMode == SelectionMode.MULTIPLE => Selection.Mode.Multiple; case _ => Selection.Mode.Single}
  /**/           def mode_=(v: Selection.Mode)  : Unit              = real match { case m: MSM[_] => m.setSelectionMode(v.real); case _ => () }
  /**/           def onChange[U](f:THIS_TYPE=>U): Gen.Event.Control = z_Event(f)
  /**/           def clear                      : Unit              = real.clearSelection
  /**/           def selectAt(i: Int)           : Unit              = real.select(i)
  /**/           def select(a: A)               : Unit              = target.stream.foreachIndexed((i,v) => if(v==a) selectAt(i))
  @tn("map_View")def mapView[B](f: A => B)        : Selection[B]      = new Selection[B](target.mapView(f), real)

  // *********************************************************************************************************************************
  private object z_TwoWay extends Idx[Int]:
    def size = if (real.getSelectedIndex < 0) 0 else 1
    def apply(i: Int) = { assert(i == 0); real.getSelectedIndex }

  private class z_Event[U](f: Selection[A] => U) extends Gen.Event.Control.X.Basic(f) with javafx.beans.InvalidationListener:
    def invalidated(o: javafx.beans.Observable) = targetOpt.forval(_(Selection.this))
    onCancel(() => real.selectedIndexProperty.removeListener(this))
    real.selectedIndexProperty.addListener(this)

object Selection:
  def apply[A](x: Idx[A], m: SelectionModel[_ <: Any]) : Selection[A] = new Selection[A](x, m)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Mode = selection.Mode; transparent inline def Mode = selection.Mode

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
