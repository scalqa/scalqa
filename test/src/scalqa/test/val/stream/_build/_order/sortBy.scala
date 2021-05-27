package scalqa; package test.`val`.stream._build._order; import language.implicitConversions

object sortBy extends J.Test:

  test_~(
    (1 to 1000).sortBy(v => -v),
    (1 <> 1000).~.reverseEvery(3).sortBy(v => -v))

  test_~("two")(
    (1 to 1000).sortBy(v => -v),
    (1 <> 1000).~.reverseEvery(3).sortBy(_ => 0, v => -v))

  test_~("three")(
    (1 to 1000).sortBy(v => -v),
    (1 <> 1000).~.reverseEvery(3).sortBy(_ => 0, _ => 0, v => -v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
