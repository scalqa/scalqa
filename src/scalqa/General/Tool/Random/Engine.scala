package scalqa; package General.Tool.Random

trait Engine {

  def int: Int

  def oneFraction: Double

}

private[scalqa] object Engine {

  // *******************************************************************************************
  object TheJava extends java.util.Random(Time.currentMillis % Time.Length.MillisOfDay) with Engine {

    def int = nextInt

    def oneFraction = nextDouble
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def int: -> Random Int from 0 to Int.Max
 *
 * @def oneFraction: -> Random Double from 0 to 1 exclusive
 */
