package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeLast extends J.Test:

  testEqualStream(
    51 to 100,
    (1 <> 100).stream.takeLast(50))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
