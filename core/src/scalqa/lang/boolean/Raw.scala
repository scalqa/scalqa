package scalqa; package lang; package boolean; import language.implicitConversions

object Raw:

  // *************************************************
  trait Specialized extends Any.Raw.Specialized:
    type SPECIALIZED_FOR = Boolean

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw ->

  Boolean.Raw is a union type, which is either a Boolean or Boolean.Opaque.  Boolean generic containers are based on Raw type.

  The definition is as following:
  ```
  object Boolean:
    type Raw = Boolean | Boolean.Opaque
  ```

@trait Specialized ->

  Trait to mix with a class to indicate Boolean specialized implementation.

  Generally, Specialized marker is for information only and is not required for processing.

*/
