package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.{ Toggle => JToggle }

trait Toggle:
  real.setUserData(this)
  def real: JToggle

  @tn("selected_Pro")    def selected_*                    : Boolean.Pro.OM       = Fx.JavaFx.As.pro_OM(real.selectedProperty)
  /**/                   def selected                      : Boolean              = real.isSelected
  /**/                   def selected_=(b: Boolean)        : Unit                 = real.setSelected(b)
  @tn("toggleGroup_Pro") def toggleGroup_*                 : Pro.OM[Toggle.Group] = Fx.JavaFx.As.pro_OM(real.toggleGroupProperty).twoWay_^[Toggle.Group]
  /**/                   def toggleGroup                   : Toggle.Group         = Toggle.Group.FxConverter(real.getToggleGroup)
  /**/                   def toggleGroup_=(v:Toggle.Group) : Unit                 = real.setToggleGroup(v.real)

object Toggle:

  given FxConverter: TwoWayFun[JToggle, Toggle] with
    def apply(v: JToggle) = v.getUserData.cast[Toggle]
    def undo (v: Toggle)  = v.real

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Button = toggle.Button;  inline def Button = toggle.Button
  type Group  = toggle.Group;   inline def Group    = toggle.Group


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/