package scalqa; package Util; package Deficiency

class Error(val error: Throwable) extends Deficiency(error.getMessage)

object Error {

  def apply(t: Throwable) = new Error(t)

  def unapply(v: Error): Option[Throwable] = Some(v.error)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class Error -> Deficiency indicating failure due to error with Exception
 *
 *
 */
