package scalqa; package String

class Id private (protected val real: String) extends AnyVal with Like {
  protected override type THIS = Id

  protected def companion = Id

}

object Id extends Like.Companion[Id] {

  def get(v: String) = new Id(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Id ->
 *
 *   [[String.Id]] allows to represent some identity with a String, which will not be confused with other Strings
 *
 * @object Id ->
 *
 *   The easiest way to build a [[String.Id]] is with built-in constructor
 *
 *   {{{
 *       val id   : String.Id = "abc".Id
 *
 *       val void : String.Id = \/
 *   }}}
 */
