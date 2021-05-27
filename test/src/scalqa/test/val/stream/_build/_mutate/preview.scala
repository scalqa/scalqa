package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object preview extends J.Test:

  test{
    def s = (1 <> 100).~.hideSizeData.enablePreview
    def i = (1 <> 100).~.enablePreview
    assertEqual_~(1 <> 10, s.preview_~(10), i.preview_~(10))
    assertEqual_~(1 <> 100, s, i)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
