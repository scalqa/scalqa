package scalqa; package test.Val.Stream._build._map; import language.implicitConversions

object collect extends J.Test:

  test_~(
    (1 to 100)  .collect    { case v if v % 10 != 0 => v * 2D },
    (1 <> 100).~.collect { case v if v % 10 != 0 => v * 2D })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
