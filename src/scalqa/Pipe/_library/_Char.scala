package scalqa; package Pipe; package _library

class _Char private[scalqa] (protected val This: Pipe[Char]) extends AnyVal {

  def toChars = This.to[Array].Chars

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Char ->
 *
 *     This library is only available for [[Pipe]] of [[Char]]s ( Pipe[Char] ) and is invisible for other Pipes
 *
 * @def toChars -> Conversion to Chars
 *
 *     Converts this [[Pipe]] to [[Array.View.Chars]]
 *
 *     [[Chars]] can be treated as immutable, because base array reference is discarded
 */
