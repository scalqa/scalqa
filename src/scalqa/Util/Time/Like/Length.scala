package scalqa; package Util; package Time; package Like

trait Length[TYPE] extends Any with Core {

  def round(l: Duration, m: Custom.Rounding = \/): TYPE

  def toBrief: String = Z.LengthFormat(this, true)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def toBrief -> Short description.
 *
 *   Converts Length to short String description.
 *
 *   {{{
 *       Duration.make(10.Hours, 15.Seconds, 45.Minutes).brief(1.Minute).lp
 *       // Output
 *       10h, 45m
 *   }}}
 *
 *   @param trimUnit [[Duration]] to round down `this` with.
 *
 */
