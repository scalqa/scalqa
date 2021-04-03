package scalqa; package test.Val.Range; import language.implicitConversions

object join extends J.Test:

  test_~(
    3 <> 8  join 1 join 10,
    3 <> 8  join 1 <> 10,
    1 <> 10 join 3 <> 8,
    5 <> 10 join 1 <> 3)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/