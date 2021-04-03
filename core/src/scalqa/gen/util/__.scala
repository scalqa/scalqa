package scalqa; package gen; import language.implicitConversions

object Util:

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def ByteCount  = util.ByteCount;     type ByteCount          = util.ByteCount.opaque.`type`
  inline def Percent    = util.Percent;       type Percent            = util.Percent.opaque.`type`
  inline def TwoWayFun  = util.TwoWayFun;     type TwoWayFun[A,B]     = util.TwoWayFun[A,B];

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

