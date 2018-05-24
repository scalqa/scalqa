package scalqa; package Any; package Value; package Ref; package Companion

abstract class Convertible[REF <: Ref[VAL], VAL <: AnyRef: Tag] protected (realNull: VAL = null) extends Companion[REF, VAL](realNull) {

  import scala.language.implicitConversions

  implicit def zzGet(v: VAL): REF = get(v)

  implicit def zzVal(v: REF): VAL = undo(v)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
