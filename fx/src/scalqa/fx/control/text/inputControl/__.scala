package scalqa; package fx; package control; package text; import language.implicitConversions

import InputControl.Change

abstract class InputControl(initialTextO: Opt[String]=VOID) extends Control:
  protected type REAL <: javafx.scene.control.TextInputControl
  private var _onChange: Pack[Change => Any]=VOID;
  {
    initialTextO.forval(t => _onRealCreated(_ => text = t))
  }

  def size                        : Int             = real.getLength
  def end                         : Unit            = real.end
  def +=(s: String)               : Unit            = real.appendText(s)
  def onChange[U](l: Change => U) : Unit            = { _onChange += l; if (!real.getTextFormatter.isInstanceOf[z_Formatter[_]]) real.setTextFormatter(new z_Formatter) }

  def editablePro                 : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.editableProperty)
  def editable                    : Boolean         = real.isEditable
  def editable_=(b: Boolean)      : Unit            = real.setEditable(b)
  def caretPositionPro            : Int.Pro.O       = Fx.JavaFx.To.pro_O(real.caretPositionProperty)
  def caretPosition               : Int             = real.getCaretPosition
  def textPro                     : Pro.OM[String]  = Fx.JavaFx.To.pro_OM(real.textProperty)
  def text                        : String          = real.getText
  def text_=(v: String)           : Unit            = real.setText(v)

  // ***********************************************************************************
  import javafx.scene.control.TextFormatter.{ Change => FXC }
  private class z_Formatter[A] extends javafx.scene.control.TextFormatter[A](new java.util.function.UnaryOperator[FXC] { def apply(c: FXC) = { _onChange.stream.foreach(_(Change(c))); c } })

object InputControl:
  type Change = inputControl.Change.TYPE.DEF; transparent inline def Change = inputControl.Change

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
