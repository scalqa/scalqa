package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object dropValues extends J.Test("dropValues"):

  testEqual_~(
    (1 <> 49).~ ++ (81 <> 100),
    (1 <> 100).~.dropValues(50 <> 80),
    (1 <> 100).~.reverseEvery(5).dropValues(50 <> 80).sort,
    (1 <> 100).~.dropValues((50 <> 80).~.reverseEvery(5)),
    (1 <> 100).~.reverseEvery(10).dropValues((50 <> 80).~.reverseEvery(5)).sort,
  )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
