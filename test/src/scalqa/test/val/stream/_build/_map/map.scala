package scalqa; package test.`val`.stream._build._map; import language.implicitConversions

object map extends J.Test:

  test_~(
    (1 to 1000).map(_ * 2L),
    (1 <> 1000).~.map(_ * 2L))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
