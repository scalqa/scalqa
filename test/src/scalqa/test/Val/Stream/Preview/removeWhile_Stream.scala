package scalqa; package test.Val.Stream.Preview; import language.implicitConversions

object readWhile_Stream extends J.Test("readWhile_~"):

  test{
    val s = (1 <> 100).~.hideSizeData.enablePreview
    val i = (1 <> 100).~.enablePreview
    assertEqual_~(
      1 to 49,
      s.readWhile_~(_ < 50),
      i.readWhile_~(_ < 50))
    assertEqual_~(
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
