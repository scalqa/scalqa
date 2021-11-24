package scalqa; package test.`val`.stream._use._process; import language.implicitConversions

object foreach extends J.Test:

  testTrue{
    var i = 0
    (1 <> 1000).stream.foreach(_ => i += 1)
    i == 1000
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
