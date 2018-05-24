package scalqa; package J; package File

import java.net.URI;
import java.io.{ File => FILE }

class Directory private[J] (f: FILE) extends Z.Like(f) {

  def delete: Boolean = real.delete

  def file(name: String) = path + name file

  def allFiles: ~[File] = real.listFiles.all.let(!_.isDirectory).map(new File(_))

  def allFilesRecursive: ~[File] = { var all = allFiles; allDirectories(d => all ~~= d.allFilesRecursive); all }

  def allDirectories: ~[Directory] = real.listFiles.all.let(_.isDirectory).map(new Directory(_))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Directory ->
 *
 *    [[File.Directory]] represents an ''existing'' directory in the [[File.System]]
 *
 *    [[File.Directory]] does not have direct constructors
 *
 *    To create [[File.Directory]] one needs to start with [[J.Path]], which can point to both: existent and non existent resources
 *
 * @def delete -> Delete directory
 *
 *    Directory must be empty to be deleted
 *
 */
