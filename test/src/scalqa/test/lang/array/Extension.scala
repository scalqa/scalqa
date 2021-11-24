package scalqa; package test.lang.array; import language.implicitConversions

object Extension extends J.Test:

  testEqualStream("fill")(
    new Array[Int](10).self(a => { a.fill(1); a.fillRange(0 <>> 5, 2) }),
    new Array[Int](10).self(a => { a.fill(2); a.fillRange(5 <>= 5, 1) }))

  testEqualStream("sort")(
    (1 <> 10).stream.toArray,
    (1 <> 10).stream.reverseEvery(3).toArray.self(_.sort))

  testEqualStream("addAllAt")(
    (1 <> 10).stream.toArray ++@ (5, 100 <> 111),
    (1 <> 10).stream         ++@ (5, 100 <> 111))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/