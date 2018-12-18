package scalqa; package Any; package Collection; package O; package Change

class _library[A] private[Change] (private val real: Change[A]) extends AnyVal {

  def ifAddOpt: Opt[Add[A]] = real.I.letType[Add[A]]

  def ifRemoveOpt: Opt[Remove[A]] = real.I.letType[Remove[A]]

  def asMappedView[B](f: A => B): Any.Collection.O.Change[B] = real match {
    case v: Add[A]    => Add.make(v.items.asMappedView(f))
    case v: Remove[A] => Remove.make(v.items.asMappedView(f))
    case null         => App.Fail("null Change")
    case v            => v.asInstanceOf[Any.Collection.O.Change[B]]
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asMappedView -> Type map
 *
 *     Returns equivalent Change, where all items are converted with given mapping
 *
 * @def ifAddOpt -> This if Add
 *
 *     Optionally returns `this`, if it is Add change, or void [[Opt]]
 *
 * @def ifRemoveOpt -> This if Remove
 *
 *     Optionally returns `this`, if it is Remove change, or void [[Opt]]
 *
 */
