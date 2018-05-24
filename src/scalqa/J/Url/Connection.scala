package scalqa; package J; package Url

class Connection(val base: java.net.URLConnection) {

  def openOutput: Output = Output.get(base.getOutputStream)

  def openInput: Input = Input.get(base.getInputStream)

  def requestPro(key: String): Pro.W[String] = new Pro.W[String] {
    def apply: String = base.getRequestProperty(key)
    def update(v: String) { base.setRequestProperty(key, v) }
    base.setDoOutput(true);

  }

  def doInput: Boolean = base.getDoInput; def doInput_=(v: Boolean) { base.setDoInput(v) }

  def doOutput: Boolean = base.getDoOutput; def doOutput_=(v: Boolean) { base.setDoOutput(v) }

  def connectTimeout: Time.Length = base.getConnectTimeout.Seconds; def connectTimeout_=(t: Time.Length) { base.setConnectTimeout(t.totalSeconds.toInt) }

  def readTimeout: Time.Length = base.getReadTimeout.Seconds; def readTimeout_=(t: Time.Length) { base.setReadTimeout(t.totalSeconds.toInt) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
