package scalqa; package General; package Value

trait _Trait

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *   A General value object establishes some concept.
 *
 *   Application classes can have implicit conversions from 'General.Value.type' and use General.Value instead
 *
 *   All General value objects are available at root name space, and can universally be accessed without imports.
 *   This can be beneficial if implicitly mapped functionality has longer names and not as transparent
 *
 *   @example
 *   {{{
 *       val t: Time = CURRENT
 *
 *       val d: Day = CURRENT
 *
 *       // Scalqa.FX examples
 *
 *       new Fx.Label("XYZ") {
 *         alignment = RIGHT
 *       }
 *
 *       new Fx.Pane.Split(HORIZONTAL)
 *
 *       new Fx.Menu {
 *         items =+ SEPARATOR
 *       }
 *   }}}
 */
