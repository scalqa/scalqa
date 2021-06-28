package scalqa; package lang; import language.implicitConversions

object Boolean extends boolean.custom.Framework[Boolean]:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Custom = boolean.Custom
  inline def G      = boolean.G
  type _extension   = boolean._extension;

package boolean:
  private[scalqa] type SELF = Boolean;             private[scalqa] inline def SELF = lang.Boolean
  private[scalqa] type RAW  = Any.Raw.Boolean

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Boolean -> ### Companion for scala.Boolean

    This object also defines specialized custom containers for Boolean type,
    so the following code can run without boxing:

    ```

        val s: Boolean.~    = Boolean.~(true,true,false,false)

        val o: Boolean.Opt  = s.readRaw_? // Holds Boolean.Opt(true)

        val l: Boolean.><   = s.><       // Holds (true,false,false)
    ```
*/