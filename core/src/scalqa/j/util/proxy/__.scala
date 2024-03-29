package scalqa; package j; package util; import language.implicitConversions

trait Proxy[+VALUE]:
  protected def real: VALUE

object Proxy:
  type JavaList[A]   = proxy.JavaList[A]
  type Collection[A] = proxy.Collection[A];   transparent inline def Collection  = proxy.Collection
  type Idx[A]        = proxy.Idx[A];          transparent inline def Idx         = proxy.Idx
  type Lookup[A,B]   = proxy.Lookup[A,B];     transparent inline def Lookup      = proxy.Lookup

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Proxy -> ### Standard Proxy Base

  [[Proxy]] is the root of all provided proxy implementations.  These are used be Scalqa itself and not be usefull for most users.

*/