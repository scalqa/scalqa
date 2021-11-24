package scalqa; package test.`val`.stream.Preview; import language.implicitConversions

object readWhile_Stream extends J.Test("readWhileStream"):

  test{
    val s = (1 <> 100).stream.hideSizeData.enablePreview
    val i = (1 <> 100).stream.enablePreview
    assertEqualStream(
      1 to 49,
      s.readWhileStream(_ < 50),
      i.readWhileStream(_ < 50))
    assertEqualStream(
      50 to 100,
      s,
      i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
