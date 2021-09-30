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
    This is similar to [[https://en.wikipedia.org/wiki/Null_object_pattern Null Object Pattern]].

    Unlike "null", void object can have methods invoked, getting some behavior pertinent to 'voidness'

    Examples:

      - Void ~ is a singleton object of empty stream, which can be re-used for any type
      - Void Opt, is a singleton optional value with no value, which can be re-used for any type
      - Void String, is a string of zero length, which can be re-used for String type instead of null
      - scala.Nil is a void instance, re-used for all parameterized scala.List types

    Void objects have a standard way to declare their voidness by mixing this [[scalqa.gen.Void Void]] trait.
    Alternatively, [[scalqa.gen.able.Void Able.Void]] trait can be mixed and `"def isVoid"` test added explicitly.
    For standard opaque types `"def value_isVoid"` has to be overridden in companion object.

    Types with void values have to define implicit conversions from [[scalqa.gen.request.VOID \/]].

    ```
    class Foo

    object Foo:
      val void = new Foo with Void
      implicit inline def implicitRequest(v: \/): Foo = void

    // Standard void assignment is:
    val v: Foo = \/
    ```

    A standard way to test for voidness is universal `.isVoid` method available for [[scalqa.lang.any._Methods all types]] (including opaque).


@def isVoid -> Returns "true"

    Method is final with `true` value hardcoded.

*/
