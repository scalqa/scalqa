package scalqa; package test.`val`.stream._build._map; import language.implicitConversions

object flatMap extends J.Test:

  testEqualStream(
    (1 to 100)  .flatMap(v => (1 to 100)  .map(_ * v)),
    (1 <> 100).stream.flatMap(v => (1 <> 100).stream.map(_ * v)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
