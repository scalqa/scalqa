package scalqa; package Util; package Void

trait _Trait extends Any.Able.Void {

  /** Always void, returns true */
  override def isVoid = true

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * Mixing this trait will make all instances of a class void
 *
 * Note: This is a shortcut, generally a class extend [[Any.Able.Void]] and override [[Any.Able.Void.isVoid isVoid]] itself
 *
 */
