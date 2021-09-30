package scalqa; package fx; package control; package toggle; import language.implicitConversions

import javafx.scene.control.ToggleGroup

class Group:
  object real extends ToggleGroup { setUserData(Group.this) }

  /**/                val items             : Idx.M[Toggle] = Idx.M.wrap(real.getToggles).mutableMap_^[Toggle]
  /**/                def add(v: Toggle)    : Unit          = items add v
  /**/                def select(v: Toggle) : Unit          = real.selectToggle(v.real)
  @tn("selected_Pro") def selected_*        : Pro.O[Toggle] = Fx.JavaFx.To.pro_O(real.selectedToggleProperty).map_^(Toggle.FxConverter)
  /**/                def selected          : Toggle        = Toggle.FxConverter(real.getSelectedToggle)

object Group:
  def apply()           : Group = new Group()
  def apply(b: Button*) : Group = apply().^(_.items ++= b)

  given FxConverter: TwoWayFunction[ToggleGroup, Group] = TwoWayFunction(_.getUserData.cast[Group],_.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
