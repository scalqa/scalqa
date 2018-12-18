package scalqa; package Any; package Able

trait ToInfo extends Any with ToText with ToString {

  def toInfo: Pro.Info

  def toText: String = toInfo.toText

  override def toString = toInfo.toString

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @trait ToInfo -> `Self Documentation`
 *
 *   [[Any.Able.ToInfo]] allows any object to document itself
 *
 *    {{{
 *       // Actual scalqa.App.Memory object code
 *       object Memory extends Any.Able.ToInfo {
 *         private def rt = Runtime.getRuntime
 *         def total: ByteSize = rt.totalMemory
 *         def max: ByteSize = rt.maxMemory
 *         def free: ByteSize = rt.freeMemory
 *         def used: ByteSize = total - free
 *         def gc: Unit = java.lang.System.gc
 *
 *         def toInfo = new Pro.Info(this) += ("max", max) += ("total", total) += ("free", free) += ("used", used)
 *       }
 *
 *       App.Memory.lp                 // Prints: App.Memory{max=15.2g,total=1.0g,free=985.8m,used=43.3m}
 *
 *       App.Memory.toInfo.toBrief.lp  // Prints: App.Memory{15.2gB,1.0gB,986.2mB,42.9mB}
 *
 *       App.Memory.toInfo.toText.lp   // Prints: App.Memory{max=15.2g,
 *                                     //                    total=1.0g,
 *                                     //                    free=985.8m,
 *                                     //                    used=43.3m}
 *    }}}
 *
 * @def toInfo: -> Info
 *
 *     Returns [[Pro.Info]] object, loaded with property names and values describing this instance
 *
 * @def toString -> Custom single line description
 *
 *     If not overridden further, toString returns toInfo.toString
 */
