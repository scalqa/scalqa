package scalqa; package Coll

package object O {
  type Change[A] = Change._Class[A]
  type Add[A] = Change.Add[A]; val Add = Change.Add
  type Remove[A] = Change.Remove[A]; val Remove = Change.Remove

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @type Add -> Shortcut
 *  
 *  	[[Coll.O.Change.Add]] can universally be accessed as [[Coll.O.Add]] 	
 * 
 *  @type Remove -> Shortcut
 *  
 *  	[[Coll.O.Change.Remove]] can universally be accessed as [[Coll.O.Remove]] 	
*/
