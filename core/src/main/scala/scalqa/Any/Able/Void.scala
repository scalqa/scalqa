package scalqa; package Any; package Able

trait Void extends Any {

  @inline def isVoid: Boolean = false

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Void -> `General Void Able `
 *
 *    Class implementing this interface manifests, that some instance (or instances) will be considered void
 *
 *    {{{
 *
 *       class Foo extends Any.Able.Void {
 *
 *           override def isVoid = true
 *       }
 *
 *       Any.isVoid(new Foo()).lp   // Prints true
 *
 *    }}}
 *
 *    Note. By default `isVoid` returns `false` and it has to be overridden for void values
 *
 * @def isVoid: -> Void check
 *
 *    Returns `true` if this instance is void
 */
