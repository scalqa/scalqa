package scalqa; package lang; import language.implicitConversions

object Boolean extends boolean.g.companion.Containers[Boolean]:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Opaque   = boolean.Opaque.TYPE.DEF;   transparent inline def Opaque = boolean.Opaque
  type _methods = boolean._methods;          transparent inline def G      = boolean.G

package object boolean:
  private[lang] type Primitive = Boolean
  private[lang] type Raw       = Any.Boolean
  private[lang] type Opaque    = Boolean.Opaque

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