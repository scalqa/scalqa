package scalqa; package lang; package any; import language.implicitConversions

object Raw:

  trait Specialized private[lang]():

    def specializedFor: String

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw -> ###

  Any.Raw type is defined as
  ```
  object Any:
    type Raw = Boolean.Raw | Byte.Raw | Char.Raw | Short.Raw | Int.Raw | Long.Raw | Float.Raw | Double.Raw
  ```

@trait Specialized -> ###

  Specialized is the root of traits like: Byte.Raw.Specialized, Int.Raw.Specialized, etc., which indicate implementations with unboxed processing.

  Generally, Specialized marker is for information only and is not required for processing.

@def specializedFor -> Name

  Returns primitive name, like "Boolean", "Byte", etc

*/

