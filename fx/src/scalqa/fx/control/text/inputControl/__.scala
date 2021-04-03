package scalqa; package fx; package control; package text; import language.implicitConversions

import inputControl.Change

abstract class InputControl(initialTextO: String.Opt = \/) extends Control:
  protected type REAL <: javafx.scene.control.TextInputControl
  private var _onChange: ><[Change => Any] = \/;
  {
    initialTextO.forval(t => _onRealCreated(_ => text = t))
  }

  /**/                     def size                        : Int             = real.getLength
  /**/                     def end                         : Unit            = real.end
  /**/                     def +=(s: String)               : Unit            = real.appendText(s)
  /**/                     def onChange[U](l: Change => U) : Unit            = { _onChange += l; if (!real.getTextFormatter.isInstanceOf[Formatter[_]]) real.setTextFormatter(new Formatter) }

  @tn("editable_Pro")      def editable_*                  : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.editableProperty)
  /**/                     def editable                    : Boolean         = real.isEditable
  /**/                     def editable_=(b: Boolean)      : Unit            = real.setEditable(b)
  @tn("caretPosition_Pro") def caretPosition_*             : Int.Pro.O       = Fx.JavaFx.As.pro_O(real.caretPositionProperty)
  /**/                     def caretPosition               : Int             = real.getCaretPosition
  @tn("text_Pro")          def text_*                      : String.Pro.OM   = Fx.JavaFx.As.pro_OM(real.textProperty)
  /**/                     def text                        : String          = real.getText
  /**/                     def text_=(v: String)           : Unit            = real.setText(v)

  /*
    // -----------------------------------
    public <T> scalqa.O._^.O<T> createView(Gen.FxConverter<String, T> m) {
      TextFormatter<?> old = real().getTextFormatter();
      if (old instanceof Formatter && ((Formatter) old).view != null) throw new scalqa.E.IllegalState("Z already created.");
      Formatter<T> f = new Formatter><(this, m);
      real().setTextFormatter(f);
      return f.view();
    }

*/

  import javafx.scene.control.TextFormatter.{ Change => FXC }
  private class Formatter[A] extends javafx.scene.control.TextFormatter[A](new java.util.function.UnaryOperator[FXC] { def apply(c: FXC) = { _onChange.~.foreach(_(Change(c))); c } }) {
    //      private scalqa.O._^.O<A> view;
    //      public scalqa.O._^.O<A> view() {
    //        if (view == null) toDo;// view = new scalqa.O._*.O.C(valueProperty());
    //        return view;
    //      }
  }

object InputControl:
  type Change = inputControl.Change.opaque.`type`; inline def Change = inputControl.Change

package inputControl:
  type Change = inputControl.Change.opaque.`type`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
