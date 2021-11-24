package scalqa; package test.`val`.stream._use._transform; import language.implicitConversions

object toVector extends J.Test:

  testEqualStream(
    (1 to 100).toVector,
    (1 <> 100).stream.iterator.toVector)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
