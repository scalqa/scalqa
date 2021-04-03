package scalqa; package test.Gen.Event; import language.implicitConversions

object weakRef extends J.Test:

  test("loose reference") {
    val p = Pro.OM[Int](10)

    var i = 0

    var ref = p.onChangeRun(i += 1).removeHardReference

    p() = 20
    p() = 30

    ref = null

    System.gc
    System.gc

    p() = 40
    p() = 50

    assertTrue(i == 2, "Must be 2, but is " + i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
