package Design_Patterns

/**
 *  Rule: `Implicit conversions should only be called implicitly`
 *
 *  There are two types of implicits: implicit values and implicit conversions
 *
 *  Implicit conversions are the troublesome type, which should only be used after careful consideration
 *
 *  To prevent misuse, all Scalqa implicit method names start with 'zz' and they are never called directly (only implicitly)
 *
 *  {{{
 *    implicit def zzStream[A](c: Any.Collection[A]) = c.all
 *
 *    implicit def zzLibrary[A](v: Any.Collection[A]) = new _library(v)
 *  }}}
 *
 *  The prefix "zz" also brings them down any syntax lookup list, so they are not a hurdle
 *
 *  Occasionally there are explicit and implicit methods for the same functionality and there are two methods for the same thing. But overall implicit conversions live in their own use domain
 *
 */
class Implicit_Conversions { val sort_15 = () }
