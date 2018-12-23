package Features

/**
 *  Scalqa universally supports a concept of "void object", which can be defined for any type.
 *  This is similar to [[https://en.wikipedia.org/wiki/Null_object_pattern 'Null Object Pattern']]
 *
 *  Unlike 'null', void object can have methods invoked, getting some behavior pertinent to 'voidness'
 *
 *  Many standard Scalqa types define void implementations:
 *  {{{
 *    val v: Idx[Int] = \/    // Void indexed collection of Int
 *
 *    v.isVoid lp             // Prints: true
 *
 *    v.size lp               // Prints 0
 *
 *    v.all lp                // Prints ~(), which is void Stream of elements
 *
 *    var i: Int = \/
 *    var t: Time = \/
 *    var p: ~[Int] = \/
 *    var o: Opt[String] = \/
 *  }}}
 *
 *  Defining a void instance is easy:
 *
 *  {{{
 *
 *     class Foo
 *
 *     object Foo{
 *       val Void = new Foo with Void
 *
 *       implicit def zzMake(v: \/) = Void
 *     }
 *
 *     var x: Foo = \/
 *  }}}
 *
 *  Generally, any instance is void if it implements [[scalqa.Any.Able.Void Any.Able.Void]] with 'isVoid' method returning 'true'
 */
class Void_Objects { val sort_25 = () }
