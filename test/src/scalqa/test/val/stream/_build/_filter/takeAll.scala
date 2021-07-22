package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeAll extends J.Test("takeAll"):

  testEqual_~(
    20 to 30,
    (1 <> 100).~.takeAll(20 <> 30),
    (1 <> 100).~.reverseEvery(10).takeAll(20 <> 30).sort,
    (1 <> 100).~.takeAll((20 <> 30).~.reverseEvery(3)),
    (1 <> 100).~.reverseEvery(10).takeAll((20 <> 30).~.reverseEvery(4)).sort)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
