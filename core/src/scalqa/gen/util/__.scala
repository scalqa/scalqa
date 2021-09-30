package scalqa; package gen; import language.implicitConversions

object Util:

  transparent inline def ByteCount      = util.ByteCount;       type ByteCount                              = util.ByteCount.TYPE.DEF
  transparent inline def Percent        = util.Percent;         type Percent                                = util.Percent.TYPE.DEF
  transparent inline def TwoWayFunction = util.TwoWayFunction;  type TwoWayFunction[A,B]                    = util.TwoWayFunction[A,B]
  /**/                                                          type EnumCompanion[A <: scala.reflect.Enum] = util.EnumCompanion[A]
  transparent inline def Extension      = util.Extension

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

