package scalqa; package lang; package any; import language.implicitConversions

object Def:
  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type TypeName[A]    = `def`.TypeName[A];    transparent inline def TypeName = `def`.TypeName
  type Tag[-A]        = `def`.Tag[A];         transparent inline def Tag      = `def`.Tag
  type Doc[-A]        = `def`.Doc[A]
  type Void[A]        = `def`.Void[A];        transparent inline def Void     = `def`.Void
  type Empty[-A]      = `def`.Empty[A];       transparent inline def Empty    = `def`.Empty
  type Within[A,-C]   = `def`.Within[A,C];    transparent inline def Within   = `def`.Within
  type ToStream[-A,B] = `def`.ToStream[A,B];  transparent inline def ToStream = `def`.ToStream

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Def -> ### Any Type Standard Given Definitions

*/
