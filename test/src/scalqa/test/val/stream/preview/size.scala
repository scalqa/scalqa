package scalqa; package test.`val`.stream.Preview; import language.implicitConversions

object size extends J.Test:

  test{
    val s = (1 <> 100).~.hideSizeData.enablePreview
    val i = (1 <> 100).~.enablePreview
    assertTrue (s.previewSize >= 100)
    assertTrue (i.previewSize >= 100)
    assertFalse(s.previewSize >= 101)
    assertFalse(i.previewSize >= 101)
    assertEqual_~(1 <> 100, s, i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
