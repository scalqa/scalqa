package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object groupBy extends J.Test:

  testEqualStream(
    (0 to 100).filter(_ % 3 == 0),
    (0 <> 100).stream.groupBy(_ / 3).map(_.read))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
