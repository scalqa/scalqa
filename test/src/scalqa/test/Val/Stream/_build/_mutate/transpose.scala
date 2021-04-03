package scalqa; package test.Val.Stream._build._mutate; import language.implicitConversions

object transpose extends J.Test:

  test_~(
    ~~(~~(1, 2, 3), ~~(4, 5, 6), ~~(7, 8, 9)).transpose.flatten,
    ~~(~~(1, 4, 7), ~~(2, 5, 8), ~~(3, 6, 9)).flatten)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
