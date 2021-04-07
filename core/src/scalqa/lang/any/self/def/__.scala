package scalqa; package lang; package any; package self; import language.implicitConversions

object Def:

  type Name[A]   = `def`.Name[A];    inline def Name   = `def`.Name
  type Doc[-A]   = `def`.Doc[A];     inline def Doc    = `def`.Doc
  type Void[A]   = `def`.Void[A];    inline def Void   = `def`.Void
  type Empty[-A] = `def`.Empty[A];   inline def Empty  = `def`.Empty
  type In[A,-C]  = `def`.In[A,C];    inline def In     = `def`.In

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Def -> ### Type Implicit Definitions

    Contans a set of interfaces, which can be given (implicitly) for any type

*/
