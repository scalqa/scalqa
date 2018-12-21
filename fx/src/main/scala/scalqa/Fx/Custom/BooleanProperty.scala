package scalqa; package Fx; package Custom

object BooleanProperty {

  def apply(p: Pro.OM[Boolean]): javafx.beans.property.BooleanProperty = new javafx.beans.property.BooleanPropertyBase {
    {
      bind(ObservableValue(p.asMappedView((b: Boolean) => b: java.lang.Boolean)))
    }
    def getBean(): AnyRef = "NoBean"
    def getName: String = "NoName"
    override def set(v: Boolean) = p() = v;
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
