package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object drop extends J.Test:

  testEqualStream(
    (1 to 100).filterNot(_ % 7 != 0),
    (1 <> 100).stream.drop(_ % 7 != 0))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
