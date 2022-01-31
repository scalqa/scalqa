package scalqa; package fx; package control; package table; package column; import language.implicitConversions

transparent trait _properties[ROW,V,A]:
  self: Column[ROW,V,A] =>

  /**/       def idPro                       : Pro.OM[String]      = Fx.JavaFx.To.pro_OM(real.idProperty)
  /**/       def id                          : String              = real.getId
  /**/       def id_=(v: String)             : Unit                = real.setId(v)
  /**/       def visiblePro                  : Boolean.Pro.OM      = Fx.JavaFx.To.pro_OM(real.visibleProperty)
  /**/       def visible                     : Boolean             = real.isVisible
  /**/       def visible_=(b: Boolean)       : Unit                = real.setVisible(b)
  /**/       def labelPro                    : Pro.OM[String]      = Fx.JavaFx.To.pro_OM(real.textProperty)
  /**/       def label                       : String              = real.getText
  /**/       def label_=(v: String)          : Unit                = real.setText(v)
  /**/       def maxWidthPro                 : Double.Pro.OM       = Fx.JavaFx.To.pro_OM(real.maxWidthProperty)
  /**/       def maxWidth                    : Double              = real.getMaxWidth
  /**/       def maxWidth_=(v: Double)       : Unit                = real.setMaxWidth(v)
  /**/       def minWidthPro                 : Double.Pro.OM       = Fx.JavaFx.To.pro_OM(real.minWidthProperty)
  /**/       def minWidth                    : Double              = real.getMinWidth
  /**/       def minWidth_=(v: Double)       : Unit                = real.setMinWidth(v)
  /**/       def prefWidthPro                : Double.Pro.OM       = Fx.JavaFx.To.pro_OM(real.prefWidthProperty)
  /**/       def prefWidth                   : Double              = real.getPrefWidth
  /**/       def prefWidth_=(v: Double)      : Unit                = real.setPrefWidth(v)
  /**/       def widthPro                    : Double.Pro.O        = Fx.JavaFx.To.pro_O(real.widthProperty)
  /**/       def width                       : Double              = real.getWidth
  /**/       def width_=(v: Double)          : Unit                = { /*maxWidth = v; minWidth = v;*/ prefWidth = v; }
  /**/       def graphicPro                  : Pro.OM[Fx.Node.Like]= Fx.JavaFx.To.pro_OM(real.graphicProperty).mutableMapView[Fx.Node.Like]
  /**/       def graphic                     : Fx.Node.Like        = Fx.Node.Like(real.getGraphic)
  /**/       def graphic_=(g: Fx.Node.Like)  : Unit                = real.setGraphic(g.real)
  @fast lazy val orderingPro                 : Pro.OM[Ordering[A]] = Pro.OM(VOID)
  /**/       def ordering                    : Ordering[A]         = self.orderingPro()
  /**/       def ordering_=(o: Ordering[A])  : Unit                = self.orderingPro() = o
  @fast lazy val sortablePro                 : Boolean.Pro.OM      = Fx.JavaFx.To.pro_OM(real.sortableProperty)
  /**/       def sortable                    : Boolean             = self.sortablePro()
  /**/       def sortable_=(b: Boolean)      : Unit                = self.sortablePro() = b

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
