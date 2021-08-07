package scalqa; package lang; import language.implicitConversions

object Boolean extends boolean.g.customized.Containers[Boolean]:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _methods = boolean._methods;          transparent inline def G      = boolean.G
  type Opaque   = boolean.Opaque;            transparent inline def Opaque = boolean.Opaque
  type Raw      = Boolean | boolean.Opaque;  transparent inline def Raw    = boolean.Raw

package object boolean:
  type Raw    = Boolean.Raw
  opaque type Opaque >: Boolean <: AnyVal = Boolean

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Boolean -> ### Companion Object for scala.Boolean

    This object also defines specialized custom containers for Boolean type,
    so the following code can run without boxing:

    ```

        val s: Boolean.~    = Boolean.~(true,true,false,false)

        val o: Boolean.Opt  = s.readRaw_? // Holds Boolean.Opt(true)

        val l: Boolean.><   = s.><       // Holds (true,false,false)
    ```
*/