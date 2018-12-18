package scalqa; package Lookup; package Z; package A

private[scalqa] class Void extends Lookup[Nothing, Nothing] with scalqa.Void {

  def size = 0

  def getOpt(key: Nothing): Opt[Nothing] = \/

  /*override*/ def apply(key: Nothing): Nothing = App.Fail()

  def allPairs = \/

}

private[scalqa] object Void extends Void
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
