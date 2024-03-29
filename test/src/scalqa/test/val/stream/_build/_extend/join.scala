package scalqa; package test.`val`.stream._build._extend; import language.implicitConversions

object join extends J.Test("+"):

  testEqualStream(
    (1 to 1000)  :+ 1 :+ 1 :+ 1,
    (1 <> 1000).stream + 1 + 1 + 1)

  testEqualStream("~")(
    (1 to 1000)   ++ (1 to 1000) ++ (1 to 1000),
    (1 <> 1000).stream ++ (1 <> 1000) ++ (1 <> 1000))

  testEqualStream("insert")(
    (1 to 1000).toBuffer.self(b => { b.insert(100, 9); b.insert(200, 9); b.insert(300, 9) }),
    (1 <> 1000).stream +@ (100, 9) +@ (200, 9) +@ (300, 9))

  testEqualStream("insert first")(
    9 +: 9 +: 9 +: (1 to 1000).toList,
    (1 <> 1000).stream +@ (0, 9) +@ (0, 9) +@ (0, 9))

  testEqualStream("insertStream")(
    (1 to 1000).toBuffer.self(b => { b.insertAll(100, 0 to 10); b.insertAll(200, 0 to 10); b.insertAll(300, 0 to 10) }),
    (1 <> 1000).stream ++@ (100, 0 <> 10) ++@ (200, 0 <> 10) ++@ (300, 0 <> 10))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
