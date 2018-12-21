package scalqa; package Fx; package Text; package Field

class _Class(columns: Opt[Int] = \/, value: Opt[String] = \/) extends InputControl(value)  {
  def this(value: String) = this(\/, value)

    protected type REAL = javafx.scene.control.TextField

  def onActionRun(on: => Any) = _onFxEvent[javafx.event.ActionEvent](real.onActionProperty(), { ae: javafx.event.ActionEvent => on })

  def columnCountPro: Pro.OM[Int] = Custom.ProWO(real.prefColumnCountProperty); def columnCount = real.getPrefColumnCount; def columnCount_=(b: Int) = real.setPrefColumnCount(b)

  
  protected override def _createGui = new REAL().I(f => columns(f.setPrefColumnCount))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
