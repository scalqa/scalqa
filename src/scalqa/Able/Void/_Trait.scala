package scalqa; package Able; package Void

trait _Trait extends Any {

  protected def isVoid: Boolean = false

}

private[scalqa] object _Trait {

  @inline def isVoid(t: _Trait) = t.isVoid

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''General Void Able '''
 *
 *     Class implementing this interface manifests, that some instance (or instances) will be considered void
 *
 * @def isVoid: -> Returns true if current instance is void.
 *
 *
 */
