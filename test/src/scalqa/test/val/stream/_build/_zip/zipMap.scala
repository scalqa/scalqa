package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object zipValue extends J.Test:

  testEqual_~(
    (0 to 100) zip (0L to 100L),
    (0 <> 100).~.zipValue(_ * 1L))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
