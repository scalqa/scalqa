package scalqa; package Custom; package Number; package Z

private[Number] object Ordering extends Ordering[Number] {

  def compare(x: Number, y: Number) = java.lang.Double.compare(x.doubleValue, y.doubleValue)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
