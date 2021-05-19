package scalqa; package fx; package control; package table; package column; import language.implicitConversions

transparent trait _properties[ROW,V,A]:
  self: Column[ROW,V,A] =>

  @tn("id_Pro")            def id_*                        : String.Pro.OM       = Fx.JavaFx.As.pro_OM(real.idProperty)
  /**/                     def id                          : String              = real.getId
  /**/                     def id_=(v: String)             : Unit                = real.setId(v)
  @tn("visible_Pro")       def visible_*                   : Boolean.Pro.OM      = Fx.JavaFx.As.pro_OM(real.visibleProperty)
  /**/                     def visible                     : Boolean             = real.isVisible
  /**/                     def visible_=(b: Boolean)       : Unit                = real.setVisible(b)
  @tn("label_Pro")         def label_*                     : String.Pro.OM       = Fx.JavaFx.As.pro_OM(real.textProperty)
  /**/                     def label                       : String              = real.getText
  /**/                     def label_=(v: String)          : Unit                = real.setText(v)
  @tn("maxWidth_Pro")      def maxWidth_*                  : Double.Pro.OM       = Fx.JavaFx.As.pro_OM(real.maxWidthProperty)
  /**/                     def maxWidth                    : Double              = real.getMaxWidth
  /**/                     def maxWidth_=(v: Double)       : Unit                = real.setMaxWidth(v)
  @tn("minWidth_Pro")      def minWidth_*                  : Double.Pro.OM       = Fx.JavaFx.As.pro_OM(real.minWidthProperty)
  /**/                     def minWidth                    : Double              = real.getMinWidth
  /**/                     def minWidth_=(v: Double)       : Unit                = real.setMinWidth(v)
  @tn("prefWidth_Pro")     def prefWidth_*                 : Double.Pro.OM       = Fx.JavaFx.As.pro_OM(real.prefWidthProperty)
  /**/                     def prefWidth                   : Double              = real.getPrefWidth
  /**/                     def prefWidth_=(v: Double)      : Unit                = real.setPrefWidth(v)
  @tn("width_Pro")         def width_*                     : Double.Pro.O        = Fx.JavaFx.As.pro_O(real.widthProperty)
  /**/                     def width                       : Double              = real.getWidth
  /**/                     def width_=(v: Double)          : Unit                = { /*maxWidth = v; minWidth = v;*/ prefWidth = v; }
  @tn("graphic_Pro")       def graphic_*                   : Pro.OM[Node.Like]   = Fx.JavaFx.As.pro_OM(real.graphicProperty).mutableMap_^[Node.Like]
  /**/                     def graphic                     : Node.Like           = Node.Like(real.getGraphic)
  /**/                     def graphic_=(g: Node.Like)     : Unit                = real.setGraphic(g.real)
  @tn("ordering_Pro")      def ordering_*                  : Pro.OM[Ordering[A]]
  /**/                     def ordering                    : Ordering[A]         = self.ordering_*()
  /**/                     def ordering_=(o: Ordering[A])  : Unit                = self.ordering_*() = o
  @tn("sortable_Pro")      def sortable_*                  : Boolean.Pro.OM
  /**/                     def sortable                    : Boolean             = self.sortable_*()
  /**/                     def sortable_=(b: Boolean)      : Unit                = self.sortable_*() = b

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
