package scalqa; package gen; package time; import language.implicitConversions

object Zone extends Able.Info:

  val Id     : java.time.ZoneId = java.time.ZoneId.systemDefault
  val Offset : Time.Length      = java.time.Instant.ofEpochMilli(0).atZone(Id).getOffset.getTotalSeconds.Seconds
  def info   : Info             = Info("Time.Zone") += ("Id", Id) += ("Offset", Offset)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
