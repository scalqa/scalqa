package scalqa; package gen; package able

trait Void:

  def isVoid: Boolean

object Void:

  extension(inline x: Void)
    inline def nonVoid: Boolean = !x.isVoid

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def isVoid -> Is void check

      Returns `true` if this instance is void, false othervise

@def nonVoid -> Is non void check

      Returns `true` if this instance is not void, false othervise

@trait Void -> ### General Void Able

      Class mixing this trait manifests, that some instance (or instances) will be considered void.

      ```
      class Foo extends Able.Void:
         def isVoid = false
      ```

      See [[scalqa.gen.Void Gen.Void]] for more info.
*/
