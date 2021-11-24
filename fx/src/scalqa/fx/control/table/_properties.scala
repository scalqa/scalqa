package scalqa; package fx; package control; package table; import language.implicitConversions

transparent trait _properties[ROW]:
  self: Table[ROW] =>

  /**/       def itemsPro                        : Pro.OM[Idx.OM[ROW]]            = rowData.itemsPro
  /**/       def items                           : Idx.OM[ROW]                    = itemsPro()
  /**/       def items_=(l: Idx[ROW])            : Unit = itemsPro()               = Idx.OM.wrap(l)
  /**/       def sortModePro                     : Pro.OM[SortMode]               = rowData.sortModePro
  /**/       def sortMode                        : SortMode                       = sortModePro()
  /**/       def sortMode_=(v: SortMode)         : Unit                           = sortModePro() = v
  @fast lazy val orderingPro                     : Pro.OM[Ordering[ROW]]          // = Pro.OM.X.Basic[Ordering[ROW]](\/)
  /**/       def ordering                        : Ordering[ROW]                  = self.orderingPro()
  /**/       def ordering_=(v: Ordering[ROW])    : Unit                           = self.orderingPro() = v
  @fast lazy val sortingBasePro                  : Pro.OM[Ordering[ROW]]          // = Pro.OM.X.Basic[Ordering[ROW]](\/)
  /**/       def sortingBase                     : Ordering[ROW]                  = self.sortingBasePro()
  /**/       def sortingBase_=(v: Ordering[ROW]) : Unit                           = self.sortingBasePro() = v
  /**/       def headerFooterPro                 : Pro.OM[(Pack[ROW], Pack[ROW])] = rowData.headerFooterPro
  /**/       def headerFooter                    : (Pack[ROW], Pack[ROW])         = headerFooterPro()
  /**/       def headerFooter_=(hf:(Stream[ROW],
                                    Stream[ROW])): Unit = headerFooterPro()        = (hf._1.pack, hf._2.pack)
  /**/       def editablePro                     : Boolean.Pro.OM                 = Fx.JavaFx.To.pro_OM(real.editableProperty)
  /**/       def editable                        : Boolean                        = real.isEditable
  /**/       def editable_=(b: Boolean)          : Unit                           = real.setEditable(b)
  /**/       def placeholderPro                  : Pro.OM[Fx.Node]                = Fx.JavaFx.To.pro_OM(real.placeholderProperty).mutableMapView[Fx.Node]
  /**/       def placeholder                     : Fx.Node                        = placeholderPro()
  /**/       def placeholder_=(v: Fx.Node)       : Unit                           = real.setPlaceholder(v.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
