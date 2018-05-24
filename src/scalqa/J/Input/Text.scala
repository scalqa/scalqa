package scalqa; package J; package Input

trait Text extends Z.Variety {

  def read(byteLimit: Long): String

  def readAll: String = read(Long.Max)

  def readAllAndClose = readAll.I.run(close)
}

object Text extends Input.Z.Variety.Companion[Text]

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Text ->
 *
 *     [[Text]] view of parent [[Input]]
 *
 */
