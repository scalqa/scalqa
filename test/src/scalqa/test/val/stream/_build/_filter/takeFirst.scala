package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeFirst extends J.Test:

  testEqual_~(
    1 to 50,
    (1 <> 100).~.takeFirst(50))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
