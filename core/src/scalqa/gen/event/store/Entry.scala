package scalqa; package gen; package event; package store; import language.implicitConversions

trait Entry extends Able.Doc with Able.Void:
  def `type`      : Any
  def next_?      : Opt[Entry]
  def value       : Any
  def cancel      : Boolean
  def isCancelled : Boolean

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Entry -> [[Entry]] is the link in the linked list of all entries.


@def `type` -> Type

       Scope the entry belongs to.

       Entries are accessed by type, and entries with different types never mix


@def value -> Value

     Value is entry's pay load.  It can be anything.

@def cancel -> Removal

     Running cancel, will remove the entry from the stored list and it will be no longer available

     If entry is already cancelled, nothing happens.


@def isCancelled -> Cancelled check

     Returns true is the entry is already cancelled.


*/
