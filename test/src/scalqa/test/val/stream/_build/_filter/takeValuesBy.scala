package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeValuesBy extends J.Test("takeValuesBy"):

  testEqualStream(
    30 to 50,
    (1 <> 100).stream.takeValuesBy(_ * 10, 300 <> 500),
    (1 <> 100).stream.takeValuesBy(_ * 10, (300 <> 500).stream.reverseEvery(4)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
