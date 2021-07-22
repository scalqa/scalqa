package scalqa; package test.`val`.stream._build._mutate; import language.implicitConversions

object reverse extends J.Test:

  testEqual_~(
    (1 <> 100).~.sortReversed,
    (1 <> 100).~.reverse,
    (1 <> 100).~.hideSizeData.reverse)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
