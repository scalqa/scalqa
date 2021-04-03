package scalqa; package test.Val.Stream._build._filter; import language.implicitConversions

object dropAllBy extends J.Test("dropAllBy"):

  test_~(
    (1 until 50) ++ (81 to 100),
    (1 <> 100).~.dropAllBy(_ * 10, 500 <> 800),
    (1 <> 100).~.dropAllBy(_ * 10, (500 <> 800).~.reverseEvery(5)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
