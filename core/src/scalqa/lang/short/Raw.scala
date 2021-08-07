package scalqa; package lang; package short; import language.implicitConversions

object Raw:

  // *************************************************
  trait Specialized extends Any.Raw.Specialized:
    type SPECIALIZED_FOR = Short

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw ->

  Short.Raw is a union type, which is either a Short or Short.Opaque.  Short generic containers are based on Raw type.

  The definition is as following:
  ```
  object Short:
    type Raw = Short | Short.Opaque
  ```

@trait Specialized ->

  Trait to mix with a class to indicate Short specialized implementation.

  Generally, Specialized marker is for information only and is not required for processing.

*/
