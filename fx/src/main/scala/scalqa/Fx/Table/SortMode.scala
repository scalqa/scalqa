package scalqa; package Fx; package Table

sealed class SortMode private extends Util.Enum[SortMode](SortMode) {

  def isDirect = this == SortMode.Direct

  def isProxyWithUnsorted = this == SortMode.ProxyWithUnsorted

  def isProxyNoUnsorted = this == SortMode.ProxyNoUnsorted

  def isProxy = isProxyWithUnsorted || isProxyNoUnsorted

}

object SortMode extends Util.Enum.Setup[SortMode] {

  val Void = new SortMode with Void
  val Direct, ProxyWithUnsorted, ProxyNoUnsorted = new SortMode

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
