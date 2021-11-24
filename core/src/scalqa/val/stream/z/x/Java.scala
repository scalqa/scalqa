package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

import java.{util as J }

object Java:

  def Stream_fromIterable[A](v: java.lang.Iterable[A]): Stream[A] = v match
    case c: J.Collection[A] if (c.isEmpty) => Stream.void[A]
    case l: J.List[A]                      => Stream_fromList(l)
    case c: J.Collection[A]                => Stream_fromCollection(c)
    case v                                 => Stream_fromIterator(v.iterator)

  class Stream_fromList[A](l: J.List[A]) extends Stream[A] with Able.Size:
    private         var i      = 0
    private         val sz     = l.size
    def readOpt = { var o:Opt[A] = \/; if(i<sz){ o=l.get(i); i+=1}; o}
    /**/            def size   = sz - i

  class Stream_fromIterator[A](it: J.Iterator[A]) extends Stream[A]:
    def readOpt = it.hasNext ? it.next

  class Stream_fromEnumeration[A](it: J.Enumeration[A]) extends Stream[A]:
    def readOpt = it.hasMoreElements ? it.nextElement

  class Stream_fromSpliterator[A](s: J.Spliterator[A]) extends Stream[A] with J.function.Consumer[A]:
    private         var value        : A      = _
    def readOpt       : Opt[A] = s.tryAdvance(this) ? value
    /**/            def accept(v: A) : Unit   = value = v

  class Stream_fromCollection[A](c: J.Collection[A]) extends Stream[A] with Able.Size:
    private         val it      = c.iterator
    private         var sz      = c.size
    def readOpt  = it.hasNext ? { sz -= 1; it.next }
    /**/            def size    = sz

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
