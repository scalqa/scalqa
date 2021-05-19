package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.{ Menu => FxMenu }

class Menu extends Menu.Item with Able.Add[ui.Action]:
  def this(text: String, enabled: Boolean = true) = { this(); _createRealOverride(new FxMenu(text).cast[REAL]); this.enable = enabled }
  protected type REAL <: FxMenu
  protected override def _createReal: REAL = new FxMenu().cast[REAL]

  lazy val items             : Idx.M[Menu.Item] = Idx.M.wrap(real.getItems).mutableMap_^[Menu.Item]
  /**/ def add(a: ui.Action) : Unit             = items += Menu.Item(a)


object Menu:
  def apply()                                         : Menu = new Menu()
  def apply(text: String, enabled: Boolean = true)    : Menu = new Menu(text, enabled)
  def apply(text: String, n: Node.Like)               : Menu = this(text).^(_.graphic_*() = n)
  def apply(text: String, n: Node.Like, its: ~[Item]) : Menu = this(text, n).^(_.items ++= its)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Item   = menu.Item;    inline def Item   = menu.Item
  type Bar    = menu.Bar;     inline def Bar    = menu.Bar
  type Button = menu.Button;  inline def Button = menu.Button

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
