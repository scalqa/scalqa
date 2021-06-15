package scalqa; package gen; package `given`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait EmptyTag[-A]:
  def isEmpty(v: A): Boolean

object EmptyTag extends EmptyDefault:
  self =>

  given givenIterableOnce: EmptyTag[S.IterableOnceOps[_,_,_]] with { def isEmpty(v: S.IterableOnceOps[_,_,_]) = v.isEmpty }
  given givenJIterable   : EmptyTag[J.Iterable[_]]            with { def isEmpty(v: J.Iterable[_]) = v match{ case v: U.Collection[_] => v.isEmpty; case v => !v.iterator.hasNext }}
  given givenJIterator   : EmptyTag[U.Iterator[_]]            with { def isEmpty(v: U.Iterator[_]) = !v.hasNext }
  given givenString      : EmptyTag[String]                   with { def isEmpty(v: String)        = v.length == 0 }

private[`given`] class EmptyDefault:
  inline given givenDefault[A]: EmptyTag[A] = ZZ.Tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
