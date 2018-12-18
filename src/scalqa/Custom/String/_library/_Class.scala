package scalqa; package Custom; package String; package _library

class _Class private[scalqa] (protected val real: String) extends AnyVal with _evaluate._Trait[String] with _modify[String] with _substring[String] with _transform[String] {

  @inline protected def make(v: String) = v
  @inline private[String] def undo(v: String) = v

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
