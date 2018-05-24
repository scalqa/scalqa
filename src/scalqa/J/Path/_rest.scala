package scalqa; package J; package Path

trait _rest extends Any with __ with Able.Z.ToString {

  def real: java.nio.file.Path

  def normalize: Path = real.normalize

  override def toString = real.toString

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def real -> Real Path
 *
 *   Scalqa [[J.Path]] is a wrapper around [[https://docs.oracle.com/javase/7/docs/api/java/nio/file/Path.html java.nio.file.Path]], which can be used directly
 *
 * @def normalize -> Canonical presentation
 *
 *    [[Path]] can be defined in peculiar ways
 *
 *    This method brings it to canonical presentation
 *
 *    {{{
 *      val path: J.Path = "aaa" ~ "bbb" ~ ".." ~ "ccc"
 *
 *      path lp            // Prints: aaa\bbb\..\ccc
 *
 *      path.normalize lp  // Prints: aaa\ccc
 *   }}}
 */
