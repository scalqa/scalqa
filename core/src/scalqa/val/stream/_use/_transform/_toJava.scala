package scalqa; package `val`; package stream; package _use; package _transform; import language.implicitConversions

import java.{ util as J }

transparent trait _toJava:

  extension[A] (inline x: ~[A])
    inline def toJavaList                                    : J.List[A]           = x.toBuffer.toJavaList_^
    inline def toJavaIterator                                : J.Iterator[A]       = z._use._transform.toJava.Iterator(x)
    inline def toJavaSpliterator(inline splitSize: Int)      : J.Spliterator[A]    = z._use._transform.toJava.Spliterator(x,splitSize)
    inline def toJavaStream(inline parallel: Boolean = false): J.stream.Stream[A]  = J.stream.StreamSupport.stream(x.toJavaSpliterator(1), parallel)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def toJavaList -> Convert to Java List

        Returns stream elements as `java.util.List`

@def toJavaIterator -> Convert to Java Iterator

        Wraps current stream as `java.util.Iterator`

@def toJavaSpliterator -> Convert to Java Spliterator

        Wraps current stream as `java.util.Spliterator`

@def toJavaStream -> Convert to Java Stream

        Wraps current stream as `java.util.stream.Stream`


*/
