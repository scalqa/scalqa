package scalqa; package fx; package scene; package pane; package split; import language.implicitConversions

class Divider(val real: javafx.scene.control.SplitPane.Divider) extends Able.Doc:

  @tn("position_Pro") lazy  val position_*            : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.positionProperty)
  /**/                      def position              : Double         = real.getPosition
  /**/                      def position_=(b: Double) : Unit           = real.setPosition(b)
  /**/                      def doc                  : Doc           = Doc(this) += ("position", position)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
