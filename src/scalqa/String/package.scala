package scalqa

package object String {
  type Like = Like._Trait

  val Empty = ""

  val Eol = "\n"

  val Tab = "\t"

  val Space = " "

  val Comma = ","

  val Period = "."

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object String ->  Package for base '''java.lang.String''' type
 *
 * @val Empty -> Empty string
 *
 *     "" is still preferred in the code, use ''String.Empty'' for semantic emphasis where appropriate.
 *
 * @val Eol -> End of line char string
 *
 *     "\n" is still preferred in the code, use ''String.Eol'' for semantic emphasis where appropriate.
 *
 * @val Tab -> Tab char string
 *
 *     "\n" is still preferred in the code, use ''String.Tab'' for semantic emphasis where appropriate.
 *
 * @val Space -> One space string
 *
 *     " " is still preferred in the code, use ''String.Space'' for semantic emphasis where appropriate.
 *
 * @val Comma -> Comma char string
 *
 *     "," is still preferred in the code, use ''String.Comma'' for semantic emphasis where appropriate.
 *
 * @val Period -> Period char string
 *
 *     "." is still preferred in the code, use ''String.Period'' for semantic emphasis where appropriate.
 */
