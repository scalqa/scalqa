package scalqa; package Fx; package Ui

package object Message {
  type Service = Service._Trait

  def make(t: Type, mess: Any*): Message = new Message(t, mess.all.format(", "))

  def info(mess: Any*) = make(Type.Info, mess: _*)

  def warning(text: Any*) = make(Type.Warning, text: _*)

  def error(text: Any*) = make(Type.Error, text: _*)

  def error(t: Throwable) = new Message(Type.Error, t.getMessage, t)

  def error(text: String, t: Throwable) = new Message(Type.Error, text, t)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
