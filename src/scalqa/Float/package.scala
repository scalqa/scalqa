package scalqa

package object Float {
  type Like = Like._Trait

  val Min = scala.Float.MinValue

  val Max = scala.Float.MaxValue

  protected[scalqa] val Class = classOf[java.lang.Float]

  protected[scalqa] val ClassPrimitive = java.lang.Float.TYPE

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Float ->  Package for base '''scala.Float''' type
 *
 * @val Min -> Minimum value.
 *
 *     Negative Max.
 *
 *     Constant -(2-2<sup>-23</sup>)&middot;2<sup>127</sup>
 *
 *
 * @val Max -> Maximum value.
 *
 *   Constant  (2-2<sup>-23</sup>)&middot;2<sup>127</sup>
 *
 *   {{{ 3.4028235e+38f }}}
 *
 */
