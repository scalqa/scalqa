package scalqa; package fx; package control; import language.implicitConversions

class CheckBox extends Button.Base:
  protected type REAL = javafx.scene.control.CheckBox
  protected override def _createReal = new REAL

  def selectedPro                       : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.selectedProperty)
  def selected                          : Boolean         = real.isSelected
  def selected_=(b: Boolean)            : Unit            = real.setSelected(b)

  def onActionSelectedRun  (f: => Unit) : Event.Control   = onActionRun{if (selected) f}
  def onActionUnselectedRun(f: => Unit) : Event.Control   = onActionRun{if (!selected) f}
  def bind(p: Pro.M[Boolean])           : Unit            = { selected = p()
                                                              p.?.takeType[Boolean.Pro.OM ].forval(_.onChangeRun(selectedPro() = p()))
                                                              onActionRun(p()= selected) }
object CheckBox:
  def apply(s: String, p: Pro.M[Boolean])  : CheckBox = apply(s, p()).self(_.bind(p))
  def apply()                              : CheckBox = new CheckBox
  def apply[U](text: Opt[String]  =VOID,
            checked: Opt[Boolean] =VOID,
            action : CheckBox => U=VOID)   : CheckBox = new CheckBox().self(c => { text.forval(c.text= _); checked.forval(c.selected= _); action.self(a => c.onActionRun(a(c))) })


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
