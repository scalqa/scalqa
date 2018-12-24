package scalqa; package Fx; package Ui; package Message; package Service

trait _Trait {

  def publish(m: Message): Unit

  def publish(t: Type, text: Any*): Unit = publish(Message.make(t, text: _*))

  def publishInfo(text: Any*): Unit = publish(Message.make(Type.Info, text: _*))

  def publishWarning(text: Any*): Unit = publish(Message.make(Type.Warning, text: _*))

  def publishError(text: Any*): Unit = publish(Message.make(Type.Error, text: _*))

  def publishException(t: Throwable): Unit = {
    t.printStackTrace
    publishError(t.getMessage.I.Opt or t.getClass.getName)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
