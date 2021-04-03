package scalqa; package test.Val.Stream._use._evaluate; import language.implicitConversions

object contains extends J.Test:

  def all = (1 <> 100).~.reverseEvery(25)

  test{
    assertTrue(all.contains(12))
    assertFalse(all.contains(112))
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
