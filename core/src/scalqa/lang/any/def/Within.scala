package scalqa; package lang; package any; package `def`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait Within[A,-CONTAINER]:
  def value_isWithin(v: A, c: CONTAINER): Boolean

object Within extends zWithinault:

  given givenAbleContain[A] : Within[A,Able.Contain[A]] with { inline def value_isWithin(v:A, x: Able.Contain[A]) = x.contains(v) }

  given givenIterableOnce[A]: Within[A,S.IterableOnce[A]] = z.Within.IterableOnce.cast[Within[A,S.IterableOnce[A]]]
  given givenJIterable   [A]: Within[A,J.Iterable[A]]     = z.Within.Iterable    .cast[Within[A,J.Iterable[A]]]
  given givenJIterator   [A]: Within[A,U.Iterator[A]]     = z.Within.Iterator    .cast[Within[A,U.Iterator[A]]]
  given givenProduct     [A]: Within[A,Product]           = z.Within.Product     .cast[Within[A,Product]]

private class zWithinault:
  given givenString[A<:String | String.Opaque]      : Within[A,A]               with { inline def value_isWithin(v:A   , x:A) = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given givenCharInString[A<:String | String.Opaque]: Within[Char,A]            with { inline def value_isWithin(v:Char, x:A) = x.asInstanceOf[String].indexOf(v)>=0 }
  given givenCollection[A]                          : Within[A,Collection[A]]        = z.Within.Collection  .cast[Within[A,Collection[A]]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
