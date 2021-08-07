package scalqa; package gen; package `given`; import language.implicitConversions

import java.{ lang as J, util as U }
import scala.{ collection as S }

trait EmptyDef[-A]:
  def value_isEmpty(v: A): Boolean

object EmptyDef extends EmptyDefault:
  self =>

  inline given givenIterableOnce: EmptyDef[S.IterableOnceOps[_,_,_]] with { inline def value_isEmpty(v: S.IterableOnceOps[_,_,_]) = v.isEmpty }
  /**/   given givenJIterable   : EmptyDef[J.Iterable[_]]            with {        def value_isEmpty(v: J.Iterable[_]) = v match{ case v: U.Collection[_] => v.isEmpty; case v => !v.iterator.hasNext }}
  inline given givenJIterator   : EmptyDef[U.Iterator[_]]            with { inline def value_isEmpty(v: U.Iterator[_]) = !v.hasNext }
  inline given givenString      : EmptyDef[String]                   with { inline def value_isEmpty(v: String)        = v.length == 0 }

private[`given`] class EmptyDefault:
  inline given givenDefault[A]: EmptyDef[A] = ZZ.Def

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def value_isEmpty -> Empty check

      Returns true if provided value should be considered empty

*/
