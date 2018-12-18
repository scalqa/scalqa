package scalqa; package Any; package Itself; package Z

private[Itself] object toString {

  def apply(v: Any): String = v match {
    case ()   => ""
    case null => "null"
    case v    => v.toString
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
