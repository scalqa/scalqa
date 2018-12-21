package scalqa; package Fx; package Text; package InputControl

abstract class _Class(initialText: Opt[String]) extends A.Control {
  protected type REAL <: javafx.scene.control.TextInputControl

  {
    initialText(t => _onAfterCreateGuiRun(text = t))
  }

  def size = real.getLength

  def editablePro: Pro.OM[Boolean] = Custom.ProWO(real.editableProperty); def editable = real.isEditable; def editable_=(b: Boolean) = real.setEditable(b)

  def caretPositionPro = Fx.Custom.ProO(real.caretPositionProperty); def caretPosition = real.getCaretPosition

  def end = real.end

  def textPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def text = real.getText; def text_=(v: String) = real.setText(v)

  def +=(s: String) = real.appendText(s)

  protected def onObservableChange(on: Change => Any) { _onChange += on; if (!real.getTextFormatter.isInstanceOf[Formatter[_]]) real.setTextFormatter(new Formatter) }
  private var _onChange: Refs[Change => Any] = \/

  /*
    // -----------------------------------
    public <T> scalqa.O.Pro.O<T> createView(J.F.Lookup<String, T> m) {
      TextFormatter<?> old = real().getTextFormatter();
      if (old instanceof Formatter && ((Formatter) old).view != null) throw new scalqa.E.IllegalState("Z already created.");
      Formatter<T> f = new Formatter<>(this, m);
      real().setTextFormatter(f);
      return f.view();
    }
   */

  // *************************************************************************************************
  import javafx.scene.control.TextFormatter.{ Change => FXC }

  private class Formatter[A] extends javafx.scene.control.TextFormatter[A](new java.util.function.UnaryOperator[FXC] { def apply(c: FXC) = { _onChange.all(_(Change.make(c))); c } }) {
    //      private scalqa.O.Pro.O<A> view;
    //      public scalqa.O.Pro.O<A> view() {
    //        if (view == null) scalqa.L.toDo();// view = new scalqa.O.Pro.O.C.make(valueProperty());
    //        return view;
    //      }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
