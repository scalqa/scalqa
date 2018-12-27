package Design_Patterns

/**
 *  In Scala there are usually `apply` factory methods in the companion objects
 *
 *  In Scalqa the 'apply' factory methods cannot be used universally, because `apply` reduction would not work for [[POP.Package_Type package types]], where companion object is package object
 *
 *  If `apply` is used today for a simple class, and the class gets promoted to a [[POP.Package_Type package type]] later, this will break existing code
 *
 *  By default 'apply' method is replaced with 'make' or something else more appropriate
 *
 *  Compare:
 *
 *  {{{
 *     val scala  = List(1, 2, 3)
 *
 *     // vs.
 *
 *     val scalqa = Idx.*(1, 2, 3)
 *
 *     // --------------------------
 *     val scalaBuffer  = collection.mutable.Buffer.empty[Int]
 *
 *     // vs.
 *
 *     val scalqaBuffer = Idx.M.make[Int]
 *  }}}
 *
 *  Note: For really simple utility classes `apply` can still be used. This is the case for some popular classes in [[scalqa.Util scalqa utilities]]
 */
class No_Apply_Constructors { val sort_05 = () }
