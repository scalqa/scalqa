package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeValues extends J.Test("takeValues"):

  testEqualStream(
    20 to 30,
    (1 <> 100).stream.takeValues(20 <> 30),
    (1 <> 100).stream.reverseEvery(10).takeValues(20 <> 30).sort,
    (1 <> 100).stream.takeValues((20 <> 30).stream.reverseEvery(3)),
    (1 <> 100).stream.reverseEvery(10).takeValues((20 <> 30).stream.reverseEvery(4)).sort)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
