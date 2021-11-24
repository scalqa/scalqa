package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object group extends J.Test:

  testEqualStream(
    1 to 100,
    (1 <> 100).stream.flatMap(v => Stream(v, v, v)).group.map(_.read))

  testEqualStream("(?)")(
    (0 to 100).filter(_ % 3 == 0),
    (0 <> 100).stream.group((x, y) => x / 3 == y / 3).map(_.read))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
