package scalqa; package gen; package `given`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait InTag[A,-CONTAINER]:
  def in(v: A, c: CONTAINER): Boolean

object InTag extends zInDefault:

  given givenAbleContain[A] : InTag[A,Able.Contain[A]] with { inline def in(v:A, x: Able.Contain[A]) = x.contains(v) }

  given givenIterableOnce[A]: InTag[A,S.IterableOnce[A]] = z.InTag.IterableOnce.cast[InTag[A,S.IterableOnce[A]]]
  given givenJIterable   [A]: InTag[A,J.Iterable[A]]     = z.InTag.Iterable    .cast[InTag[A,J.Iterable[A]]]
  given givenJIterator   [A]: InTag[A,U.Iterator[A]]     = z.InTag.Iterator    .cast[InTag[A,U.Iterator[A]]]
  given givenProduct     [A]: InTag[A,Product]           = z.InTag.Product     .cast[InTag[A,Product]]

private class zInDefault:
  given givenString[A<:String | Opaque.String]: InTag[A,A]               with { inline def in(v:A,    x:A) = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given givenChar  [A<:String | Opaque.String]: InTag[Char,A]            with { inline def in(v:Char, x:A) = x.asInstanceOf[String].indexOf(v)>=0 }
  given givenCollection  [A]: InTag[A,Collection[A]]     = z.InTag.Collection  .cast[InTag[A,Collection[A]]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
