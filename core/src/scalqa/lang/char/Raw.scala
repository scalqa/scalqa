package scalqa; package lang; package char; import language.implicitConversions

object Raw:

  // *************************************************
  trait Specialized extends Any.Raw.Specialized:
    inline def specializedFor = "Char"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw ->

  Char.Raw is a union type, which is either a Char or Char.Opaque.  Char generic containers are based on Raw type.

  The definition is as following:
  ```
  object Char:
    type Raw = Char | Char.Opaque
  ```

@trait Specialized ->

  Trait to mix with a class to indicate Char specialized implementation.

  Generally, Specialized marker is for information only and is not required for processing.

@def specializedFor -> returns "Char"

*/
