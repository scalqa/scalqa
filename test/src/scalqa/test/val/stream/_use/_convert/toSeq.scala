package scalqa; package test.`val`.stream._use._convert; import language.implicitConversions

object toSeq extends J.Test:

  test_~(
    (1 to 100).toSeq,
    (1 <> 100).~.toSeq)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
