package scalqa; package test.`val`.stream._use._evaluate; import language.implicitConversions

object isEvery extends J.Test:

  def all = (1 <> 100).stream.reverseEvery(25)

  test{
    assertFalse(all.isEvery(_ > 50))
    assertTrue(all.isEvery(_ > 0))
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
