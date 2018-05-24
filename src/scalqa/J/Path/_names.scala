package scalqa; package J; package Path

trait _names extends Any with Index[String] with __ {

  def apply(idx: Int): String = real.getName(idx).toString

  def size: Int = real.getNameCount ? (_ == 1 && real.startsWith(""), _ => 0)

  def lastName: String = real.getFileName.toString

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def lastName -> Last name
 *
 *    Returns last name in the [[Path]] hierarchy
 *
 *    If this [[Path]] points to a file, ''lastName'' is the name of file
 *
 *    {{{
 *        val path : J.Path =  "Temp" ~ "Test.txt"
 *
 *        path.lastName lp  // Prints: Test.txt
 *    }}}
 *
 */
