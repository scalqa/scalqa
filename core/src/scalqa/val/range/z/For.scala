package scalqa; package `val`; package range; package z; import language.implicitConversions

private[scalqa] class For:
  extension[A](inline x: Range[A])
    inline def withFilter(inline f: A => Boolean)   (using inline s:Able.Sequence[A]) : ~[A] = x.~.take(f)
    inline def map[B](       inline f: A => B)      (using inline s:Able.Sequence[A]) : ~[B] = x.~.map(f)
    inline def flatMap[B](   inline f: A => ~[B])   (using inline s:Able.Sequence[A]) : ~[B] = x.~.flatMap(f)
    inline def foreach[U](   inline f: A => U)      (using inline s:Able.Sequence[A]) : Unit = x.~.foreach(f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
