package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object zipPrior extends J.Test:

  test_~(
    0 to 99,
    (0 <> 100).~.zipPrior.map_?(_._1))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
