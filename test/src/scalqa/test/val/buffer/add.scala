package scalqa; package test.`val`.buffer; import language.implicitConversions

object add extends J.Test:

  def stream                : Stream[Int]      = 1 <> 10
  def buffer(initSize: Int) : Buffer[Int] = Buffer[Int](initSize).self(_ ++= stream)

  testEqualStream("1")(
    buffer(25) ++@= (8, 20 <> 24),
    stream     ++@  (8, 20 <> 24))

  testEqualStream("2")(
    buffer(15) ++@= (8, 20 <> 24),
    stream     ++@  (8, 20 <> 24))

  testEqualStream("3")(
    buffer(25) ++@= (2, 20 <> 24),
    stream     ++@  (2, 20 <> 24))

  testEqualStream("4")(
    buffer(15) ++@= (2, 20 <> 24),
    stream     ++@  (2, 20 <> 24))


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/