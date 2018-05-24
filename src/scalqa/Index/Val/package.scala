package scalqa; package Index

package object Val {

  def get[A](first: A, others: A*)(implicit t: Tag[A] = \/): Val[A] = {
    val v = (\/ : Val[A]) + first
    if (others.isEmpty) v else v +~ others
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get -> By values
 *
 *     Creates [[Index.Val]] with provided values
 *
 */
