package scalqa; package fx; package control; import language.implicitConversions

class CheckBox extends Button.Base:
  protected type REAL = javafx.scene.control.CheckBox
  protected override def _createReal = new REAL

  @tn("selected_Pro") def selected_*                        : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.selectedProperty)
  /**/                def selected                          : Boolean         = real.isSelected
  /**/                def selected_=(b: Boolean)            : Unit            = real.setSelected(b)

  /**/                def onActionSelectedRun  (f: => Unit) : Event.Control   = onActionRun{if (selected) f}
  /**/                def onActionUnselectedRun(f: => Unit) : Event.Control   = onActionRun{if (!selected) f}
  /**/                def bind(p: Pro.M[Boolean])           : Unit            = { selected = p()
                                                                                  p.?.takeType[Boolean.Pro.OM ].forval(_.onChangeRun(selected_*() = p()))
                                                                                  onActionRun(p()= selected) }
object CheckBox:
  def apply(s: String, p: Pro.M[Boolean])  : CheckBox = apply(s, p()).^(_.bind(p))
  def apply()                              : CheckBox = new CheckBox
  def apply[U](text: String.Opt    = \/,
            checked: Opt[Boolean]  = \/,
            action : CheckBox => U = \/)   : CheckBox = new CheckBox().^(c => { text.forval(c.text= _); checked.forval(c.selected= _); action.^(a => c.onActionRun(a(c))) })


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
