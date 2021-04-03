package scalqa; package gen; package time; import language.implicitConversions

object X:
  type Base  [A<:Any.Raw.Long] = x.Base[A];
  type Nanos [A<:Any.Raw.Long] = x.Nanos[A];    inline def Nanos  = x.Nanos
  type Millis[A<:Any.Raw.Long] = x.Millis[A];   inline def Millis = x.Millis

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/