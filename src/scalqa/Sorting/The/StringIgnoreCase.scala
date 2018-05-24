package scalqa; package Sorting; package The

object StringIgnoreCase extends Z.Default[String] {

  protected def position(x: String, y: String) = Position.getByInt(x.compareToIgnoreCase(y))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
