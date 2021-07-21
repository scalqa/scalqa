package scalqa; package gen; package `given`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait WithinTag[A,-CONTAINER]:
  def within(v: A, c: CONTAINER): Boolean

object WithinTag extends zWithinDefault:

  given givenAbleContain[A] : WithinTag[A,Able.Contain[A]] with { inline def within(v:A, x: Able.Contain[A]) = x.contains(v) }

  given givenIterableOnce[A]: WithinTag[A,S.IterableOnce[A]] = z.WithinTag.IterableOnce.cast[WithinTag[A,S.IterableOnce[A]]]
  given givenJIterable   [A]: WithinTag[A,J.Iterable[A]]     = z.WithinTag.Iterable    .cast[WithinTag[A,J.Iterable[A]]]
  given givenJIterator   [A]: WithinTag[A,U.Iterator[A]]     = z.WithinTag.Iterator    .cast[WithinTag[A,U.Iterator[A]]]
  given givenProduct     [A]: WithinTag[A,Product]           = z.WithinTag.Product     .cast[WithinTag[A,Product]]

private class zWithinDefault:
  given givenString[A<:String | Opaque.String]: WithinTag[A,A]               with { inline def within(v:A   , x:A) = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given givenChar  [A<:String | Opaque.String]: WithinTag[Char,A]            with { inline def within(v:Char, x:A) = x.asInstanceOf[String].indexOf(v)>=0 }
  given givenCollection[A]                    : WithinTag[A,Collection[A]]        = z.WithinTag.Collection  .cast[WithinTag[A,Collection[A]]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
