package scalqa; package Time

object Zone {

  val Id = java.time.ZoneId.systemDefault

  val Offset: Time.Length = java.time.Instant.ofEpochMilli(0).atZone(Id).getOffset.getTotalSeconds.Seconds

  //val Offset: Time.Length = -6.Hours

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
