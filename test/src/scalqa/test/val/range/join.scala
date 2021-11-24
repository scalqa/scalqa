package scalqa; package test.`val`.range; import language.implicitConversions

object join extends J.Test:

  testEqualStream("Int")(
    3 <> 5  join 1 join 8,
    3 <> 5  join 1 <> 8,
    1 <> 8 join 3 <> 5,
    5 <> 8 join 1 <> 3)

  testEqualStream("Byte")(
    3.toByte <> 5.toByte  join  1.toByte join 8.toByte,
    3.toByte <> 5.toByte  join  1.toByte <> 8.toByte,
    1.toByte <> 8.toByte  join  3.toByte <> 5.toByte,
    5.toByte <> 8.toByte  join  1.toByte <> 3.toByte)

  testEqualStream("Short")(
    3.toShort <> 5.toShort  join  1.toShort join 8.toShort,
    3.toShort <> 5.toShort  join  1.toShort <> 8.toShort,
    1.toShort <> 8.toShort  join  3.toShort <> 5.toShort,
    5.toShort <> 8.toShort  join  1.toShort <> 3.toShort)

  testEqualStream("Long")(
    3L <> 5L join 1L join 8L,
    3L <> 5L join 1L <> 8L,
    1L <> 8L join 3L <> 5L,
    5L <> 8L join 1L <> 3L)

  implicit def toStream(v: Float.Range): Stream[Float] = v.streamStep(_ + 1)
  testEqualStream("Float")(
    3F <> 5F join 1F join 8F,
    3F <> 5F join 1F <> 8F,
    1F <> 8F join 3F <> 5F,
    5F <> 8F join 1F <> 3F)

  implicit def toStream(v: Range[String]): Stream[String] = v.streamStep(v => (v.toInt + 1).toString)
  testEqualStream("String")(
    "3" <> "5" join "1" join "8",
    "3" <> "5" join "1" <> "8"  ,
    "1" <> "8" join "3" <> "5"  ,
    "5" <> "8" join "1" <> "3"  )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/