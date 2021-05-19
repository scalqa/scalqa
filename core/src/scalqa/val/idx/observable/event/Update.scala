package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

abstract class Update[A] extends Event[A]("Update"):
  /**/               def isRefresh            : Boolean
  /**/               def items                : Idx[A]
  /**/               def oldItems             : Idx[A]
  /**/               def convert[B](f: A => B): Update[B]      = if (isRefresh) { val it = items.map_^(f); Update.refresh(range, it) }  else Update(range, items.map_^(f), oldItems.map_^(f))
  @tn("project_Opt") def project_?(r: Int.<>) : Opt[Update[A]] = r.overlap_?(range).map(i =>  if (isRefresh) Update.refresh[A](i, items.range_^(i << range.start))
    /**/                                                                                      else Update(i, items.range_^(i << range.start), oldItems.range_^(i << range.start)))
  override           def doc                 : Self.Doc      = super.doc += ("items", items.~.makeString(",")) += ("oldItems", if (isRefresh) "Refresh" else oldItems.~.makeString(","))

object Update:
  def refresh[A](r: Int.<>,  items: Idx[A])                   : Update[A] = Z.Update[A](r, items, items)
  def refresh[A](i: Int, item : A)                            : Update[A] = Z.Single.Update[A](i, item, item)
  def apply[A](  i: Int, items: Idx[A], oldItems: Idx[A])     : Update[A] = { val sz = oldItems.size; assert(sz == items.size); Z.Update[A](i <>= sz, items, oldItems) }
  def apply[A](  r: Int.<>,  items: Idx[A], oldItems: Idx[A]) : Update[A] = { val sz = r.size; assert(sz == oldItems.size && sz == items.size); Z.Update[A](r, items, oldItems) }
  def apply[A](  i: Int, item : A, oldItem: A)                : Update[A] = Z.Single.Update[A](i, item, oldItem)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

