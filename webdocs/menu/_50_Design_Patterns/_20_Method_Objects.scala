package Design_Patterns

/**
 *  `Method Objects`
 *
 *  [[Method_Objects Method Object]] is a specially designated private object to hold single method implementation
 *
 *  It reduces crowding of the host type with implementation details
 *
 *  {{{
 *     package MyPackage{
 *
 *       class MyClass {
 *
 *         def search(request: String): String = Z.MyClass.search(this, request)
 *
 *       }
 *
 *       package Z {
 *
 *         package MyClass {
 *
 *           private[MyPackage] object search {
 *
 *             def apply(mc: MyClass, request: String): String = {
 *               // Method Implementation
 *               App.Fail.toDo
 *             }
 *           }
 *         }
 *       }
 *     }
 *  }}}
 *
 *  [[Method_Objects Method object]] must be located in private package 'Z.MyClass' and its name must match the name of the method.
 *  This rule is important in order to produce readable stack traces
 *  {{{
 *    Exception in thread "main" Fail\$ToDo
 *        at MyPackage.Z.MyClass.search\$.apply(Test.scala:23)
 *        at MyPackage.MyClass.search(Test.scala:11)
 *        at Test\$.delayedEndpoint\$Test\$1(Test.scala:3)
 *        at Test\$delayedInit\$body.apply(Test.scala:1)
 *        at scalqa.App._Class.main(_Class.scala:16)
 *        at Test.main(Test.scala)
 *  }}}
 *
 *  Note. In Scalqa [[Method_Objects Method Objects]] occasionally hold several methods if their names start similarly.
 *  The main rule is to make readable stack traces
 */
class Method_Objects { val sort_20 = () }
