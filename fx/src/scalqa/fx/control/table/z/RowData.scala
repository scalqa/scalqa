package scalqa; package fx; package control; package table; package z; import language.implicitConversions

private[fx] class RowData[A](table: Table[A]) extends J.Util.Proxy.Idx.OM[A] with Event.Store.Provider with (Pack[Idx.O.Event[A]] => Any):
  protected var real =  Idx.OM[A]().self(_.onChange(Event.Id.make1(this, this)))

  lazy  val itemsPro       : Pro.OM[Idx.OM[A]]          = Pro.OM.X.Basic(real).self(_.onChangeRun(resetRows))
  lazy  val headerFooterPro: Pro.OM[(Pack[A], Pack[A])] = Pro.OM.X.Basic[(Pack[A], Pack[A])]((VOID, VOID)).self(_.onChangeRun(resetRows))
  lazy  val sortModePro    : Pro.OM[SortMode]           = Pro.OM(SortMode.Direct).self(p => p.onChangeRun({resetRows; table.columns.stream.foreach(c => c.sortable = p().nonVoid && c.ordering.nonVoid) }))

  override def onChange[U](l: Pack[Idx.O.Event[A]] => U) = eventStore.onEvent1(RowData.ChangeEvent, l)

  def apply(v: Pack[Idx.O.Event[A]]) = eventStore.fireEvent1(RowData.ChangeEvent, v)

  private def resetRows: Unit =
    val old = real
    real = itemsPro()
    if (sortModePro().isProxy) real = IdxProxy(real)(using VOID)
    if ({ val v = headerFooterPro(); !v._1.isEmpty || !v._2.isEmpty }) real = new HeaderFooter(headerFooterPro(), real)
    if (old != real)
      old.onChange(Event.Id.cancel1(this))
      eventStore.fireEvent1(RowData.ChangeEvent, Pack(Idx.Event.Remove(0 <>> old.size, old), Idx.Event.Add(0 <>> real.size, real)))
      real.onChange(Event.Id.make1(this, this))

private object RowData:
  private object ChangeEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
