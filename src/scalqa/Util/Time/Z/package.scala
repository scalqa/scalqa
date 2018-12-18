package scalqa; package Util; package Time

package object Z {

  private[scalqa] val MillisInOneSecond = 1000L
  private[scalqa] val MillisInOneMinute = MillisInOneSecond * 60
  private[scalqa] val MillisInOneHour = MillisInOneMinute * 60
  private[scalqa] val MillisInOneDay = MillisInOneHour * 24
  private[scalqa] val MillisInOneWeek = MillisInOneDay * 7

}
