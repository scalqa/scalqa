package scalqa; package J; package Input; package Z

private[Input] trait Variety extends Able.Close {

  def input: J.Input

  def close: Unit

}

private[Input] object Variety {

  class Companion[THIS <: Variety] {

    implicit def zzInput(v: Variety) = v.input

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def input -> Input
 *
 *    [[Input]] used to create this
 *
 * @def close -> Close input
 *
 *    Closes parent input
 */
