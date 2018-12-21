package scalqa; package Fx; package A; package Delegate

trait _Trait extends Any {
  protected type REAL <: AnyRef

  def real: REAL

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def real: -> JavaFX peer
 *
 *     Returns the real JavaFX peer, which makes GUI happen
 *
 *     It can be manipulated directly
 */
