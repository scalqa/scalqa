package scalqa; package Coll; package W; package Z

private[scalqa] trait LibraryBase[A, CollW <: W[A]] extends Any with Coll.Z.LibraryBase[A] with Able.Add[A] with Able.Remove[A] {
  protected type TARGET = CollW

  def clearAll: ~[A] = This.all.buffer.I.run(This.clear)

  def replaceAll(a: ~[A]) { This.clear; This =+~ a }

  private[scalqa] def addFlow(src: Pipe.Flow[A]): Unit = src match { case a: ~[A] => This =+~ a; case l => l.synchronize.apply(This.add) }

  // -------------------------------------------------------------------------------------------------
  protected def This: CollW
  protected def _target = This
  protected def _add(a: A) = { This.add(a); This }
  protected def _remove(v: A) = { This.remove(v); This }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def replaceAll -> Replace
 *
 *   Clear the collection from the original items and add new ones
 *
 * @def clearAll -> Clear with items
 *
 *   Returns a Pipe of collection elements, while removing them form the collection
 *
 */
