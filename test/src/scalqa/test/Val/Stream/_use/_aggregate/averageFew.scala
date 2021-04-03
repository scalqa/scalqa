package scalqa; package test.Val.Stream._use._aggregate; import language.implicitConversions

object averageFew extends J.Test:

  @fast lazy val l = (1 <> 100).~.map(_.Float).reverseEvery(10).><

  test{
    var i1, i2 = 0F
    val (j1, j2) = l.~.peek(v => { i1 += v; i2 += v * 10 }).averageFew(v => v, _ * 10)
    assertTrue(j1 == i1 / l.size)
    assertTrue(j2 == i2 / l.size)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
