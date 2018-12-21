package scalqa; package Util; package Deficiency

class Time(message: String) extends Deficiency(message)

object Time {

  def apply(message: String) = new Time(message)

  def unapply(v: Time): Option[String] = Some(v.message)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Time -> Deficiency indicating failure related to insufficient time
 *
 */
