package scalqa; package test.`val`.stream._use._convert; import language.implicitConversions

object toLookup extends J.Test:

  testEqual_~(
    Lookup(0 -> 'A', 1 -> 'B', 2 -> 'C').pair_~.sort,
    ('A' <> 'C').~.zipKey(_ - 'A').toLookup.pair_~.sort,
    ('A' <> 'C').~.toLookupBy(_ - 'A').pair_~.sort
   )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
