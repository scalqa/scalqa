package scalqa; package J; package File; package Z

private[File] abstract class Like private[File] (val real: java.io.File) {

  def name: String = real.getName

  def exists = real.exists

  def parent = new Directory(new java.io.File(real.getParent))

  def lastModified: Time = Time.getByMillis(real.lastModified)

  def path: Path = real.toPath

  override def toString = path.toString

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Like->
 *
 *    @define example {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f: J.File = p.fileMake
 *
 *       f.path lp       // Prints: C:\Temp\Test.txt
 *
 *       f.name lp       // Prints: Test.txt
 *    }}}
 *
 * @def name -> Name
 *
 *    Last name without prior path $example
 *
 * @def exists -> Check if exists
 *
 *    Usually returns ''true'', unless was [[delete]]d just before
 *
 * @def parent -> Parent directory
 *
 *    Returns [[File.Directory]] containing this
 *
 * @def lastModified -> Last updated time
 *
 *    Returns [[Time]] when ''this'' was last modified
 *
 * @def path -> Path
 *
 *    Returns [[J.Path]] to this $example
 */
