package scalqa; package Util

package object Universal
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Universal ->
 *
 *   Universal values establish some concept
 *
 *   Universal values are available at root name space, and can be globally accessed without imports
 *
 *   Application classes and traits can have implicit conversions from Universal value types to local definitions
 *
 *   Using universal instead of local values can reduce and clarify code
 *
 *   {{{
 *       val d: Day = NOW               // vs. val d: Day = Day.now
 *
 *       val t: Time = NOW              // vs. val t: Time = Time.now
 *
 *       t.round(1.Second, UP)          // vs. t.round(1.Second, Custom.Rounding.Up)
 *
 *       t.round(1.Minute, DOWN)        // vs. t.round(1.Minute, Custom.Rounding.Down)
 *
 *       val switch: Boolean = OFF      // vs. val switch: Boolean = false
 *
 *       new Fx.Label("XYZ") {
 *          alignment = RIGHT           // vs. alignment = Fx.Pos.CenterRight
 *       }
 *
 *       new Fx.Pane.Split{
 *          orientation = VERTICAL      // vs. orientation = Fx.Orientation.Vertical
 *       }
 *
 *       new Fx.Menu {
 *          items += SEPARATOR          // vs. items += Fx.Menu.Item.getNewSeparator
 *       }
 *   }}}
 */
