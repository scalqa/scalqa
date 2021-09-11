package scalqa; package lang; package any; import language.implicitConversions

object Def:
  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def TypeName = `def`.TypeName; type TypeName[A]  = `def`.TypeName[A]
  transparent inline def Doc      = `def`.Doc;      type Doc[-A]      = `def`.Doc[A]
  transparent inline def Void     = `def`.Void;     type Void[A]      = `def`.Void[A]
  transparent inline def Empty    = `def`.Empty;    type Empty[-A]    = `def`.Empty[A]
  transparent inline def Within   = `def`.Within;   type Within[A,-C] = `def`.Within[A,C]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Def -> ### Any Type Given Definitions


*/
