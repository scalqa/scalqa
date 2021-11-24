package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object zipIndex extends J.Test("zipIndex"):

  testEqualStream(
    0 to 100,
    (0 <> 100).stream.zipIndex.map(_._1))

  testEqualStream("started")(
    100 to 200,
    (0 <> 100).stream.zipIndex(100).map(_._1))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
