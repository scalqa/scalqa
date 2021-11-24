package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Remove[A] extends Event[A]("Remove"):
  def items                   : Idx[A]
  def convert[B](f: A => B)   : Remove[B]      = Remove(range, items.mapView(f))
  def projectOpt(i: Int.Range): Opt[Remove[A]] = i.overlapOpt(range).map(oi => Remove[A](oi, items.rangeView(oi << range.start)))
  override def doc            : Doc            = super.doc += ("item" +? (items.size != 1) ? "s", items.stream.makeString(","))

object Remove:
  def apply[A](i: Int, items: Idx[A])       : Remove[A] = Z.Remove[A](i <>= items.size, items)
  def apply[A](i: Int.Range,  items: Idx[A]): Remove[A] = if(i.size == items.size) Z.Remove[A](i, items) else J.illegalArgument("Range:" +- i +" does not match item count:"+items.size)
  def apply[A](i: Int, item:  A)            : Remove[A] = Z.Single.Remove[A](i, item)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

