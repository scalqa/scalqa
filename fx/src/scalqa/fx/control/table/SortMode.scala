package scalqa; package fx; package control; package table; import language.implicitConversions

enum SortMode:
  case Void extends SortMode with Gen.Void
  case Direct, ProxyWithUnsorted, ProxyNoUnsorted

object SortMode extends EnumCompanion[SortMode]:

  extension (inline x: SortMode)
    inline def isDirect            : Boolean = x == SortMode.Direct
    inline def isProxyWithUnsorted : Boolean = x == SortMode.ProxyWithUnsorted
    inline def isProxyNoUnsorted   : Boolean = x == SortMode.ProxyNoUnsorted
    inline def isProxy             : Boolean = {val v=x; v.isProxyWithUnsorted || v.isProxyNoUnsorted}

  implicit inline def implicitFrom(v:VOID): SortMode = SortMode.Void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
