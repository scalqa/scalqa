package scalqa; package test.`val`.stream._build._extend; import language.implicitConversions

object unfold extends J.Test:

  test_~(
    (0L <> 1L).~.unfold(_.takeLast(2).sum).takeFirst(50), // Fibonacci
    {
      var l = scala.List(1L, 0L)
      (1 <> 48).~.foreach(_ => l = (l.head + l.tail.head) :: l)
      l.reverse.~
    }
  )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
