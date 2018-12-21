package scalqa; package Fx; package Text

class _Class(s: Opt[String]) extends Shape {
  protected def _createGui: REAL = s.map(new REAL(_)) or new REAL

  protected type REAL = javafx.scene.text.Text

  def textPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def text = real.getText; def text_=(v: String) = real.setText(v)

  def fontPro = Custom.ProWO(real.fontProperty).asBiMappedView(Font.Map)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
