package scalqa; package test.`val`.range; import language.implicitConversions

object contains extends J.Test:

  test {

    assertTrue(  1 <>  2 contains 1 <> 2 )
    assertFalse( 1 <>> 2 contains 1 <> 2 )

    assertTrue(  1.toByte <>  2.toByte contains 1.toByte <> 2.toByte )
    assertFalse( 1.toByte <>> 2.toByte contains 1.toByte <> 2.toByte )

    assertTrue(  1L <>  2L contains 1L <> 2L )
    assertFalse( 1L <>> 2L contains 1L <> 2L )

    assertTrue(  1F <>  2F contains 1F <> 2F )
    assertFalse( 1F <>> 2F contains 1F <> 2F )

    assertTrue(  "1" <>  "2" contains "1" <> "2" )
    assertFalse( "1" <>> "2" contains "1" <> "2" )

  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/