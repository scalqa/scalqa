package scalqa; package Fx; package Ui; package Message

package object Service {

  val Console: Service = console

  private object console extends Service { def publish(m: Message): Unit = { System.out.println(m); m.causeOpt(System.out.println) } }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
