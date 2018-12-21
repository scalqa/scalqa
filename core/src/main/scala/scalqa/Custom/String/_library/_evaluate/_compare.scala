package scalqa; package Custom; package String; package _library; package _evaluate

trait _compare[TYPE] extends Any with Comparable[String] with Any.Datum[TYPE, String] {

  def compareTo(that: String) = real.compareTo(that)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
