package scalqa

package object Short {
  type Like = Like._Trait

  val Min = scala.Short.MinValue

  val Max = scala.Short.MaxValue

  protected[scalqa] val Class = classOf[java.lang.Short]

  protected[scalqa] val ClassPrimitive = java.lang.Short.TYPE

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Short ->  Package for base '''scala.Short''' type
 *
 * @val Min -> Minimum value.
 *
 *    Constant -2<sup>15</sup>
 *
 *  {{{  -32,768  }}}
 *
 * @val Max -> Maximum value.
 *
 *   Constant 2<sup>15</sup>-1
 *
 *   {{{  32,767 }}}
 *
 */
