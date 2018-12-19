package scalqa; package Any; package Ref; package Extra

trait _Trait extends Like {

  protected[Extra] def _allEntries(scope: AnyRef): ~[Entry] = if (scope == null) \/ else _topEntry.all(scope)

  protected[Extra] override def _addEntry(scope: AnyRef, value: Any): EventControl = super._addEntry(scope, value)

  protected[Extra] def _isNoEntries: Boolean = _topEntry.isVoid

  protected[Extra] def _entriesDescription: String = _topEntry.all(Z.Entry.stream.AnyScope).map(_.toInfo).I.let(_.prime).map(_.zipIdx.format("\n").indent("Any.Ref.Extra: ").toString) orElse "empty"

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *     [[[Any.Ref.Extra]]] is a universal mechanism of extending any object with all kinds of data. It is heavily used in Scalqa, particularly for event support.
 *
 *     Implementing object will have just one variable with reference to the root of linked list, containing [[Entry]] objects
 *
 *     This linked list can have many independent types of data, securely accessed by scope (which is like a password)
 *
 *     Methods, creating scopes of data, are not able to mess with data from different scopes
 *
 *     Pre-built interfaces:
 *
 *       - [[Event0]],[[Event1]],[[Event2]],[[Event3]],[[Event4]] - events with different number of parameters
 *       - [[Property]] - generic property/value storage
 *       - [[Activation]] - generic isActive state, based on many conditions
 *       - [[Observable]] - event based self observation, listening when new events are added or removed
 *
 *     Using [[[Any.Ref.Extra]]] is easy:
 *     {{{
 *       // Two independent Int and String containers sharing same Any.Ref.Extra storage
 *
 *       class MyInts extends Any.Ref.Extra {
 *         def add(i: Int)       = _addEntry(MyInts.Scope, i)
 *         def remove(i: Int)    = _allEntries(MyInts.Scope).let(_.value == i).apply(_.cancel)
 *         def allInts           = _allEntries(MyInts.Scope).map(_.value).letType[Int]
 *       }
 *       object MyInts { private object Scope }
 *
 *       // -----------------------------------------------------------------------------
 *       class MyStrings extends MyInts {
 *         def add(i: String)    = _addEntry(MyStrings.Scope, i)
 *         def remove(i: String) = _allEntries(MyStrings.Scope).let(_.value == i).apply(_.cancel)
 *         def allStrings        = _allEntries(MyStrings.Scope).map(_.value).letType[Int]
 *       }
 *       object MyStrings { private object Scope }
 *
 *       // -----------------------------------------------------------------------------
 *       object My extends MyStrings
 *
 *       ('a' <> 'k').all.map(_.toString).apply(My.add(_))
 *       (1 <> 10).all.apply(My.add(_))
 *
 *       My.allStrings lp // Prints: ~(k, j, i, h, g, f, e, d, c, b, a)
 *
 *       My.allInts lp    // Prints: ~(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
 *
 *       My.remove("a")
 *       My.remove("b")
 *       (3 <> 6).all.apply(My.remove(_))
 *
 *       My.allStrings lp // ~(k, j, i, h, g, f, e, d, c)
 *
 *       My.allInts lp    //  Prints: ~(10, 9, 8, 7, 2, 1)
 *    }}}
 *
 * @def _allEntries -> Enries stream
 *
 *     Provides stream of entries only for the specified scope.
 *
 * @def _addEntry -> Creates entry
 *
 *     Adds new entry to the list
 *
 *     Returns [[EventControl]], a fancy interface to remove entry.
 *
 * @def _isNoEntries -> Empty check
 *
 *     Returns true if there is no entries for all scopes
 *
 * @def _entriesDescription -> Description
 *
 *     String description, mostly for debugging.
 */
