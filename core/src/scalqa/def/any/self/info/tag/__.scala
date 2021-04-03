package scalqa; package `def`; package any; package self; package `info`; import language.implicitConversions

object Tag:
  type Type[A]   = tag.Type[A];  inline def Type  = tag.Type
  type Doc[-A]   = tag.Doc[A];   inline def Doc   = tag.Doc
  type Void[A]   = tag.Void[A];  inline def Void  = tag.Void
  type Empty[-A] = tag.Empty[A]; inline def Empty = tag.Empty
  type In[A,-C]  = tag.In[A,C];  inline def In    = tag.In
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
