package scalqa; package J; package Path

trait _evaluate extends Any with __ {

  def indexOpt(p: Path): Opt[Int] = Z.indexOf.opt(This, p)

  def exists: Boolean = real.toFile.exists

  def endsWith(that: Path): Boolean = real.endsWith(that.real)

  def startsWith(that: Path): Boolean = real.startsWith(that.real)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def indexOpt -> Sub-path index
 *
 *    Optionally returns matching sub-path start index
 *    {{{
 *       val path: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd" ~ "eee"
 *
 *       path indexOpt "ccc" ~ "ddd" lp  // Prints: Opt(2)
 *
 *       path indexOpt "ddd" ~ "ccc" lp  // Prints: Opt.Void
 *    }}}
 *
 * @def startsWith -> Checks start match
 *
 *   Returns ''true'' if ''this'' [[Path]] starts with ''that''
 *   {{{
 *       val path: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd"
 *
 *       path startsWith "aaa" ~ "bbb" lp  // Prints: true
 *
 *       path startsWith "bbb" ~ "aaa" lp  // Prints: false
 *   }}}
 *
 * @def endsWith -> Checks end match
 *
 *   Returns ''true'' if ''this'' [[Path]] ends with ''that''
 *   {{{
 *       val path: J.Path = "aaa" ~ "bbb" ~ "ccc" ~ "ddd"
 *
 *       path endsWith "ccc" ~ "ddd" lp // Prints: true
 *
 *       path endsWith "aaa" ~ "bbb" lp // Prints: false
 *   }}}
 *
 * @def exists -> Check exists
 *
 *   Returns ''true'' ''this'' [[Path]] exists in the file system as file or directory
 *
 */
