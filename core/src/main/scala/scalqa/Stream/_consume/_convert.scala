package scalqa; package Stream; package _consume

trait _convert[A] extends Flow._consume._convert[A] { self: Stream[A] =>

  def toBuffer: Stream[A] = self.to[Idx.Array.Buffer].all

  def toLookup[KEY, VAL](implicit ev: A <:< (KEY, VAL)): Lookup[KEY, VAL] = Z.consume.convert.ToLookup(this)

  def toLookup[KEY](key: A => KEY): Lookup[KEY, A] = map(v => (key(v), v)).toLookup

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _convert -> `Conversion interface`
 *
 *
 * @def toBuffer: -> New buffered stream
 *
 *     Buffers all elements from the source and returns them as new [[Stream]]
 *
 * @def toLookup[KEY, VAL] -> New Lookup
 *
 *     This Stream must contain tuples of keys and values
 *
 * @def toLookup[KEY] -> New Lookup
 *
 *       Creates a [[Lookup]] collection out of [[Stream]] elements
 *
 *       @param f function to create lookup keys
 *
 *       {{{
 *          val l: Lookup[Int, Char] = ('A' <> 'Z').all.toLookup(_.toInt)
 *
 *          l(65).lp   // Prints: A
 *          l(77).lp   // Prints: M
 *          l(90).lp   // Prints: Z
 *       }}}
 *
 */
