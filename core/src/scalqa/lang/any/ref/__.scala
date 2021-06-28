package scalqa; package lang; package any; import language.implicitConversions

object Ref:
  @fast lazy val emptyArray : Array[Ref]  = ZZ.emptyObjectArray

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Buffer[A]     = ref.Buffer[A]
  @fast lazy val Custom  = ref.Custom

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Ref -> ###
   Ref type is an alias for scala.AnyRef or java.lang.Object.

   Ref object contains reference type implementations.

@val emptyArray -> Empty object array

    Holds singleton Array[AnyRef] object

*/
