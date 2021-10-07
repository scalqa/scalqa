package scalqa; package lang; package any; package `def`; import language.implicitConversions

import java.{ lang as J, util as U }

trait ToStream[-A,B]:
  def value_toStream(v: A): ~[B]

object ToStream:
  self =>

  given givenSelfStream  [B]: ToStream[~[B],B]             with { inline def value_toStream(v: ~           [B]): ~[B] = v   }
  given givenAbleStream  [B]: ToStream[Able.~[B],B]        with { inline def value_toStream(v: Able.~      [B]): ~[B] = v.~ }
  given givenIterableOnce[B]: ToStream[IterableOnce[B],B]  with { inline def value_toStream(v: IterableOnce[B]): ~[B] = v.~ }
  given givenJavaIterable[B]: ToStream[J.Iterable[B],B]    with { inline def value_toStream(v: J.Iterable  [B]): ~[B] = v.~ }
  given givenJavaIterator[B]: ToStream[U.Iterator[B],B]    with { inline def value_toStream(v: U.Iterator  [B]): ~[B] = v.~ }

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
