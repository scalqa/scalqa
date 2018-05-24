package scalqa; package String

trait Format[A] {

  def apply(value: A): String

  def parse(string: String): A

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Format ->
 *
 *     Generic String format for any type
 *
 * @def apply -> To String conversion
 *
 *     Converts specified ''value'' to String
 *
 *
 * @def parse -> From String conversion
 *
 *     Converts specified ''string'' to instance of Format type
 *
 */
