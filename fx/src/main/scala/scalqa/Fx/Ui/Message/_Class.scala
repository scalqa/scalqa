package scalqa; package Fx; package Ui; package Message

class _Class protected[Message] (val typ: Type, textOpt: Opt[String], val causeOpt: Opt[Throwable] = \/, timeStamp: Time = NOW) extends Any.Ref.Extra.Event0 with Any.Able.ToInfo {

  val timePro = Pro.OM.make[Time](timeStamp); def time = timePro(); def time_=(v: Time) = timePro() = v

  val acknowledgedPro = Pro.OM.make[Boolean](false); def acknowledged = acknowledgedPro(); def acknowledged_=(v: Boolean) = acknowledgedPro() = v

  val contextPro: Pro.OM[String] = new Pro.OM.A.Basic[String](\/) { override def update(v: String) = if (apply.isVoid) super.update(v) };

  def context = contextPro(); def context_=(v: String) = contextPro.update(v)

  val textPro = Pro.OM.make[String](textOpt orOpt causeOpt.letMap(c => c.getMessage.I.Opt orOpt c.I.Class.lastName.I.Opt) or ""); def text = textPro(); def text_=(v: String) = textPro() = v

  def toInfo = new Pro.Info(this) += (("type", typ)) += (("context", context)) += (("text", text)) += (("time", time.toBrief)) += (("acknowledged", acknowledged))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
