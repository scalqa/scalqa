package scalqa; package test.Val.Stream._build._zip; import language.implicitConversions

object zipFoldAs extends J.Test:

  test_~(
    (1 to 100).scanLeft(0L)(_ + _).drop(1),
    (1 <> 100).~.zipFoldAs(0L, _ + _).map(_._2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
