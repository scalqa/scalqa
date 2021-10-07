package scalqa; package test.`val`.range; import language.implicitConversions

object overlaps extends J.Test:

  test {

    assertTrue(  1 <>  10 overlaps 10 <> 20 )
    assertFalse( 1 <>> 10 overlaps 10 <> 20 )

    assertTrue(  1.toByte <>  10.toByte overlaps 10.toByte <> 20.toByte )
    assertFalse( 1.toByte <>> 10.toByte overlaps 10.toByte <> 20.toByte )

    assertTrue(  1L <>  10L overlaps 10L <> 20L )
    assertFalse( 1L <>> 10L overlaps 10L <> 20L )

    assertTrue(  1F <>  10F overlaps 10F <> 20F )
    assertFalse( 1F <>> 10F overlaps 10F <> 20F )

  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/