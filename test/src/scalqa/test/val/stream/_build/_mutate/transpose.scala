package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object transpose extends J.Test:

  testEqualStream(
    Stream(Stream(1, 2, 3), Stream(4, 5, 6), Stream(7, 8, 9)).transpose.flatten,
    Stream(Stream(1, 4, 7), Stream(2, 5, 8), Stream(3, 6, 9)).flatten)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
