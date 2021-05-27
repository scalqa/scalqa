package scalqa; package test.`val`.stream._build._parallel; import language.implicitConversions

object parallelIfOver extends J.Test:

  test{
    assertTrue((1 <> 101).~.parallelIfOver(100).isParallel)
    assertTrue((1 <> 101).~.hideSizeData.parallelIfOver(100).isParallel)
    assertTrue((1 <> 100).~.parallelIfOver(100).isParallel.not)
    assertTrue((1 <> 100).~.hideSizeData.parallelIfOver(100).isParallel.not)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
