package scalqa; package Any; package Able

trait Stream[@specialized(DATA) A] extends Any {

  def all: scalqa.Stream[A]

  def ~ : scalqa.Stream[A] = all

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Stream ->  `Generic Stream provider`
 *
 * @def all -> Stream of elements
 *
 *     Returns `this` container elements as [[Stream]]
 *
 * @def ~ -> Stream of elements operator
 *
 *     Same as `all`
 *
 */
