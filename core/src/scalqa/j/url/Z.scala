package scalqa; package j; import language.implicitConversions

object Z:

  def readString(x: J.Url, timeOut: Time.Length): String =
    x.openConnection.self(c => {
      c.connectTimeout = timeOut
      c.readTimeout    = timeOut
      c.doOutput       = true
      c.requestProperty("Content-Type").update("application/x-www-form-urlencoded")
    }).openInput.asText.readAllAndClose

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
