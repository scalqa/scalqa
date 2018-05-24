package scalqa; package J; package Output

trait Buffer extends Output {

  def size: Int

  def isEmpty = size == 0

  def bytes: Array[Byte]

  def clear

  def toInput: Input

}

object Buffer {

  def get(initSize: Int): Buffer = new Z.Buffer(initSize)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
