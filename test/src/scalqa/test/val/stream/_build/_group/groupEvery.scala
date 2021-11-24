package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object groupEvery extends J.Test:

  testEqualStream(
    (1 to 1000).grouped(10).map(_.sum),
    (1 <> 1000).stream.groupEvery(10).map(_.sum))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
