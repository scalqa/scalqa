package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Add[A] extends Event[A]("Add"):
  def items                   : Idx[A]
  def convert[B](f: A => B)   : Add[B]      = Add(range, items.mapView(f))
  def projectOpt(i: Int.Range): Opt[Add[A]] = i.overlapOpt(range).map(oi => Add[A](oi, items.rangeView(oi << range.start)))
  override def doc            : Doc         = super.doc += ("item" +? (items.size != 1) ? "s", items.stream.makeString(","))

object Add:
  def apply[A](i: Int, items: Idx[A])       : Add[A] = Z.Add[A](i <>= items.size, items)
  def apply[A](i: Int.Range,  items: Idx[A]): Add[A] = { assert(i.size == items.size); Z.Add[A](i, items) }
  def apply[A](i: Int,  item: A)            : Add[A] = Z.Single.Add[A](i, item)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
