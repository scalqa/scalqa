package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object reverse extends J.Test:

  testEqualStream(
    (1 <> 100).stream.sortReversed,
    (1 <> 100).stream.reverse,
    (1 <> 100).stream.hideSizeData.reverse)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
