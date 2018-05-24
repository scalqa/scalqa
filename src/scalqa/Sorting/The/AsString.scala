package scalqa; package Sorting; package The

object AsString extends Z.Default[Any] {

  protected def position(x: Any, y: Any) = Position.getByInt(x.toString.compareTo(y.toString))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *   @object AsString ->
 *
 *     This [[Sorting]] can be applied to anything.
 *
 *     It compares results of universal method ''toString'' on two objects
 *
 */
