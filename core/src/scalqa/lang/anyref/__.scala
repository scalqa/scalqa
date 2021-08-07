package scalqa; package lang; import language.implicitConversions

object AnyRef:
  @fast lazy val emptyArray : Array[AnyRef]  = ZZ.emptyObjectArray

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def G       = anyref.G
  transparent inline def Opaque  = anyref.Opaque;     type Opaque = anyref.Opaque

package object anyref:
  opaque type Opaque <: AnyRef = AnyRef

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object AnyRef -> ###
   AnyRef type is an alias for java.lang.Object.

   AnyRef object contains reference type implementations.

@val emptyArray -> Empty object array

    Holds singleton Array[AnyRef] object

*/
