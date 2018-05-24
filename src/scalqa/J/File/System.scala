package scalqa; package J; package File

import java.nio.file.{ FileSystem => JSystem }

class System protected (val real: JSystem) extends AnyVal {

  def allStores: ~[Store] = real.getFileStores.iterator.all.map(Store.get(_))

  def allRoots: ~[Path] = real.getRootDirectories.iterator.all.map(Path.get(_))

  def separator = real.getSeparator

  def path(first: String, more: String*): Path = real.getPath(first, more: _*)

  def path(a: ~[String]): Path = a.iterator.I.to(it => it.nextOpt.map(path(_, it.all.as[Seq]: _*)) or path(""))

  override def toString = real.toString

}

object System {

  def getDefault(): System = get(java.nio.file.FileSystems.getDefault)

  def get(s: JSystem) = new System(s)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
