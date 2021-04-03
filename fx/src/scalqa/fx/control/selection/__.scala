package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.{ MultipleSelectionModel => MSM, SelectionModel, SelectionMode }

sealed class Selection[A](val target: Idx[A], val real: SelectionModel[_ <: Any]) extends Idx.Selection.Observable[A]:
  type THIS_TYPE = Selection[A]
  /**/     lazy  val indexes                    : Idx[Int]       = real match { case v: MSM[_] => Idx.javaList_^(v.getSelectedIndices).fun_^(_.intValue); case v => zIndexes}
  /**/           def mode                       : Selection.Mode = real match { case v: MSM[_] if v.getSelectionMode == SelectionMode.MULTIPLE => Selection.Mode.Multiple; case _ => Selection.Mode.Single}
  /**/           def mode_=(v: Selection.Mode)  : Unit           = real match { case m: MSM[_] => m.setSelectionMode(v.real); case _ => () }
  /**/           def onChange[U](f:THIS_TYPE=>U): Event.Control  = zEvent(f)
  /**/           def clear                      : Unit           = real.clearSelection
  /**/           def set(i: Int)                : Unit           = real.select(i)
  /**/           def select(a: A)               : Unit           = target.~.findPosition_?(_ == a).forval(set(_))
  @tn("fun_View")def fun_^[B](f: A => B)        : Selection[B]   = new Selection[B](target.fun_^(f), real)

  // *********************************************************************************************************************************
  private object zIndexes extends Idx[Int]:
    def size = if (real.getSelectedIndex < 0) 0 else 1
    def apply(i: Int) = { assert(i == 0); real.getSelectedIndex }

  private class zEvent[U](f: Selection[A] => U) extends Event.Control.X.Basic(f) with javafx.beans.InvalidationListener:
    def invalidated(o: javafx.beans.Observable) = target_?.forval(_(Selection.this))
    onCancel(() => real.selectedIndexProperty.removeListener(this))
    real.selectedIndexProperty.addListener(this)

object Selection:
  def apply[A](x: Idx[A], m: SelectionModel[_ <: Any]) : Selection[A] = new Selection[A](x, m)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Mode = selection.Mode; val Mode = selection.Mode

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
