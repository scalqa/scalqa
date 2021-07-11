package scalqa; package fx; package control; package menu; package item

import javafx.scene.control.{ CustomMenuItem => JCustomMenuItem }

class Custom extends control.Menu.Item:
  def this(n: Fx.Node.Like, hideOnClick: Boolean = true) = { this();  _createRealOverride(new JCustomMenuItem({ if (n == null) null else n.real }, hideOnClick)) }

  protected type REAL = JCustomMenuItem
  protected override def _createReal = new REAL

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
