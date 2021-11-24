package scalqa; package test.`val`.stream.Preview; import language.implicitConversions

object next extends J.Test:

  test{
    val s = (1 <> 100).stream.hideSizeData.enablePreview
    val i = (1 <> 100).stream.enablePreview
    assertTrue(s.previewOpt.contains(1))
    assertTrue(i.previewOpt.contains(1))
    assertEqualStream(1 <> 100, s, i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
