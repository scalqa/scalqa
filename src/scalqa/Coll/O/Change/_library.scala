package scalqa; package Coll; package O; package Change

class _library[A] private[Change] (private val This: Change[A]) extends AnyVal {

  def addOpt: Opt[Add[A]] = This.I.letAs(classOf[Add[A]])

  def removeOpt: Opt[Remove[A]] = This.I.letAs(classOf[Remove[A]])

  def indexAddOpt: Opt[Index.O.Add[A]] = This.I.letAs(classOf[Index.O.Add[A]])

  def indexRemoveOpt: Opt[Index.O.Remove[A]] = This.I.letAs(classOf[Index.O.Remove[A]])

  def indexRefreshOpt: Opt[Index.O.Refresh[A]] = This.I.letAs(classOf[Index.O.Refresh[A]])

  def indexRepositionOpt: Opt[Index.O.Reposition[A]] = This.I.letAs(classOf[Index.O.Reposition[A]])

  def indexRange: Int.Range = indexRangeOpt or Fail(This + " has no range")

  def indexRangeOpt: Opt[Int.Range] = This match {
    case v: Index.O.Add[A] => v.range
    case v: Index.O.Remove[A] => v.range
    case v: Index.O.Refresh[A] => v.range
    case v: Index.O.Reposition[A] => v.range
    case null => Fail("null O.Change")
    case v => \/
  }

  def asMap[B](f: A => B): Change[B] = This match {
    case v: Index.O.Add[A]    => Index.O.Add.get(v.range, v.items.asMap(f))
    case v: Add[A]            => Add.get(v.items.asMap(f))
    case v: Index.O.Remove[A] => Index.O.Remove.get(v.range, v.items.asMap(f))
    case v: Remove[A]         => Remove.get(v.items.asMap(f))
    case null                 => Fail("null O.Change")
    case v                    => v.cast
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def indexRange: -> Change range
 *
 *     Returns range of changes for Index.O.Changes
 *
 *     Fails for Coll.O.Changes
 *
 * @def indexRangeOpt -> Optional range
 *
 *     All Index.O.Changes have range and it is returned
 *
 *     Otherwise, all Coll.O.Changes are rangeless, so Opt.Void is returned
 *
 * @def indexAddOpt -> Optional Index.O.Add
 *
 *     If ''this'' change is [[Index.O.Add]], it is returned
 *
 *     Otherwise Opt.Void is returned
 *
 * @def indexRemoveOpt -> Optional Index.O.Remove
 *
 *     If ''this'' change is [[Index.O.Remove]], it is returned
 *
 *     Otherwise Opt.Void is returned
 *
 * @def indexRefreshOpt -> Optional Index.O.Refresh
 *
 *     If ''this'' change is [[Index.O.Refresh]], it is returned
 *
 *     Otherwise Opt.Void is returned
 *
 * @def indexRepositionOpt -> Optional Index.O.Reposition
 *
 *     If ''this'' change is [[Index.O.Reposition]], it is returned
 *
 *     Otherwise Opt.Void is returned
 *
 * @def addOpt -> Optional Coll.O.Add
 *
 *     If ''this'' change is [[Coll.O.Add]], it is returned
 *
 *     Otherwise Opt.Void is returned
 *
 *     Note: [[Index.O.Add]] also implements [[Coll.O.Add]]
 *
 * @def removeOpt -> Optional Coll.O.Remove
 *
 *     If ''this'' change is [[Coll.O.Remove]], it is returned.
 *
 *     Otherwise Opt.Void is returned
 *
 *     Note: [[Index.O.Remove]] also implements [[Coll.O.Remove]]
 *
 */
