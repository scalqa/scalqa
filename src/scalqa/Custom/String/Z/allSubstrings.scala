package scalqa; package Custom; package String; package Z

private[String] class allSubstrings(val value: String, size: Int) extends Stream.A.Indexed[String] {

  override def _apply(i: Int) = {
    val p = i * size
    value.substring(p, p + size min value.length)
  }

  override def _size = value.length / size + (value.length % size).signum

  override def ilkOpt = Ilk.Objects

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
