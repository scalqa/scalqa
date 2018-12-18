package scalqa; package App

object Thread {

  def real = java.lang.Thread.currentThread

  def id: Long = real.getId

  def name: String = real.getName

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Thread -> `Current Thread`
 *
 *    Convenience access to `java.lang.Thread.currentThread`
 *
 * @def id -> Identifier
 *
 *    Current thread identifier
 *
 * @def name -> Name
 *
 *    Current thread name
 *
 */
