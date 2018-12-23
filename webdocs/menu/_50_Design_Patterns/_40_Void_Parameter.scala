package Design_Patterns

/**
 *  Because of type erasure in Java, some methods cannot be overloaded
 *
 *  Consider:
 *
 *  {{{
 *    class Foo {
 *
 *       def add(v: Double) = App.Fail.toDo
 *
 *       def add(v: Percent) = App.Fail.toDo
 *
 *     }
 *  }}}
 *
 *  Class Foo will not compile, because Percent is AnyVal with Double value, and it is erased to Double
 *
 *  The solution is to add a void parameter, which will not affect usage
 *
 *  {{{
 *    class Foo {
 *
 *       def add(v: Double) = App.Fail.toDo
 *
 *       def add(v: Percent, V: \/ = \/) = App.Fail.toDo
 *
 *     }
 *  }}}
 */
class Void_Parameter { val sort_40 = () }
