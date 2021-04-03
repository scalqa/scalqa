package scalqa; package test.Val.Stream._build._filter; import language.implicitConversions

object takeInterval extends J.Test("take_<>"):

  test_~(
    (30 to 60),
    (0 <> 100).~.take_<>(30 <> 60))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
