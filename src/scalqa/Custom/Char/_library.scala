package scalqa; package Custom; package Char

class _library private[scalqa] (private val real: Char) extends AnyVal {

  def lower: Char = Character.toLowerCase(real)
  def upper: Char = Character.toUpperCase(real)

  def allUp: ~[Char] = new Z.stream.Up(real)
  def allDown: ~[Char] = new Z.stream.Down(real)

  def <>(that: Char): Range[Char] = new Z.Range(real, false, that, false)
  def <>>(that: Char): Range[Char] = new Z.Range(real, false, that, true)
  def <<>(that: Char): Range[Char] = new Z.Range(real, true, that, false)
  def <<>>(that: Char): Range[Char] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Char] = new Z.Range(real, false, real + size toChar, false)
  def <>>+(size: Int): Range[Char] = new Z.Range(real, false, real + size toChar, true)
  def <>! : Range[Char] = new Z.Range(real, false, real, false)
  def <>>! : Range[Char] = new Z.Range(real, false, real, true)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up stream
 *
 *   Creates a stream of elements from `this` to Char.MaxValue
 *   {{{
 *     'A'.allUp.letNext(26).lp
 *     // Output
 *     ~(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
 *   }}}
 *
 * @def allDown -> Down stream
 *
 *   Creates a stream of elements from `this` to Char.MinValue
 *   {{{
 *     'Z'.allDown.letNext(26).lp
 *     // Output
 *     ~(Z, Y, X, W, V, U, T, S, R, Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, B, A)
 *   }}}
 */
