package scalqa; package J; package Url

class _Class protected[Url] (val real: java.net.URL) extends java.io.Serializable {

  def host: String = real.getHost

  def port: Int = real.getPort

  def openConnection = new Connection(real.openConnection)

  def openInput = Input.get(real.openStream)

  def readString: String = openInput.asText.readAllAndClose

  def readString(timeOut: Time.Length): String = openConnection.I(c => {
    c.connectTimeout = timeOut
    c.readTimeout = timeOut
    c.doOutput = true
    c.requestPro("Content-Type").update("application/x-www-form-urlencoded")
  }).openInput.asText.readAllAndClose

  override def toString = real.toExternalForm

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzGet(v: java.net.URL) = new Url(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
