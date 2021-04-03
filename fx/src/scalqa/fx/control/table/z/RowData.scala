package scalqa; package fx; package control; package table; package z; import language.implicitConversions

private[fx] class RowData[A](table: Table[A]) extends J.Util.Proxy.Idx.OM[A] with Event.Store.Provider with (><[Idx.O.Event[A]] => Any):
  protected var real =  Idx.OM[A]().^(_.onChange(Event.Id.make1(this, this)))

  @tn("items_Pro")        lazy  val items_*        : Pro.OM[Idx.OM[A]]          = Pro.OM.X.Basic(real).^(_.onChangeRun(resetRows))
  @tn("headerFooter_Pro") lazy  val headerFooter_* : Pro.OM[(><[A], ><[A])] = Pro.OM.X.Basic[(><[A], ><[A])]((\/, \/)).^(_.onChangeRun(resetRows))
  @tn("sortMode_Pro")     lazy  val sortMode_*     : Pro.OM[SortMode]           = Pro.OM(SortMode.Direct).^(p => p.onChangeRun({resetRows; table.columns.~.foreach(c => c.sortable = p().nonVoid && c.ordering.nonVoid) }))

  override def onChange[U](l: ><[Idx.O.Event[A]] => U) = eventStore.onEvent1(RowData.ChangeEvent, l)

  def apply(v: ><[Idx.O.Event[A]]) = eventStore.fireEvent1(RowData.ChangeEvent, v)

  private def resetRows: Unit =
    val old = real
    real = items_*()
    if (sortMode_*().isProxy) real = IdxProxy(real)(using \/)
    if ({ val v = headerFooter_*(); !v._1.isEmpty || !v._2.isEmpty }) real = new HeaderFooter(headerFooter_*(), real)
    if (old != real)
      old.onChange(Event.Id.cancel1(this))
      eventStore.fireEvent1(RowData.ChangeEvent, ><(Idx.Event.Remove(0 <>> old.size, old), Idx.Event.Add(0 <>> real.size, real)))
      real.onChange(Event.Id.make1(this, this))

private object RowData:
  private object ChangeEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
