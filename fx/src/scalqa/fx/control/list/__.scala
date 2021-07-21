package scalqa; package fx; package control

class List[A] extends Control:
  protected type REAL <: javafx.scene.control.ListView[A]
  protected override def _createReal: REAL = new javafx.scene.control.ListView[A]().cast[REAL]

  @fast lazy val items     : Idx.M[A]        = Idx.M.wrap(real.getItems)
  @fast lazy val selection : Fx.Selection[A] = Fx.Selection(items, real.getSelectionModel)

object List:
  def apply[A](): List[A] = new List()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
