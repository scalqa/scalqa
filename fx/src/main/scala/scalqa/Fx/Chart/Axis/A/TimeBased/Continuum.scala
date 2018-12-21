package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased

trait Continuum extends BiMap[Time, Double] {

  def isDefined(t: Time): Boolean

  def nextDefined(t: Time): Time

  def priorDefined(t: Time): Time

}

object Continuum {

  object RealTime extends Continuum {
    def apply(t: Time) = t.totalMillis.toDouble;
    def undo(d: Double) = Time.fromMillis(d.toLong)
    def isDefined(t: Time) = true
    def nextDefined(t: Time) = t
    def priorDefined(t: Time) = t
  }

  object _9to5 extends Continuum {
    def apply(t: Time) = t.totalMillis.toDouble;
    def undo(d: Double) = Time.fromMillis(d.toLong)
    def isDefined(t: Time) = true
    def nextDefined(t: Time) = t
    def priorDefined(t: Time) = t
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
