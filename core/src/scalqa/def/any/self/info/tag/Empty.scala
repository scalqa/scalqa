package scalqa; package `def`; package any; package self; package info; package tag; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait Empty[-A]:
  def isEmpty(v: A): Boolean

object Empty extends EmptyDefault:
  self =>

  given xxIterableOnce: Empty[S.IterableOnceOps[_,_,_]] with { def isEmpty(v: S.IterableOnceOps[_,_,_]) = v.isEmpty }
  given xxJIterable   : Empty[J.Iterable[_]]            with { def isEmpty(v: J.Iterable[_]) = v match{ case v: U.Collection[_] => v.isEmpty; case v => !v.iterator.hasNext }}
  given xxJIterator   : Empty[U.Iterator[_]]            with { def isEmpty(v: U.Iterator[_]) = !v.hasNext }
  given xxString      : Empty[String]                   with { def isEmpty(v: String)        = v.length == 0 }

private[tag] class EmptyDefault:
  inline given xxDefault[A]: Empty[A] = ZZ.Tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
