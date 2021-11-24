package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object preview extends J.Test:

  test{
    def s = (1 <> 100).stream.hideSizeData.enablePreview
    def i = (1 <> 100).stream.enablePreview
    assertEqualStream(1 <> 10, s.previewStream(10), i.previewStream(10))
    assertEqualStream(1 <> 100, s, i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
