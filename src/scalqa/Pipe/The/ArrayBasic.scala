package scalqa; package Pipe; package The

class ArrayBasic[A](protected val array: Array.Raw[_ >: A]) extends IndexBase[A](array.length) {

  protected def _apply(i: Int) = array(i).cast[A]

  protected override def _copyToArray(dest: Array[A], destPos: Int, range: Int.Range) = Array.getByRaw[A](array).copyToArray(dest, destPos, range)

  override def tagOpt = Tag.getByArrayRaw(array).Opt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class ArrayBasic -> '''The Array Basic Pipe'''
 */
