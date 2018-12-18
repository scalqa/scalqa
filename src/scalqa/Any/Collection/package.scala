package scalqa; package Any

package object Collection {
  type O[A] = O._Trait[A]

  type Change[A] = O.Change[A]
  type Add[A] = O.Change.Add[A]; val Add = O.Change.Add
  type Remove[A] = O.Change.Remove[A]; val Remove = O.Change.Remove

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
