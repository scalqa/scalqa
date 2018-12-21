package scalqa; package Idx; package O; package Change

trait Reposition[A] extends Change[A] with Idx.Range.Reposition {

  final def name = "Reposition"

  override def toInfo = new Pro.Info(this, name) += ("range", range) += ("indexes", this.allPairs.format())

}

object Reposition {

  def make[A](r: Idx.Range, indexes: Ints): Reposition[A] = new Z.Reposition[A](r, indexes)

  def make[A](r: Idx.Range.Reposition): Reposition[A] = make(r.range, r.indexes)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def name -> "Reposition"
 *
 *     Returns "Reposition"
 *
 */
