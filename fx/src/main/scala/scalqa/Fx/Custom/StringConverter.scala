package scalqa; package Fx; package Custom

object StringConverter {

  def apply[A](bm: BiMap[A, String]): javafx.util.StringConverter[A] = new javafx.util.StringConverter[A] {

    def toString(a: A) = bm(a); def fromString(s: String) = bm.undo(s)

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
