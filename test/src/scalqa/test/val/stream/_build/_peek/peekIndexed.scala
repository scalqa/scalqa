package scalqa; package test.`val`.stream._build._peek; import language.implicitConversions

object peekIndexed extends J.Test:

  testTrue{
    var sum = 0
    (0 <> 100).stream.peekIndexed((i, v) => sum += i, 100).drain
    sum == (100 to 200).sum
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
