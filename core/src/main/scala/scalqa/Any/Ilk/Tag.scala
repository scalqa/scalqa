package scalqa; package Any; package Ilk

trait Tag[@specialized(DATA) -A] extends Like {

  def ilkOpt: Opt[Ilk]

  def primitiveOpt: Opt[Ilk]

}

object Tag extends OtherImplicits {

  def make[A](implicit t: Tag[A]) = t

  implicit val Booleans = Z.A.Booleans
  implicit val Bytes = Z.A.Bytes
  implicit val Chars = Z.A.Chars
  implicit val Shorts = Z.A.Shorts
  implicit val Ints = Z.A.Ints
  implicit val Longs = Z.A.Longs
  implicit val Floats = Z.A.Floats
  implicit val Doubles = Z.A.Doubles

  implicit def zzMake[A](v: Ilk): Tag[A] = v.asInstanceOf[Tag[A]]

}
private[Ilk] class OtherImplicits extends DefaultImplicits {

  implicit val Refs = Z.A.Refs

  implicit val Vals = Z.Tag.Val
}
private[Ilk] class DefaultImplicits {

  implicit val Void = Z.Tag.Void
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Tag ->
 *
 *    [[Tag]] allows to determine [[Ilk]] from the context
 *
 *    Note, that [[Ilk]] and [[Tag]] tag are aliased to the root as:
 *
 *    - scalqa.Ilk type = Any.Ilk.Tag
 *    - scalqa.Ilk value = Any.Ilk
 *
 */
