package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object max extends J.Test:

  testTrue{
    val l = (1 <> 100).stream.reverseEvery(10).pack
    val max = l.stream.max
    l.stream.isEvery(_ <= max)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
