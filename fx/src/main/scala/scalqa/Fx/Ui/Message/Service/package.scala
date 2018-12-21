package scalqa; package Fx; package Ui; package Message

package object Service {

  val Console: Service = console

  private object console extends Service { def publish(m: Message) { System.out.println(m); m.causeOpt(System.out.println) } }

}
