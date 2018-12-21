package scalqa; package Fx; package Ui; package Message; package Service

trait Default extends Service {

  def publish(m: Message) = Default.publish(m)

}

object Default extends Service {

  private var services = Console.I.to[Refs]

  def publish(m: Message) = services.all(_.publish(m))

  def addMessageService(s: Service) = { if (services(0) == Console) services = \/; services += s }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
