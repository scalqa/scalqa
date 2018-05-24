package scalqa; package General.Tool

object Assert {

  @inline def apply(b: Boolean, message: => Any = \/): Unit = assert(b, message)

  @inline def not(b: Boolean, message: => Any = \/): Unit = assert(!b, message)

  @inline def void[T](value: T, message: => Any = "Value is not void"): T = { assert(value.isVoid, message); value }

  @inline def notVoid[T](value: T, message: => Any = "Value is void"): T = { assert(value.isVoid.not, message); value }

  @inline def notNull[T](value: T, message: => Any = "Value is null"): T = { assert(value != null, message); value }

  @inline def idxSized(position: Int, size: Int): Int = { assert(position >= 0 && position < size, Fail.idxSized(position, size)); position }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Assert ->
 *
 *     [[Assert]] is an enriched shortcut to Scala's ''assert'' statement
 *
 *     All methods are (hopefully) in-lined, so, there should not be any performance penalty
 *
 * @def apply -> Assert
 *
 *     In-lined shortcut to Scala's ''assert''
 *
 * @def not( -> Assert negative
 *
 *     Inverse apply
 *
 * @def idxSized -> Validate index
 *
 *     Validates index position against collection size
 *
 *     Fails if (position<0 || position >= size)
 *
 *     Returns position itself
 *      @example
 *     {{{
 *        private val x = Index.W.get[Char]
 *
 *        def deleteCharAt(i: Int) = x.removeAt(Assert.idxSized(i,x.size))
 *     }}}
 *
 * @def void -> Assert void
 *
 *     Fails if passed value is not void
 *
 *     Returns value itself
 *      @example
 *     {{{
 *         private var name: String = null
 *
 *         def initName(v :String){
 *           Assert.void(name,"Name is already initialized")
 *           name = v
 *        }
 *     }}}
 *
 * @def notVoid -> Assert not void
 *
 *     Fails if passed value is void
 *
 *     Returns value itself
 *      @example
 *     {{{
 *         def printNonVoid(v :String) : Unit = Print(Assert.notVoid(v))
 *     }}}
 *
 * @def notNull -> Assert not null
 *
 *     Fails if passed value is null
 *
 *     Returns value itself
 *     @example
 *     {{{
 *         def printNonNull(v :String) : Unit = Print(Assert.notNull(v))
 *     }}}
 */
