package scalqa; package Custom; package Number

class Scale(val value: Int) extends AnyVal {

  override def toString = "Scale:" + value

}

object Scale {

  implicit def zzMake(scale: Int) = new Scale(scale)

  implicit def zzDefault(v: DEFAULT.type): Scale = dflt

  private lazy val dflt = App.Setup.CustomNumberScalePro()
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
