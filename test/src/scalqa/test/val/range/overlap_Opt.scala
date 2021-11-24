package scalqa; package test.`val`.range; import language.implicitConversions

object overlapOpt extends J.Test:

  testEqualStream("common range: Int")(
    1  <> 20 overlapOpt 10 <> 30,
    1  <> 30 overlapOpt 10 <> 20,
    10 <> 30 overlapOpt 1 <> 20)

  testEqualStream("common range: Byte")(
    1.toByte  <> 20.toByte overlapOpt 10.toByte <> 30.toByte,
    1.toByte  <> 30.toByte overlapOpt 10.toByte <> 20.toByte,
    10.toByte <> 30.toByte overlapOpt 1.toByte <> 20.toByte)

  testEqualStream("common range: Float")(
    1F  <> 20F overlapOpt 10F <> 30F,
    1F  <> 30F overlapOpt 10F <> 20F,
    10F <> 30F overlapOpt 1F <> 20F)

  testEqualStream("common range: Long")(
    1L  <> 20L overlapOpt 10L <> 30L,
    1L  <> 30L overlapOpt 10L <> 20L,
    10L <> 30L overlapOpt 1L <> 20L)

  testEqualStream("common range: Ref")(
    "1"  <> "20" overlapOpt "10" <> "30",
    "1"  <> "20" overlapOpt "10" <> "30",
    "10" <> "30" overlapOpt "1"  <> "20")

  testEqualStream("no range: Int")(
    1  <> 10 overlapOpt 20 <> 30,
    20 <> 30 overlapOpt 1  <> 10)

  testEqualStream("no range: Byte")(
    1.toByte  <> 10.toByte overlapOpt 20.toByte <> 30.toByte,
    20.toByte <> 30.toByte overlapOpt 1.toByte  <> 10.toByte)

  testEqualStream("no range: Float")(
    1F  <> 10F overlapOpt 20F <> 30F,
    20F <> 30F overlapOpt 1F  <> 10F)

  testEqualStream("no range: Long")(
    1L  <> 10L overlapOpt 20L <> 30L,
    20L <> 30L overlapOpt 1L  <> 10L)

  testEqualStream("no range: Ref")(
    "1"  <> "10" overlapOpt "20" <> "30",
    "20" <> "30" overlapOpt "1"  <> "10")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/