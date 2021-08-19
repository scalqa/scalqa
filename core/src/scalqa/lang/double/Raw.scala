package scalqa; package lang; package double; import language.implicitConversions

object Raw:

  // *************************************************
  trait Specialized extends Any.Raw.Specialized:
    inline def specializedFor = "Double"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw ->

  Double.Raw is a union type, which is either a Double or Double.Opaque.  Double generic containers are based on Raw type.

  The definition is as following:
  ```
  object Double:
    type Raw = Double | Double.Opaque
  ```

@trait Specialized ->

  Trait to mix with a class to indicate Double specialized implementation.

  Generally, Specialized marker is for information only and is not required for processing.

@def specializedFor -> returns "Double"

*/
