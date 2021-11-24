package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.{ Menu => FxMenu }

class Menu extends Menu.Item with Able.Add[base.Action]:
  def this(text: String, enabled: Boolean = true) = { this(); _createRealOverride(new FxMenu(text).cast[REAL]); this.enable = enabled }
  protected type REAL <: FxMenu
  protected override def _createReal: REAL = new FxMenu().cast[REAL]

  lazy val items               : Idx.M[Menu.Item] = Idx.M.wrap(real.getItems).mutableMapView[Menu.Item]
  /**/ def add(a: base.Action) : Unit             = items += Menu.Item(a)


object Menu:
  def apply()                                                : Menu = new Menu()
  def apply(text: String, enabled: Boolean = true)           : Menu = new Menu(text, enabled)
  def apply(text: String, n: Fx.Node.Like)                   : Menu = this(text).self(_.graphicPro() = n)
  def apply(text: String, n: Fx.Node.Like, its: Stream[Item]): Menu = this(text, n).self(_.items ++= its)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Item   = menu.Item;     transparent inline def Item   = menu.Item
  type Bar    = menu.Bar;      transparent inline def Bar    = menu.Bar
  type Button = menu.Button;   transparent inline def Button = menu.Button

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
