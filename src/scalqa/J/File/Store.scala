package scalqa; package J; package File

import java.nio.file.{ FileStore => JStore }

class Store protected (val real: JStore) extends AnyVal with Able.Info {

  def name = real.name

  def label: String = real.`type`

  def totalSpace: Byte.Size = real.getTotalSpace

  def unallocatedSpace: Byte.Size = real.getUnallocatedSpace

  def usableSpace: Byte.Size = real.getUsableSpace

  protected def info = \/.info ~ ("name", name) ~ ("label", label) ~ ("totalSpace", totalSpace) ~ ("unallocatedSpace", unallocatedSpace) ~ ("usableSpace", usableSpace)

}

object Store {

  def get(s: JStore) = new Store(s)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
