package scalqa; package Util; package Time

package object Z {

  private[scalqa] val MillisInOneSecond = 1000L
  private[scalqa] val MillisInOneMinute = MillisInOneSecond * 60
  private[scalqa] val MillisInOneHour = MillisInOneMinute * 60
  private[scalqa] val MillisInOneDay = MillisInOneHour * 24
  private[scalqa] val MillisInOneWeek = MillisInOneDay * 7

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
