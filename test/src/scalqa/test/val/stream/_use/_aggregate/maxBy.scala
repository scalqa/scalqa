package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object maxBy extends J.Test:

  testTrue{
    val l = (1 <> 100).~.reverseEvery(10).><
    val max = l.~.maxBy(_ * -1)
    l.~.isEvery(_ * -1 <= max * -1)
  }

  testTrue("calls") {
    val l = (1 <> 100).~.reverseEvery(10).><
    var cnt = 0
    val v = l.~.maxBy(x => { cnt += 1; x * 10 })
    cnt == l.size
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
