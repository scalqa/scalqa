package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object sliding extends J.Test:

  test_~(
    (1 to 1000).sliding(5, 12).flatten.sliding(3, 4).flatten.sliding(3, 3).flatten.sliding(3, 2).flatten.sliding(3, 1).flatten.~,
    (1 <> 1000).~.sliding(5, 12).flatten.sliding(3, 4).flatten.sliding(3, 3).flatten.sliding(3, 2).flatten.sliding(3, 1).flatten)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
