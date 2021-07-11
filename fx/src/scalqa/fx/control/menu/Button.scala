package scalqa; package fx; package control; package menu; import language.implicitConversions

class Button extends control.Button.Base:
  private def this(text: String, n: Fx.Node.Like) = { this(); _createRealOverride(new REAL(text, n.real)) }
  protected type REAL = javafx.scene.control.MenuButton
  protected override def _createReal = new REAL

  def items: Idx.M[Item] = Idx.M.wrap(real.getItems).mutableMap_^[Item]

object Button:
  def apply()                                           : Button = new Button
  def apply(text: String, n: Fx.Node.Like)              : Button = new Button(text, n)
  def apply(text: String, n: Fx.Node.Like, it: ~[Item]) : Button = apply(text, n).^(_.items ++= it)
  def apply(text: String)                               : Button = apply(text, null)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
