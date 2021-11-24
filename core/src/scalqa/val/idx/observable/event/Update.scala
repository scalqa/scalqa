package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Update[A] extends Event[A]("Update"):
  def isRefresh               : Boolean
  def items                   : Idx[A]
  def oldItems                : Idx[A]
  def convert[B](f: A => B)   : Update[B]      = if (isRefresh) { val it = items.mapView(f); Update.refresh(range, it) }  else Update(range, items.mapView(f), oldItems.mapView(f))
  def projectOpt(r: Int.Range): Opt[Update[A]] = r.overlapOpt(range).map(i =>  if (isRefresh) Update.refresh[A](i, items.rangeView(i << range.start))
    /**/                                                                       else Update(i, items.rangeView(i << range.start), oldItems.rangeView(i << range.start)))
  override def doc            : Doc            = super.doc += ("items", items.stream.makeString(",")) += ("oldItems", if (isRefresh) "Refresh" else oldItems.stream.makeString(","))

object Update:
  def refresh[A](r: Int.Range,  items: Idx[A])                : Update[A] = Z.Update[A](r, items, items)
  def refresh[A](i: Int, item : A)                            : Update[A] = Z.Single.Update[A](i, item, item)
  def apply[A](  i: Int, items: Idx[A], oldItems: Idx[A])     : Update[A] = { val sz = oldItems.size; assert(sz == items.size); Z.Update[A](i <>= sz, items, oldItems) }
  def apply[A](  r: Int.Range, items:Idx[A],oldItems: Idx[A]) : Update[A] = { val sz = r.size; assert(sz == oldItems.size && sz == items.size); Z.Update[A](r, items, oldItems) }
  def apply[A](  i: Int, item : A, oldItem: A)                : Update[A] = Z.Single.Update[A](i, item, oldItem)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

