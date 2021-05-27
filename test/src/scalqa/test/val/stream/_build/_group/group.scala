package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object group extends J.Test:

  test_~(
    1 to 100,
    (1 <> 100).~.flatMap(v => ~~(v, v, v)).group.map(_.read))

  test_~("(?)")(
    (0 to 100).filter(_ % 3 == 0),
    (0 <> 100).~.group((x, y) => x / 3 == y / 3).map(_.read))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
