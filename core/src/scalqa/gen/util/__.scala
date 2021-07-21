package scalqa; package gen; import language.implicitConversions

object Util:

  transparent inline def ByteCount          = util.ByteCount;           type ByteCount                              = util.ByteCount.opaque.`type`
  transparent inline def Percent            = util.Percent;             type Percent                                = util.Percent.opaque.`type`
  transparent inline def ReversibleFunction = util.ReversibleFunction;  type ReversibleFunction[A,B]                = util.ReversibleFunction[A,B]
  /**/                                                                  type EnumCompanion[A <: scala.reflect.Enum] = util.EnumCompanion[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

