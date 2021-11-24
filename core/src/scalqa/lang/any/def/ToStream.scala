package scalqa; package lang; package any; package `def`; import language.implicitConversions

import java.{ lang as J, util as U }

trait ToStream[-A,B]:
  def value_toStream(v: A): Stream[B]

object ToStream:
  self =>

  given givenSelfStream  [B]: ToStream[Stream[B],B]        with { inline def value_toStream(v: Stream      [B]): Stream[B] = v        }
  given givenAbleStream  [B]: ToStream[Able.Stream[B],B]   with { inline def value_toStream(v: Able.Stream [B]): Stream[B] = v.stream }
  given givenIterableOnce[B]: ToStream[IterableOnce[B],B]  with { inline def value_toStream(v: IterableOnce[B]): Stream[B] = v.stream }
  given givenJavaIterable[B]: ToStream[J.Iterable[B],B]    with { inline def value_toStream(v: J.Iterable  [B]): Stream[B] = v.stream }
  given givenJavaIterator[B]: ToStream[U.Iterator[B],B]    with { inline def value_toStream(v: U.Iterator  [B]): Stream[B] = v.stream }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

