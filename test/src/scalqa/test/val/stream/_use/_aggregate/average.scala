package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object average extends J.Test:

  @fast lazy val l = (1 <> 100).stream.map(_.toDouble).reverseEvery(10).pack

  testTrue{
    var i = 0D
    val a = l.stream.peek(i += _).average
    a == i / l.size
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
