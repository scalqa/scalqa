package scalqa; package test.`val`.stream._build._zip; import language.implicitConversions

object unzip extends J.Test:

  testEqualStream(
    1 to 100,
    {
      val (first, second) = (1 <> 100).stream.zip(51 <> 100).unzip;
      first ++ second
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
