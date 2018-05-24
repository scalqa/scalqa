package scalqa; package J; package Input

trait Bytes extends Z.Variety {

  def read: Int

  def readOpt: Opt[Byte] = { val i = read; if (i < 0) \/ else (i - Byte.Min).toByte }

  def read(ba: Array[Byte], range: Opt[Int.Range] = \/): Int

  def readAll: Array[Byte] = Z.Bytes.readAll(this)

  def readAllAndClose = readAll.I.run(input.close)

  def asSeparated(separator: Byte): ~[Array[Byte] => Int] = new Z.Bytes.allSeparated(this, separator)

}

object Bytes extends Input.Z.Variety.Companion[Bytes]
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Bytes ->
 *
 *   [[Bytes]] view of parent [[Input]]
 *
 * @def read: -> Byte
 *
 *     Reads the next byte from input as Int in range 0 <>> 256
 *
 *     Returns -1 if no more data
 *
 * @def readOpt -> Byte option
 *
 *     Optionally returns next byte from input
 *
 *     If no more data, Opt.Void is returned
 *
 * @def read( -> To array
 *
 *    Reads input bytes to given [[Array]]
 *
 *    @param range Array range to use. By default the full array is used
 *
 *    @return  the total number of bytes read into the array, or -1 if there is no more data
 *
 */
