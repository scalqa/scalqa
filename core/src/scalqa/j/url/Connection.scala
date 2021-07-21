package scalqa; package j; package url; import language.implicitConversions

import Url.Connection

object Connection extends Any.Ref.Custom.Type[Connection,java.net.URLConnection]("Url"):
  inline def apply(inline v: java.net.URLConnection): Connection = v.asOpaque[Connection]

  extension (inline x: Connection)
    inline def openOutput                             : J.Output       = J.Output(x.real.getOutputStream)
    inline def openInput                              : J.Input        = J.Input(x.real.getInputStream)
    inline def doInput                                : Boolean        = x.real.getDoInput;
    inline def doInput_=(inline v: Boolean)           : Unit           = x.real.setDoInput(v)
    inline def doOutput                               : Boolean        = x.real.getDoOutput;
    inline def doOutput_=(inline v: Boolean)          : Unit           = x.real.setDoOutput(v)
    inline def connectTimeout                         : Time.Length    = x.real.getConnectTimeout.Seconds;
    inline def connectTimeout_=(inline t: Time.Length): Unit           = { x.real.setConnectTimeout(t.secondsTotal.toInt) }
    inline def readTimeout                            : Time.Length    = x.real.getReadTimeout.Seconds;
    inline def readTimeout_=(inline t: Time.Length)   : Unit           = x.real.setReadTimeout(t.secondsTotal.toInt)
  extension (x: Connection)
    /**/   def requestProperty(key: String)           : Pro.M[String]  = zProperty(x.real,key)

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