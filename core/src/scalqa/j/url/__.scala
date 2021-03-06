package scalqa; package j; import language.implicitConversions

import J.Url

object Url extends Any.Ref.Custom.Type[Url,java.net.URL]("Url"):
  /**/     inline def apply(inline v: java.net.URL)            : Url    = v.asOpaque[Url]
  /**/     inline def apply(inline v: String)                  : Url    = apply(java.net.URL(v))
  /**/            def apply(c: Class[_], resourceName: String) : Url    = { val v = c.getResource(resourceName); if(v != null) apply(v) else J.illegalState("Resourse: '" + resourceName +"' is no available within class: " + c.getName)}
  override        def tag(v:Url)                               : String = v.real.toExternalForm
  implicit inline def implicitFromReal(inline v: java.net.URL) : Url    = apply(v)

  extension (inline x: Url)
    inline def host                            : String         = x.real.getHost
    inline def port                            : Int            = x.real.getPort
    inline def openConnection                  : Url.Connection = Url.Connection(x.real.openConnection)
    inline def openInput                       : J.Input        = J.Input(x.real.openStream)
    inline def readString                      : String         = x.openInput.asText.readAllAndClose
    inline def readString(timeOut: Time.Length): String         = Z.readString(x,timeOut)

  object opaque:
    opaque type `type` <: Opaque.Ref = java.net.URL & Opaque.Ref

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Connection = url.Connection.opaque.`type`; transparent inline def Connection = url.Connection

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Url]] is an opaque value, backed by java.net.URL

*/