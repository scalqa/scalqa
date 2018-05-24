package scalqa; package String; package Like

abstract class Companion[VAL <: Like] protected extends Any.Value.Ref.Companion.Convertible[VAL, String](\/) {

  def get(v: String): VAL

  import scala.language.implicitConversions

  implicit def zzLibrary(v: VAL) = new String._library._Class(v.value)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Companion ->
 *
 *   Companion object type required to be implemented for each new [[String.Like]] type
 *
 */
