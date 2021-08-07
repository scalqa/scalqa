package scalqa; package gen; package `given`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait WithinDef[A,-CONTAINER]:
  def value_isWithin(v: A, c: CONTAINER): Boolean

object WithinDef extends zWithinDefault:

  given givenAbleContain[A] : WithinDef[A,Able.Contain[A]] with { inline def value_isWithin(v:A, x: Able.Contain[A]) = x.contains(v) }

  given givenIterableOnce[A]: WithinDef[A,S.IterableOnce[A]] = z.WithinDef.IterableOnce.cast[WithinDef[A,S.IterableOnce[A]]]
  given givenJIterable   [A]: WithinDef[A,J.Iterable[A]]     = z.WithinDef.Iterable    .cast[WithinDef[A,J.Iterable[A]]]
  given givenJIterator   [A]: WithinDef[A,U.Iterator[A]]     = z.WithinDef.Iterator    .cast[WithinDef[A,U.Iterator[A]]]
  given givenProduct     [A]: WithinDef[A,Product]           = z.WithinDef.Product     .cast[WithinDef[A,Product]]

private class zWithinDefault:
  given givenString[A<:String | String.Opaque]: WithinDef[A,A]               with { inline def value_isWithin(v:A   , x:A) = x.asInstanceOf[String].contains(v.asInstanceOf[String])}
  given givenChar  [A<:String | String.Opaque]: WithinDef[Char,A]            with { inline def value_isWithin(v:Char, x:A) = x.asInstanceOf[String].indexOf(v)>=0 }
  given givenCollection[A]                    : WithinDef[A,Collection[A]]        = z.WithinDef.Collection  .cast[WithinDef[A,Collection[A]]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
