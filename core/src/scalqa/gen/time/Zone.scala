package scalqa; package gen; package time; import language.implicitConversions

object Zone extends Able.Doc:

  val id     : java.time.ZoneId = java.time.ZoneId.systemDefault
  val offset : Time.Length      = java.time.Instant.ofEpochMilli(0).atZone(id).getOffset.getTotalSeconds.Seconds
  def doc    : Doc              = Doc("Time.Zone") += ("id", id) += ("offset", offset)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
