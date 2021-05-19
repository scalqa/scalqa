package scalqa; package gen; package able; import language.implicitConversions

trait Stream[+A]:

  @tn("stream") def ~ : ~[A]

object Stream:

  trait Self[+A] extends Stream[A]:
    self : ~[A] =>
    @tn("stream") def ~ : ~[A] = self

  given givenStream      [A<: ~[B],B]                           : Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = v }
  given givenIterableOnce[A<:scala.collection.IterableOnce[B],B]: Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = ~~.fromIterableOnce(v) }
  given givenIterator    [A<:java.lang.Iterable[B],B]           : Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = ~~.fromIterable(v) }
  given givenIterable    [A<:java.util.Iterator[B],B]           : Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = ~~.fromIterator(v) }
  given givenSpliterator [A<:java.util.Spliterator[B],B]        : Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = ~~.fromSpliterator(v) }
  given givenEnumeration [A<:java.util.Enumeration[B],B]        : Conversion[A,Stream[B]] = v => new Stream[B]{@tn("stream") def ~ = ~~.fromEnumeration(v) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> Able of providing stream of elements

@def ~ -> Stream elements

   Returns stream of all alements

*/
