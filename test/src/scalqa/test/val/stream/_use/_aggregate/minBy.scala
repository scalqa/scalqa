package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object minBy extends J.Test:

  testTrue{
    val l = (1 <> 100).stream.reverseEvery(10).pack
    val min = l.stream.minBy(_ * -1)
    l.stream.isEvery(_ * -1 >= min * -1)
  }

  testTrue("calls") {
    val l = (1 <> 100).stream.reverseEvery(10).pack
    var cnt = 0
    val v = l.stream.minBy(x => { cnt += 1; x * 10 })
    cnt == l.size
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
