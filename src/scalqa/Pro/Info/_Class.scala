package scalqa; package Pro; package Info

class _Class(protected val target: Any, private[scalqa] var customIdOpt: Opt[String] = \/) extends Idx.M.A.Basic[(String, Any)] {

  def +=(v: String): this.type = { add(("", v)); this }
  def +~=(v: ~[String]): this.type = { v(+=); this }

  def allNames: ~[String] = all.map(_._1)
  def allValues: ~[Any] = all.map(_._2)
  def allLabels(separator: String = "="): ~[String] = {
    def toStr(v: Any) = { val s = v.I.toString; if (s.contains(',')) "[" + s + "]" else s }
    all.map(t => if (t._1.isVoid) toStr(t._2) else t._1 + separator + toStr(t._2))
  }

  def names: String = allNames.format(",")
  def values: String = allValues.format(",")
  def labels: String = allLabels().format(",")

  def id: String = customIdOpt or target.I.id
  def id_=(v: String): this.type = { customIdOpt = v.OPT; this }

  def toBrief: String = id + '{' + values + '}'
  def toText: String = (allLabels().format(",\n") + '}').indent(id + '{')

  override def toString = id + '{' + labels + '}'

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class _Class -> `Object Generic Documentation`
 *
 *   To document itself an object should implements [[Any.Able.ToInfo]]
 *
 *    {{{
 *       // Actual scalqa.App.Memory object code
 *       object Memory extends Any.Able.ToInfo {
 *         . . . . . .
 *         def toInfo = new Pro.Info(this, "App.Memory") += ("max", max.toBrief) +=
 *                    ("total", total.toBrief) += ("free", free.toBrief) += ("used", used.toBrief)
 *       }
 *
 *       App.Memory.lp                // Prints App.Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB}
 *
 *       App.Memory.toInfo.toBrief.lp // Prints App.Memory{15.2gB,1.0gB,980.8mB,48.3mB}
 *
 *       App.Memory.toInfo.toText.lp  // Prints App.Memory{max=15.2gB,
 *                                    //                   total=1.0gB,
 *                                    //                   free=980.8mB,
 *                                    //                   used=48.3mB}
 *    }}}
 *
 * @def toBrief -> Brief description
 *
 *     One line object description with tag values without names
 *
 * @def toString -> Description
 *
 *     One line object description
 *
 * @def toText: -> Text description
 *
 *     Multi line description
 */
