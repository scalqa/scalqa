package scalqa; package Concurrent

package object Scheduler {

  def getDefault: Scheduler = App.Pro.DefaultScheduler()

  def get(e: java.util.concurrent.ScheduledExecutorService) = new Scheduler(e)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
