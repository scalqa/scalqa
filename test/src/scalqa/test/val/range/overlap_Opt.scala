package scalqa; package test.`val`.range; import language.implicitConversions

object overlap_Opt extends J.Test:

  testEqual_~("common range: Int")(
    1  <> 20 overlap_? 10 <> 30,
    1  <> 30 overlap_? 10 <> 20,
    10 <> 30 overlap_? 1 <> 20)

  testEqual_~("common range: Byte")(
    1.toByte  <> 20.toByte overlap_? 10.toByte <> 30.toByte,
    1.toByte  <> 30.toByte overlap_? 10.toByte <> 20.toByte,
    10.toByte <> 30.toByte overlap_? 1.toByte <> 20.toByte)

  testEqual_~("common range: Float")(
    1F  <> 20F overlap_? 10F <> 30F,
    1F  <> 30F overlap_? 10F <> 20F,
    10F <> 30F overlap_? 1F <> 20F)

  testEqual_~("common range: Long")(
    1L  <> 20L overlap_? 10L <> 30L,
    1L  <> 30L overlap_? 10L <> 20L,
    10L <> 30L overlap_? 1L <> 20L)

  testEqual_~("common range: Ref")(
    "1"  <> "20" overlap_? "10" <> "30",
    "1"  <> "20" overlap_? "10" <> "30",
    "10" <> "30" overlap_? "1"  <> "20")

  testEqual_~("no range: Int")(
    1  <> 10 overlap_? 20 <> 30,
    20 <> 30 overlap_? 1  <> 10)

  testEqual_~("no range: Byte")(
    1.toByte  <> 10.toByte overlap_? 20.toByte <> 30.toByte,
    20.toByte <> 30.toByte overlap_? 1.toByte  <> 10.toByte)

  testEqual_~("no range: Float")(
    1F  <> 10F overlap_? 20F <> 30F,
    20F <> 30F overlap_? 1F  <> 10F)

  testEqual_~("no range: Long")(
    1L  <> 10L overlap_? 20L <> 30L,
    20L <> 30L overlap_? 1L  <> 10L)

  testEqual_~("no range: Ref")(
    "1"  <> "10" overlap_? "20" <> "30",
    "20" <> "30" overlap_? "1"  <> "10")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/