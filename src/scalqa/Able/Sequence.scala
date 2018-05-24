package scalqa; package Able

trait Sequence extends Any {
  protected type TARGET

  protected def _sequenceMove(i: Int): TARGET

  def +(positionsDown: Int) = _sequenceMove(positionsDown)

  def -(positionsUp: Int) = _sequenceMove(-positionsUp)

  def prior = _sequenceMove(-1)

  def next = _sequenceMove(1)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Sequence -> '''Generic Sequence'''
 *
 * @def next -> Next in the sequence.
 *
 *   Returns natural next to ''this'' instance in the sequence.
 *   {{{
 *      // Generic example
 *      Month.get(2017, 12).next.lp // Prints: 2018-01
 *   }}}
 *
 * @def prior -> Previous in the sequence.
 *
 *   Returns natural previous to ''this'' instance in the sequence.
 *   {{{
 *      // Generic example
 *      Month.get(2018, 1).prior.lp // Prints: 2017-12
 *   }}}
 *
 * @def + -> Several ''positionsDown'' the sequence.
 *
 *   {{{
 *      // Generic example
 *      Month.get(2018, 1) + 5.lp // Prints: 2018-06
 *   }}}
 *
 * @def - -> Several ''positionsUp'' the sequence.
 *
 *   {{{
 *      // Generic example
 *      Month.get(2018, 1) - 6.lp // Prints: 2017-07
 *   }}}
 */
