package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object zip extends J.Test:

  test_~(
    (1 to 100).zip(1 to 100),
    (1 <> 100).~.zip(1 <> 100))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
