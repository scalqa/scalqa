package scalqa; package lang; package any; package self; import language.implicitConversions

trait Void extends gen.able.Void:
  final def isVoid = true

object Void:
  val ordering: Ordering  [Any] = \/

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Setup[A] = void.Setup[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Void -> ###

Scalqa/Source supports a concept of "void object" ("empty object"), which can be defined for any type.
    This is similar to [[https://en.wikipedia.org/wiki/Null_object_pattern 'Null Object Pattern']]

    Unlike 'null', void object can have X invoked, getting some behavior pertinent to 'voidness'

    Examples:

      - Void [[~.AbstractTrait]] is a singleton object of empty stream, which can be re-used for any type
      - Void [[?]], is a singleton optional value with no value, which can be re-used for any type
      - Void String, is a string of zero length, which can be re-used for String type instead of null

    Void objects have standard way to declare their voidness mixing this trait. Alternatively, [[Able.Void]] trait can be mixed and isVoid test added explicitly

    Types with void values have to define implicit conversions from `\/`

    ```
        class Foo

        object Foo{
          val void = new Foo with Void

          implicit def xxRequest(inline v: \/) = void
        }

        var v: Foo = \/   // Standard void assignment
    ```

    A standard way to test for non voidness is [[Any.^]] method


*/