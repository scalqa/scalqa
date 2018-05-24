package scalqa; package Able

trait Refresh extends Any {

  protected def refresh: Any

}

object Refresh {

  def apply(a: Any): Unit = a match { case u: Refresh => u.refresh; case _ => () }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Refresh -> '''Generic Refresh'''
 *
 * @def refresh -> Request refresh
 *
 *     Method is called to notify this object on the need to refresh
 *
 *
 *
 */
