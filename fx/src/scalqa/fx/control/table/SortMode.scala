package scalqa; package fx; package control; package table; import language.implicitConversions

enum SortMode:
  case Void extends SortMode with Gen.Void
  case Direct, ProxyWithUnsorted, ProxyNoUnsorted

  def isDirect            : Boolean = this == SortMode.Direct
  def isProxyWithUnsorted : Boolean = this == SortMode.ProxyWithUnsorted
  def isProxyNoUnsorted   : Boolean = this == SortMode.ProxyNoUnsorted
  def isProxy             : Boolean = isProxyWithUnsorted || isProxyNoUnsorted

object SortMode extends EnumCompanion[SortMode]:
  implicit inline def implicitRequest(v: \/): SortMode = SortMode.Void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
