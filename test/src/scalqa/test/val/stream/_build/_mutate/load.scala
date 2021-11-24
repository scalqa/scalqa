package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object load extends J.Test:

  testEqualStream(
    1 <> 100,
    { var ok = true; (1 <> 100).stream.take(_ => ok).load.peek(_ => ok = false) }
  )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
