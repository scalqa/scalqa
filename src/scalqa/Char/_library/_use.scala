package scalqa; package Char; package _library

trait _use extends Any with __ {

  def allUp: ~[Char] = new Z.all.Up(This)

  def allDown: ~[Char] = new Z.all.Down(This)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Char.Max]]
 *   {{{
 *     'A'.allUp.letFirst(26).lp
 *     // Output
 *     ~(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
 *   }}}
 *
 * @def allDown -> Down pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Char.Min]]
 *   {{{
 *     'Z'.allDown.letFirst(26).lp
 *     // Output
 *     ~(Z, Y, X, W, V, U, T, S, R, Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, B, A)
 *   }}}
 */
