package scalqa; package test.Val.Stream._use._aggregate; import language.implicitConversions

object min extends J.Test:

  testTrue{
    val l = (1 <> 100).~.reverseEvery(10).><
    val min = l.~.min
    l.~.isEvery(_ >= min)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
