package scalqa; package Sorting

sealed class Type private extends Any.Enum[Type](Type) {

  def isUp = this == Type.Ascending

  def isDown = this == Type.Descending

  def reverse = if (isUp) Type.Descending else if (isDown) Type.Ascending else this
}

object Type extends Any.Enum.Companion[Type] {
  val Void = new Type with Void
  val Ascending = new Type
  val Descending = new Type

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Type -> Enumeration of
 *     {{{
 *         Sorting.Type.Ascending    // Increasing value
 *
 *         Sorting.Type.Descending   // Decreasing value
 *
 *         Sorting.Type.Void
 *     }}}
 *
 *  @val Ascending -> Up sorting
 *
 *    Indicates sorting where elements are increasing in value
 *
 *  @val Descending -> Down sorting
 *
 *    Indicates sorting where elements are decreasing in value
 *
 *  @val Void -> Void
 *
 *    Indicates no value
 *
 * @def isUp ->  Ascending check
 *
 *     Returns ''true'' if ''this'' is [[Type.Ascending]]
 *
 * @def isUp ->  Descending check
 *
 *     Returns ''true'' if ''this'' is [[Type.Descending]]
 *
 * @def reverse ->  Inversed
 *
 *     Returns [[Type.Descending]] if ''this'' is [[Type.Ascending]]
 *
 *     Returns [[Type.Ascending]] if ''this'' is [[Type.Descending]]
 *
 *     Returns [[Type.Void]] if ''this'' is [[Type.Void]]
 *
 */
