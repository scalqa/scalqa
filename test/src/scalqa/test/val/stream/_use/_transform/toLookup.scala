package scalqa; package test.`val`.stream._use._transform; import language.implicitConversions

object toLookup extends J.Test:

  testEqualStream(
    Lookup(0 -> 'A', 1 -> 'B', 2 -> 'C').pairStream.sort,
    ('A' <> 'C').stream.zipKey(_ - 'A').toLookup.pairStream.sort,
    ('A' <> 'C').stream.toLookupBy(_ - 'A').pairStream.sort
   )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
