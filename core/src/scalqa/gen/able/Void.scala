package scalqa; package gen; package able

trait Void:

  /**/   def isVoid  : Boolean
  inline def nonVoid : Boolean  = !isVoid

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Void -> ### General Void Able

      Class implementing this interface manifests, that some instance (or instances) will be considered void

      ```

         class Foo extends Able.Void {

             def isVoid = false
         }

      ```


@def isVoid  -> Is void check

      Returns `true` if this instance is void, false othervise

*/
