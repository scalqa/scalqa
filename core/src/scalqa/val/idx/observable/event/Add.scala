package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Add[A] extends Event[A]("Add"):
  /**/               def items                : Idx[A]
  /**/               def convert[B](f: A => B): Add[B]      = Add(range, items.map_^(f))
  @tn("project_Opt") def project_?(i: Int.<>) : Opt[Add[A]] = i.overlap_?(range).map(oi => Add[A](oi, items.range_^(oi << range.start)))
  override           def doc                 : Doc        = super.doc += ("item" ++ (items.size != 1) ? "s", items.~.makeString(","))

object Add:
  def apply[A](i: Int, items: Idx[A]) : Add[A] = Z.Add[A](i <>= items.size, items)
  def apply[A](i: Int.<>,  items: Idx[A]) : Add[A] = { assert(i.size == items.size); Z.Add[A](i, items) }
  def apply[A](i: Int,  item: A)      : Add[A] = Z.Single.Add[A](i, item)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
