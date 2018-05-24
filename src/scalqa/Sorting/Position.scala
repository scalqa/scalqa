package scalqa; package Sorting

sealed class Position private (private val int: Int) extends Any.Enum[Position](Position) {

  val signum = int

  val isInverse = int > 0

  val isAsIs = int < 0

  val isEither = int == 0

  val isNotInverse = int <= 0

  val isNotAsIs = int >= 0

  val isNotEither = int != 0

  lazy val reverse: Position = if (isAsIs) Position.Inverse else if (isInverse) Position.AsIs else Position.Either // Keep lazy

  def ifEither(position: => Position) = if (isEither) position else this

}

object Position extends Any.Enum.Companion[Position] {
  val AsIs = new Position(-1)
  val Inverse = new Position(1)
  val Either = new Position(0)

  @inline def getByInt(int: Int): Position = if (int < 0) AsIs else if (int > 0) Inverse else Either

  @inline def get(x: Boolean, y: Boolean): Position = if (x == y) Either else if (x) Inverse else AsIs
  @inline def get(x: Byte, y: Byte): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Char, y: Char): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Short, y: Short): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Int, y: Int): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Long, y: Long): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Float, y: Float): Position = if (x < y) AsIs else if (x > y) Inverse else Either
  @inline def get(x: Double, y: Double): Position = if (x < y) AsIs else if (x > y) Inverse else Either
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Position ->
 *
 *     Given first and second elements, [[Sorting.Position]] defines how they should be sorted against each other:
 *     {{{
 *        Sorting.Position.AsIs     //  as it stands
 *
 *        Sorting.Position.Inverse  //  reversed
 *
 *        Sorting.Position.Either   //  either way
 *     }}}
 *
 *  @def getByInt -> By Int
 *
 *     The given ''int'' follows same rules as Java Comparator's:
 *       - ''int'' < 0, return AsIs
 *       - ''int'' > 0, return Inverse
 *       - ''int'' == 0, return Either
 *
 *  @def get(x: Boolean -> For [[Boolean]]s
 *
 *    Returns natural sorting position for two [[Boolean]]s
 *
 *  @def get(x: Byte -> For [[Byte]]s
 *
 *    Returns natural sorting position for two [[Byte]]s
 *
 *  @def get(x: Char -> For [[Char]]s
 *
 *    Returns natural sorting position for two [[Char]]s
 *
 *  @def get(x: Short -> For [[Short]]s
 *
 *    Returns natural sorting position for two [[Short]]s
 *
 *  @def get(x: Int -> For [[Int]]s
 *
 *    Returns natural sorting position for two [[Int]]s
 *
 *  @def get(x: Long -> For [[Long]]s
 *
 *    Returns natural sorting position for two [[Long]]s
 *
 *  @def get(x: Float -> For [[Float]]s
 *
 *    Returns natural sorting position for two [[Float]]s
 *
 *  @def get(x: Double -> For [[Double]]s
 *
 *    Returns natural sorting position for two [[Double]]s
 *
 * @val AsIs -> As it stands
 *
 *     [[Position.AsIs]] indicates that:
 *
 *     for first and second elements their order is good as it stands
 *
 * @val Inverse -> Reversed
 *
 *     [[Position.Inverse]] indicates that:
 *
 *     for first and second elements their order should be reversed
 *
 * @val Either -> Equal
 *
 *     [[Position.Either]] indicates that:
 *
 *     for first and second elements their order should be one or the other without preference
 *
 * @def ifEither -> Substitute [[Position.Either]]
 *
 *     If ''this'' is [[Position.Either]], given ''position'' is returned
 *
 *     This is useful when combining two [[Sorting]]s together.
 *
 * @val reverse -> Reverse position
 *
 *     If ''this'' isAsIs, return [[Position.Inverse]]
 *
 *     If ''this'' isInverse, return [[Position.AsIs]]
 *
 *     If ''this'' isEither, return [[Position.Either]]
 *
 * @val isInverse -> Inverse check
 *
 *     Returns ''true'' if ''this'' is [[Position.Inverse]]
 *
 * @val isAsIs -> AsIs check
 *
 *     Returns ''true'' if ''this'' is [[Position.AsIs]]
 *
 * @val isEither -> Either check
 *
 *     Returns ''true'' if ''this'' is [[Position.Either]]
 *
 * @val isNotInverse -> Not Inverse check
 *
 *     Returns ''true'' if ''this'' is not [[Position.Inverse]]
 *
 * @val isNotAsIs -> Not AsIs check
 *
 *     Returns ''true'' if ''this'' is not [[Position.AsIs]]
 *
 * @val isNotEither -> Not Either check
 *
 *     Returns ''true'' if ''this'' is not [[Position.Either]]
 *
 * @val signum -> Sign function
 *
 *   Even though [[Position]] has no sign, it matches well with ''signum'' concept:
 *
 *     - Returns -1 for [[Position.AsIs]]
 *     - Returns  0 for [[Position.Either]]
 *     - Returns  1 for [[Position.Inverse]]
 */
