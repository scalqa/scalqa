package scalqa; package Index; package O; package Change

trait Reposition[A] extends Coll.O.Change[A] with Int.Range.Reposition {

  final def name = "Reposition"

  protected override def info = super.info ~ ("name", name) ~ ("range", range) ~ ("index", indexes.all)

}

object Reposition {

  def get[A](r: Int.Range, indexes: Ints): Reposition[A] = new Z.Reposition[A](r, indexes)

  def get[A](r: Int.Range.Reposition): Reposition[A] = get(r.range, r.indexes)

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
