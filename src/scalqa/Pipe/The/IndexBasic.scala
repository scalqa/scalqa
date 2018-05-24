package scalqa; package Pipe; package The

class IndexBasic[A](protected val list: Index[A]) extends IndexBase[A](list.size) {

  protected def _apply(i: Int) = list(i)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class IndexBasic -> '''The Index Basic Pipe'''
 */
