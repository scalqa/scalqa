package scalqa; package fx; package control; package popup; import language.implicitConversions

class Menu extends Control:
  protected type REAL = javafx.scene.control.ContextMenu
  protected override def _createReal = new REAL

  val items                                          : Idx.M[fx.Menu.Item] = Idx.M.javaList_^(real.getItems).twoWay_^[fx.Menu.Item]
  def show(n: Node, s: Side, x: Double, y: Double) : Unit                = real.show(n.real, s.real, x, y)
  def show(n: Node)                                : Unit                = show(n, RIGHT, 0, 0)

object Menu:

  def apply()                 : Menu = new Menu
  //def apply(p: ~[_ <: Action]): Menu = Menu().^(_.items ++= p.map(fx.Menu.Item.apply))
  def apply(p: ~[Action]): Menu = Menu().^(_.items ++= p.map(fx.Menu.Item.apply))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
