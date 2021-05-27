package scalqa; package test.lang.int; import language.implicitConversions

object Range extends J.Test:

  testFalse("contains") {
    val r = 1 <>> 10
    assertTrue( 1 in r)
    assertTrue( 3 in r)
    assertFalse(10 in r)
    assertFalse(13 in r)
    r contains 0
  }

  testTrue("Void") {
    val v: Int.<> = \/
    assertTrue(v.isVoid)
    val z = 0 <>> 0
    assertFalse(z.isVoid)
    assertTrue(v.start == z.start && v.end == z.end)
    v ne z
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/