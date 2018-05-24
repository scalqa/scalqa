package scalqa; package Index

package object O {
  type Change[A] = Coll.O.Change[A]
  type Add[A] = Change.Add[A]; val Add = Change.Add
  type Remove[A] = Change.Remove[A]; val Remove = Change.Remove
  type Refresh[A] = Change.Refresh[A]; val Refresh = Change.Refresh
  type Reposition[A] = Change.Reposition[A]; val Reposition = Change.Reposition

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @type Change -> Shortcut to Coll.O.Change
 *
 *     There is no new type for [[Index.O.Change]], it is just a shotcut to [[Coll.O.Change]]
 *
 *  @type Add -> Shortcut
 *
 *    [[Index.O.Change.Add]] can universally be accessed as [[Index.O.Add]]
 *
 *  @type Remove -> Shortcut
 *
 *    [[Index.O.Change.Remove]] can universally be accessed as [[Index.O.Remove]]
 *
 *  @type Refresh -> Shortcut
 *
 *    [[Index.O.Change.Refresh]] can universally be accessed as [[Index.O.Refresh]]
 *
 *  @type Reposition -> Shortcut
 *
 *    [[Index.O.Change.Reposition]] can universally be accessed as [[Index.O.Reposition]]
 */
