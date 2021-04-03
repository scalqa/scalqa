package scalqa; package test.Val.Stream._use._evaluate; import language.implicitConversions

object find extends J.Test:

  def all = (1 <> 100).~.reverseEvery(25)

  test("_?") {
    assertTrue(all.find_?(_ > 50))
    assertFalse(all.find_?(_ > 550))
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
