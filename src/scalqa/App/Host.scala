package scalqa; package App

object Host {

  def name: String = java.net.InetAddress.getLocalHost.getHostName

  def address: String = java.net.InetAddress.getLocalHost.getHostAddress

  def availableProcessors: Int = Runtime.getRuntime().availableProcessors()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
