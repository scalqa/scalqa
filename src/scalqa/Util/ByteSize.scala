package scalqa; package Util

class ByteSize(protected val real: Long) extends AnyVal with Any.Datum.Long.Number[ByteSize] {
  protected def setup = ByteSize

  def toBrief: String = real.toBrief + 'B'

  override def toString = real.toString + " Bytes"

}

object ByteSize extends Any.Datum.Long.Number.Setup[ByteSize] {

  def apply(v: Long) = new ByteSize(v)

  def make(v: Long) = new ByteSize(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class ByteSize ->
 *
 *     [[ByteSize]] is a Long wrapper to indicate something like File size or memory allocation in bytes
 *
 *     [[ByteSize]] is not referenced much in scalqa itself, but proved to be usefull in applications
 */
