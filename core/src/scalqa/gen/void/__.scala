package scalqa; package gen; import language.implicitConversions

trait Void extends gen.able.Void:
  final def isVoid = true

object Void:
  val ordering: Ordering  [Any] = \/

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Setup[A] = void.Setup[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Void -> ### General Void

    Scalqa supports a concept of "void object" ("empty object"), which can be defined for any type.
    This is similar to [[https://en.wikipedia.org/wiki/Null_object_pattern Null Object Pattern]]

    Unlike 'null', void object can have methods invoked, getting some behavior pertinent to 'voidness'

    Examples:

      - Void ~ is a singleton object of empty stream, which can be re-used for any type
      - Void Opt, is a singleton optional value with no value, which can be re-used for any type
      - Void String, is a string of zero length, which can be re-used for String type instead of null

    Void objects have a standard way to declare their voidness by mixing this trait. Alternatively, [[Able.Void]] trait can be mixed and isVoid test added explicitly

    Types with void values have to define implicit conversions from `\/`

    ```
        class Foo

        object Foo{
          val void = new Foo with Gen.Void

          implicit def implicitRequest(inline v: \/) = void
        }

        var v: Foo = \/   // Standard void assignment
    ```

    A standard way to test for non voidness is [[<any>.^.isVoid]] method

*/
