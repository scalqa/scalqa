package scalqa; package Able; package Info

trait _Trait extends Any {

  protected def info: Pipe[(Any, Any)]

  protected def infoLabel: String = this.Class.lastName

  protected def infoLine: String = _Trait.properties(this).infoLine(infoLabel)

  protected def infoText: String.Text = _Trait.properties(this).infoText(infoLabel)

}

private[scalqa] object _Trait {
  def properties(v: _Trait) = new Properties(v.info)
  def line(v: _Trait): String = v.infoLine
  def text(v: _Trait): String.Text = v.infoText
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @trait _Trait -> '''Self Documentation'''
 *
 *   [[Able.Info]] allows any object to document itself.
 *
 *   Note: All methods are protected (in order not to pollute name space), so change filter to see them.
 *
 *   @example
 *    {{{
 *       // Actual scalqa.App.Memory object code
 *       object Memory extends Able.Info {
 *         private def rt = Runtime.getRuntime
 *         def total: Byte.Size = rt.totalMemory
 *         def max: Byte.Size = rt.maxMemory
 *         def free: Byte.Size = rt.freeMemory
 *         def used: Byte.Size = total - free
 *         def gc: Unit = java.lang.System.gc
 *
 *         protected def info = \/.info ~ ("max", max) ~ ("total", total) ~ ("free", free) ~ ("used", used)
 *       }
 *
 *       App.Memory.lp.lp
 *       App.Memory.tp
 *
 *       // Output
 *       Memory{max=15.2g,total=1.0g,free=985.8m,used=43.3m}
 *
 *       Memory{max=15.2g,
 *              total=1.0g,
 *              free=985.8m,
 *              used=43.3m}
 *    }}}
 *
 * @def infoLine: -> String description
 *
 *     One line object description
 *
 *     Description is generated based on ''info'', but can be overridden for custom text
 *
 *     Though protected, this method can be universally accessed as: "<any>.I.info"
 *
 * @def infoLabel: -> Identity LabelString description
 *
 *     One line object description
 *
 *     Description is generated based on ''info'', but can be overridden for custom text
 *
 *     Though protected, this method can be universally accessed as: "<any>.I.info"
 *
 * @def infoText: -> Text description
 *
 *     Multi line object description
 *
 *     Description is generated based on ''info'', but can be overridden for custom text
 *
 *     Though protected, this method can be universally accessed as: "<any>.I.infoText"
 *
 * @def info: -> Property info
 *
 *    This is the only abstract method to implement for default behaviour
 *
 *    ''info'' provides a [[Pipe]] of (Any,Any) tuples, each representing property/value pair
 *
 *    Good practice is to start pipe building with ''\/.info'', which is a void pipe, in order to force (Any,Any) type.
 *
 *    A nameless value can be defined as (\/,<value>)
 *
 *    @example{{{
 *       object MyObject extends Able.Info {
 *           protected def info = \/.info ~ ("min", 10) ~ ("max", 20) ~ (\/, "exclusive")
 *       }
 *
 *       MyObject.lp  // Same as: MyObject.I.info.lp
 *       MyObject.tp  // Same as: MyObject.I.infoText.tp
 *
 *       // Output
 *       MyObject{min=10,max=20,exclusive}
 *       MyObject{min=10,
 *                max=20,
 *                exclusive}
 *    }}}
 */
