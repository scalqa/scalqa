package Design_Patterns

/**
 *  Rule: `Non public types and objects must be located in special sub-packages with name 'Z' `
 *
 *  The common practice is to mix public and non public types in the same package, which can be annoying in many ways
 *
 *  In Scalqa, privates are moved to a sub-package with name 'Z'
 *
 *  {{{
 *     package MyPackage{
 *
 *       class MyClass {
 *
 *         def search(request: String): String = Z.search(this, request)
 *
 *       }
 *
 *       package Z {
 *
 *         private[MyPackage] object search {  // Private method object
 *
 *           def apply(mc: MyClass, request: String): String = App.Fail.toDo
 *
 *         }
 *       }
 *     }
 *  }}}
 *
 *  Why 'Z'?
 *
 *  It is the last letter, so the private package will stick out from the rest
 *
 *  Private package 'Z' can be created, if required, in every public package, or it can be shared by several related public packages.
 *  In latter 'Z' usually has sub-packages too, reflecting the public peers
 *
 *  All members of 'Z' packages must be non public, so the package itself will not even appear in ScalaDoc
 *
 *  'Z' packages proved to be helpful when reading stack traces in two ways:
 *
 *    - It is immediately obvious, what is public and what is not
 *    - 'Z' packages can hold full implementations.
 *      Traditionally packages like `com.sun.java.util` for `java.util` were created, mixing stack trace picture
 *
 */
class Private_Packages { val sort_30 = () }
