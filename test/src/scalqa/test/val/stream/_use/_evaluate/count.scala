package scalqa; package test.`val`.stream._use._evaluate; import language.implicitConversions

object count extends J.Test:

  def all = (1 <> 100).stream.reverseEvery(25)

  testTrue{
    all.count == 100
  }

  testTrue("countAndTime") {
    val (cnt,time) = all.countAndTime
    cnt == 100 && time < 1.Minute
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
