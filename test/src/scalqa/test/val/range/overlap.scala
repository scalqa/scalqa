package scalqa; package test.`val`.range; import language.implicitConversions

object overlap extends J.Test:

  test_~("common range")(
    1  <> 20 overlap_? 10 <> 30,
    1  <> 20 overlap_? 10 <> 30,
    10 <> 30 overlap_? 1 <> 20)

  test_~("no range")(
    1  <> 10 overlap_? 20 <> 30,
    20 <> 30 overlap_? 1  <> 10)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/