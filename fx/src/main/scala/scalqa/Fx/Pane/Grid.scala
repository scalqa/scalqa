package scalqa; package Fx; package Pane

class Grid extends Pane {
  protected type REAL = javafx.scene.layout.GridPane
  protected override def _createGui = new REAL

  def alignmentPro = Custom.ProWO(real.alignmentProperty).asBiMappedView(Pos); def alignment: Pos = real.getAlignment; def alignment_=(v: Pos) = real.setAlignment(v)

  def hGapPro: Pro.OM[Double] = Custom.ProWO(real.hgapProperty); def hGap = real.getHgap; def hGap_=(b: Double) = real.setHgap(b)

  def vGapPro: Pro.OM[Double] = Custom.ProWO(real.vgapProperty); def vGap = real.getVgap; def vGap_=(b: Double) = real.setVgap(b)

  // -----------------------
  def add(rowIndex: Int, columnIndex: Int, rowspan: Int, colspan: Int, child: Fx.A.Node.Like) = real.add(child.real, columnIndex, rowIndex, colspan, rowspan)

  def add(rowIndex: Int, columnIndex: Int, rowspan: Int, colspan: Int, s: String): Unit = add(rowIndex, columnIndex, rowspan, colspan, Fx.Label.make(s))

  // -----------------------
  def add(rowIndex: Int, columnIndex: Int, child: Fx.A.Node.Like) = real.add(child.real, columnIndex, rowIndex)

  def add(rowIndex: Int, columnIndex: Int, s: String): Unit = add(rowIndex, columnIndex, Fx.Label.make(s))

  // -----------------------
  def add(rowIndex: Int, columnIndex: Int, s: String, child: Fx.A.Node.Like): Unit = { add(rowIndex, columnIndex, s); add(rowIndex, columnIndex + 1, child) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
