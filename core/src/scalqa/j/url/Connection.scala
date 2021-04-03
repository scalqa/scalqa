package scalqa; package j; package url; import language.implicitConversions

import Url.Connection

object Connection extends Any.Ref.Custom.Type[Connection,java.net.URLConnection]("Url"):
  inline def apply(inline v: java.net.URLConnection): Connection = v.asOpaque[Connection]

  extension (x: Connection)
    def openOutput           : J.Output       = J.Output(x.real.getOutputStream)
    def openInput            : J.Input        = J.Input(x.real.getInputStream)
    def doInput              : Boolean        = x.real.getDoInput;                 def doInput_=(v: Boolean)            : Unit = x.real.setDoInput(v)
    def doOutput             : Boolean        = x.real.getDoOutput;                def doOutput_=(v: Boolean)           : Unit = x.real.setDoOutput(v)
    def connectTimeout       : Time.Length    = x.real.getConnectTimeout.Seconds;  def connectTimeout_=(t: Time.Length) : Unit = { x.real.setConnectTimeout(t.secondsTotal.toInt) }
    def readTimeout          : Time.Length    = x.real.getReadTimeout.Seconds;     def readTimeout_=(t: Time.Length)    : Unit = x.real.setReadTimeout(t.secondsTotal.toInt)
    def request(key: String) : Val.Pro.M[String]  = zProperty(x.real,key)

  object opaque:
    opaque type `type` <: Opaque.Ref = java.io.File & Opaque.Ref

  // ************************************************************************************
  private class zProperty(c: java.net.URLConnection, key: String) extends Val.Pro.M[String]:
    c.setDoOutput(true);
    def apply():  String  = c.getRequestProperty(key)
    def update(v: String) = c.setRequestProperty(key,v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Url.Connection]] is an opaque value, backed by java.net.URLConnection

*/