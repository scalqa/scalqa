package scalqa; package test.Val.Stream._use._aggregate; import language.implicitConversions

object range extends J.Test:

  testTrue{
    val r = (1 <> 100).~.reverseEvery(3).range
    r.start == 1 && r.end == 100
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
