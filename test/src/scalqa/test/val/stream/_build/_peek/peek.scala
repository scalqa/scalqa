package scalqa; package test.`val`.stream._build._peek; import language.implicitConversions

object peek extends J.Test:

  testTrue{
    var sum = 0
    (1 <> 100).stream.peek(sum += _).drain
    sum == (1 <> 100).stream.sum
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
