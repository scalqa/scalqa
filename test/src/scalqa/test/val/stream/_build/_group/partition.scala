package scalqa; package test.`val`.stream._build._group; import language.implicitConversions

object partition extends J.Test:

  test{
    val (t1, t2) = (1 to 100).partition(_ < 50)
    val (p1, p2) = t1.partition(_ < 25)
    val (p3, p4) = t2.partition(_ < 75)
    val (v1, v2, v3, v4) = (1 <> 100).stream.partition(_ < 25, _ < 50, _ < 75).tuple4
    assertEqualStream(p1, v1)
    assertEqualStream(p2, v2)
    assertEqualStream(p3, v3)
    assertEqualStream(p4, v4)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
