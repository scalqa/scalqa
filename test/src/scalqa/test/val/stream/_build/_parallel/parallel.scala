package scalqa; package test.`val`.stream._build._parallel; import language.implicitConversions

object parallel extends J.Test:

  testTrue{
    (1 <> 100).stream.parallel.peek(_ => J.sleep(1.Millis)).countAndTime._2 < 100.Millis
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
