package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object dropInterval extends J.Test("dropRange"):

  testEqualStream(
    (0 <> 10).stream.dropRange(4 <> 6),
    (0 to 3) ++ (7 to 10),
    (0 to 3) ++ (7 to 10)
   )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
