package scalqa; package J; package Output; package Z

private[Output] trait Like {

  def close

  def flush: this.type

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def flush -> Flush data
 *
 *    Writes to the output all data that might have been buffered
 *
 * @def close -> Close output
 *
 *    Closes [[Output]]
 *
 */
