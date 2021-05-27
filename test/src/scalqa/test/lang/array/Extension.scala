package scalqa; package test.lang.array; import language.implicitConversions

object Extension extends J.Test:

  test_~("fill")(
    new Array[Int](10).^(a => { a.fill(1); a.fill_<>(0 <>> 5, 2) }),
    new Array[Int](10).^(a => { a.fill(2); a.fill_<>(5 <>= 5, 1) }))

  test_~("sort")(
    (1 <> 10).~.toArray,
    (1 <> 10).~.reverseEvery(3).toArray.^(_.sort))

  test_~("addAllAt")(
    (1 <> 10).~.toArray ++@ (5, 100 <> 111),
    (1 <> 10).~         ++@ (5, 100 <> 111))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/