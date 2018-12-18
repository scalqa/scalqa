package scalqa; package Any; package Ref; package Extra

trait Entry extends Any.Able.ToInfo {

  def scope: Any

  def value: Any

  def cancel: Boolean

  def isCancelled: Boolean

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Entry ->
 *   [[Entry]] is the link in the linked list of all entries.
 *
 *
 * @def scope -> Scope
 *
 *     Scope the entry belongs to.
 *
 *     Entries are accessed by scope, and entries with different scopes never mix
 *
 * @def value -> Value
 *
 *   Value is entry's pay load.  It can be anything.
 *
 *
 * @def cancel -> Removal
 *
 *   Running cancel, will remove the entry from the stored list and it will be no longer available
 *
 *   If entry is already cancelled, nothing happens.
 *
 * @def isCancelled -> Cancelled check
 *
 *   Returns true is the entry is already cancelled.
 *
 */
