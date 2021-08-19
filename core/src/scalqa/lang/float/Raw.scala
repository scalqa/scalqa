package scalqa; package lang; package float; import language.implicitConversions

object Raw:

  // *************************************************
  trait Specialized extends Any.Raw.Specialized:
    inline def specializedFor = "Float"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw ->

  Float.Raw is a union type, which is either a Float or Float.Opaque.  Float generic containers are based on Raw type.

  The definition is as following:
  ```
  object Float:
    type Raw = Float | Float.Opaque
  ```

@trait Specialized ->

  Trait to mix with a class to indicate Float specialized implementation.

  Generally, Specialized marker is for information only and is not required for processing.

@def specializedFor -> returns "Float"

*/
