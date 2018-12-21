package scalqa; package Fx; package Stage

abstract class _Class(stage: Opt[javafx.stage.Stage] = \/) extends Window._Class {

  protected type REAL = javafx.stage.Stage;

  protected override def _createGui = stage.or(new javafx.stage.Stage) //.I(_.setScene(scene.real))

  def show = real.show

  def titlePro: Pro.OM[String] = Custom.ProWO(real.titleProperty); def title = real.getTitle; def title_=(v: String) = real.setTitle(v)

  lazy val icons: Idx.M[Image] = Idx.M.wrap(real.getIcons).asBiMappedView(Image.Map)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
