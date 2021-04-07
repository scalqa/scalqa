package scalqa; package fx; package control; package table; import language.implicitConversions

transparent trait _properties[ROW]:
  self: Table[ROW] =>

  @tn("items_Pro")            def items_*                             : Pro.OM[Idx.OM[ROW]]            = rowData.items_*
  /**/                        def items                               : Idx.OM[ROW]                    = items_*()
  /**/                        def items_=(l: Idx[ROW])                : Unit = items_*()               = l.observableMutable_^
  @tn("sortMode_Pro")         def sortMode_*                          : Pro.OM[SortMode]               = rowData.sortMode_*
  /**/                        def sortMode                            : SortMode                       = sortMode_*()
  /**/                        def sortMode_=(v: SortMode)             : Unit                           = sortMode_*() = v
  @tn("ordering_Pro")         def ordering_*                          : Pro.OM[Ordering[ROW]]
  /**/                        def ordering                            : Ordering[ROW]                  = self.ordering_*()
  /**/                        def ordering_=(v: Ordering[ROW])        : Unit                           = self.ordering_*() = v
  @tn("sortingBase_Pro")      def sortingBase_*                       : Pro.OM[Ordering[ROW]]
  /**/                        def sortingBase                         : Ordering[ROW]                  = self.sortingBase_*()
  /**/                        def sortingBase_=(v: Ordering[ROW])     : Unit                           = self.sortingBase_*() = v
  @tn("headerFooter_Pro")     def headerFooter_*                      : Pro.OM[(><[ROW], ><[ROW])]     = rowData.headerFooter_*
  /**/                        def headerFooter                        : (><[ROW], ><[ROW])             = headerFooter_*()
  /**/                        def headerFooter_=(hf: (~[ROW], ~[ROW])): Unit = headerFooter_*()        = (hf._1.><, hf._2.><)
  @tn("editable_Pro")         def editable_*                          : Boolean.Pro.OM                 = Fx.JavaFx.As.pro_OM(real.editableProperty)
  /**/                        def editable                            : Boolean                        = real.isEditable
  /**/                        def editable_=(b: Boolean)              : Unit                           = real.setEditable(b)
  @tn("placeholder_Pro")      def placeholder_*                       : Pro.OM[Node]                   = Fx.JavaFx.As.pro_OM(real.placeholderProperty).twoWay_^[Node]
  /**/                        def placeholder                         : Node                           = placeholder_*()
  /**/                        def placeholder_=(v: Node)              : Unit                             = real.setPlaceholder(v.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/