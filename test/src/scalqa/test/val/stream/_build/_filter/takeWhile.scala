package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeWhile extends J.Test:

  testEqualStream(
    ((0 to 100)   ++ (0 to 100)).takeWhile(_ < 50),
    ((0 <> 100).stream ++ (0 <> 100)).takeWhile(_ < 50))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
