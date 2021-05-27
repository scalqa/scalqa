package scalqa; package test.`val`.stream._build._map; import language.implicitConversions

object flatten extends J.Test:

  test_~(
    1 to 1000,
    (1 <> 1000).~.groupEvery(5).flatten)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
