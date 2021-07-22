package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object zipAll extends J.Test:

  testEqual_~(
    (1 to 10).zipAll(1 to 10, -1, -2),
    (1 <> 10).~.zipAll(1 <> 10, -1, -2))

  testEqual_~("short one")(
    (1 to 5).zipAll(1 to 10, -1, -2),
    (1 <> 5).~.zipAll(1 <> 10, -1, -2))

  testEqual_~("short two")(
    (1 to 10).zipAll(1 to 5, -1, -2),
    (1 <> 10).~.zipAll(1 <> 5, -1, -2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
