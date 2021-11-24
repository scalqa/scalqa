package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object dropValuesBy extends J.Test("dropValuesBy"):

  testEqualStream(
    (1 until 50) ++ (81 to 100),
    (1 <> 100).stream.dropValuesBy(_ * 10, 500 <> 800),
    (1 <> 100).stream.dropValuesBy(_ * 10, (500 <> 800).stream.reverseEvery(5)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
