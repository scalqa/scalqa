package scalqa; package J

package object Path {

  private def fsd = File.System.getDefault

  lazy val Void: Path = \/

  def get: Path = Void.real.toAbsolutePath

  def get(first: String, more: String*): Path = fsd.path(first, more: _*)

  def get(names: ~[String]): Path = fsd.path(names)

  def get(v: java.nio.file.Path): Path = v

  def +(v: Any): Path = v.I.as(classOf[Path], v => get(v.toString))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Path ->
 *
 * @def get: -> Current
 *
 *    Returns [[Path]] to current directory
 *
 *    Note: Current path always includes root
 *
 *    {{{
 *      val currentPath : J.Path = J.Path.get
 *
 *      val currentRoot : J.Path = J.Path.get.root
 *    }}}
 *
 * @def get(first: -> By name list
 *
 *     Creates [[Path]] by name list
 *
 *     Note. First name may be root as system dependent specification
 *     {{{
 *       J.Path.get("aaa", "bbb", "ccc") lp        // Prints: aaa\bbb\ccc
 *
 *       J.Path.get("c:", "aaa", "bbb", "ccc") lp  // Prints: c:\aaa\bbb\ccc
 *     }}}
 *
 * @def get(names: -> By name pipe
 *
 *     Creates [[Path]] by name [[Pipe]]
 *
 *     Note. First name may be root as system dependent specification
 *     {{{
 *       J.Path.get("aaa" ~ "bbb" ~ "ccc") lp         // Prints: aaa\bbb\ccc
 *
 *       J.Path.get("c:" ~ "aaa" ~ "bbb" ~ "ccc") lp  // Prints: c:\aaa\bbb\ccc
 *     }}}
 *
 * @def get(v -> By Java path
 *
 *     Returns path based on given Java path
 */
