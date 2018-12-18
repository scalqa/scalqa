package scalqa; package Util; package Random

trait Source {

  def int: Int

  def fractionOfOne: Double

}

private[scalqa] object Source {

  // *******************************************************************************************
  object TheJava extends java.util.Random(Time.now.totalMillis % Util.Time.Z.MillisInOneDay toLong) with Source {

    def int = nextInt

    def fractionOfOne = nextDouble
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def int: -> Random Int from 0 to Int.MaxValue
 *
 * @def fractionOfOne: -> Random Double from 0 to 1 exclusive
 */
