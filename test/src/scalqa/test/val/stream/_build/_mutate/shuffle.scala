package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object shuffle extends J.Test:

  testFalse{
    (0 <> 100).stream.shuffle.equalsSequence(0 <> 100)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
