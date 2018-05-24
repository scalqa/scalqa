package scalqa; package Sorting; package The

trait DefineImplicitVoid extends Any with DefineImplicitVoidDefault {

  implicit protected def zzSortingJavaComparable = The.JavaComparable
  implicit protected def zzSortingComparable = The.Itself
  implicit protected def zzSortingByte = The.Byte
  implicit protected def zzSortingChar = The.Char
  implicit protected def zzSortingShort = The.Short
  implicit protected def zzSortingLong = The.Long
  implicit protected def zzSortingFloat = The.Float
  implicit protected def zzSortingDouble = The.Double
  implicit protected def zzSortingBoolean = The.Boolean
  implicit protected def zzSortingInt = The.Int

}

private[Sorting] trait DefineImplicitVoidDefault extends Any {

  implicit protected def zzGetSortingAny[A]: Sorting[A] = The.Void.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait DefineImplicitVoid extends ->
 *
 *     Many objects are not sortable, because there is no implicit [[Sorting]] for their type
 *
 *     However, sometimes we need methods with implicit [[Sorting]] compile even for non sortable types
 *
 *     This interface allows to create a scope, where void sorting ([[Sorting.The.Void]]) will be a default
 *
 *     Later, inside the code, void sorting can be handled appropriately
 *
 *   {{{
 *       class MyClass[A](implicit val sorting: Sorting[A])
 *
 *       object VoidInScope extends Sorting.The.DefineImplicitVoid {
 *
 *          new MyClass[Int]().sorting.lp     // Prints: scalqa.Sorting.The.Int
 *          new MyClass[Any]().sorting.lp     // Prints: void
 *          new MyClass[String]().sorting.lp  // Prints: scalqa.Sorting.The.JavaComparable
 *          new MyClass[AnyRef]().sorting.lp  // Prints: void
 *       }
 *       VoidInScope
 *   }}}
 */
