package scalqa; package fx; package control; package menu; import language.implicitConversions

class Bar extends Control:
  protected type REAL = javafx.scene.control.MenuBar
  protected override def _createReal = new REAL

object Bar:
  def apply()               : Bar = Bar()
  def apply(s: Stream[Menu]): Bar = Bar().self(b => s.foreach(m => b.real.getMenus.add(m.real)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
