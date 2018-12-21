package scalqa; package Pro; package O; package Z; package A

private[Pro] class NoEventsWrap[A](value: A) extends O[A] {

  def apply = value

  def onChange(f: () => Any): EventControl = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/