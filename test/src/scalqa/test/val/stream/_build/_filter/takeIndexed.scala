package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeIndexed extends J.Test("takeIndexed"):

  testEqual_~(
    50 <> 100,
    (0 <> 100).~.takeIndexed((i, _) => i >= 150, 100))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
