package scalqa; package Stream

trait Preview[@specialized(DATA) A] { self: Stream[A] with Preview[A] =>

  def prime(cnt: Int): Int

  def primeAll: Int = prime(Int.MaxValue)

  def previewNext: A = previewNextOpt.value

  def previewNextOpt: Opt[A]

  def preview(cnt: Int): ~[A]

  def previewIlk: Any.Ilk

  def previewSize: Int

  def previewSizeAtLeast(cnt: Int): Boolean

  def takeWhile(f: Filter[A]): ~[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Preview ->
 *
 *     [[Preview]] is an extension of [[Stream]] with preview capabilities
 *
 *     It allows pre-load and inspect elements before they are pumped
 *
 *     [[Preview]] is created with a [[_extend._flow!.preview Stream.preview]] method
 *
 * @def prime( -> Requests to get several elements ready
 *
 *    Parameter indicates how many elements are requested
 *
 *    Returns actual primed elements count
 *
 *    Returned value can be less than requested if [[Stream]] is exhausted, or greater, if more elements are ready
 *
 * @def primeAll -> Requests to get all elements ready
 *
 *    Returns total [[Stream]] element count
 *
 * @def previewIlk: -> Preview element type
 *
 *     If metadata ilkOpt is not empty, the value is returned
 *
 *     Otherwise the first element is loaded and type is determined
 *
 *     Note. If [[Stream]] is empty and Ilk is undetermined, [[Any.Ilk.Refs Ilk.Refs]] is returned. If this is unacceptable, check emptiness first
 *
 * @def previewSize: -> Preview element count
 *
 *     If metadata sizeOpt is not empty, the value is returned
 *
 *     Otherwise calls `primeAll`
 *
 * @def previewSizeAtLeast -> Checks size up to a limit
 *
 *     Retuns true if the element count is equal or exceeding the specified
 *
 *     If metadata sizeOpt is not empty, the value is tested
 *
 *     Otherwise, tries to `prime` requested number of elements
 *
 * @def preview( -> Preview multiple elements
 *
 *     Returns a [[Stream]] of elements waiting to be primed and pumped
 *
 * @def previewNext: -> Preview next element
 *
 *     Returns next element, which can be primed and pumped
 *
 *     Fails if empty
 *
 * @def previewNextOpt -> Preview next element
 *
 *     Optionally returns next element, which can be primed and pumped
 *
 *
 * @def takeWhile -> Stream while
 *
 *     Returns a [[Stream]] of sequential elements, which pass given filter
 *
 *     Note. Streamed elements are immediately removed from this [[Stream]] and buffered within the returned new [[Stream]]
 */
