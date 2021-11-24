package scalqa; package fx; package scene; package pane; import language.implicitConversions

class Grid extends Pane:
  protected type REAL = javafx.scene.layout.GridPane
  protected override def _createReal = new REAL

  def alignmentPro         : Pro.OM[Pos]    = Fx.JavaFx.To.pro_OM(real.alignmentProperty).mutableMapView[Pos]
  def alignment            : Pos            = real.getAlignment;
  def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)
  def hGapPro              : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.hgapProperty)
  def hGap                 : Double         = real.getHgap
  def hGap_=(b: Double)    : Unit           = real.setHgap(b)
  def vGapPro              : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.vgapProperty)
  def vGap                 : Double         = real.getVgap
  def vGap_=(b: Double)    : Unit           = real.setVgap(b)

  def add(rowIndex: Int, columnIndex: Int, rowspan: Int, colspan: Int, child: Fx.Node.Like): Unit = real.add(child.real, columnIndex, rowIndex, colspan, rowspan)
  def add(rowIndex: Int, columnIndex: Int, rowspan: Int, colspan: Int, s: String)          : Unit = add(rowIndex, columnIndex, rowspan, colspan, Fx.Label(s))
  def add(rowIndex: Int, columnIndex: Int, child: Fx.Node.Like)                            : Unit = real.add(child.real, columnIndex, rowIndex)
  def add(rowIndex: Int, columnIndex: Int, s: String)                                      : Unit = add(rowIndex, columnIndex, Fx.Label(s))
  def add(rowIndex: Int, columnIndex: Int, s: String, child: Fx.Node.Like)                 : Unit = { add(rowIndex, columnIndex, s); add(rowIndex, columnIndex + 1, child) }
  def add(rowIndex: Int, columnIndex: Int, s: String, child: String)                       : Unit = add(rowIndex, columnIndex, s, Label(child))

object Grid:
  def apply() = new Grid

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
