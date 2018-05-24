package scalqa; package Pipe; package The

object Void extends Pipe.The.Base[Nothing] with scalqa.Void with Pipe.Iterator[Nothing] {

  override def isMutable = false

  override def previewOpt = \/

  override def sizeOpt = 0

  override def nextOpt = \/

  // -------------------------------------------------------------------------
  override def peek(f: Nothing => Any) = Void
  override def map[B](f: Nothing => B) = Void
  override def flatMap[B](f: Nothing => ~[B]) = Void
  override def let(p: (Nothing) ⇒ Boolean) = Void
  override def sort(implicit o: Sorting[Nothing]) = Void
  override def parallel = Void

  // -------------------------------------------------------------------------
  def nextFindOpt(f: Nothing => Boolean) = \/
  override def pumpOpt(f: Nothing => Boolean) = \/
  override def findOpt(f: Nothing ⇒ Boolean) = \/
  override def size = 0
  override def infoText = "empty"

  // ---------------------------------------------------------------------------------------------------------------------------------
  override def nonEmptyOpt = \/
  override def all = Void

  override def buffer = this
  override def reverse = this
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Void -> '''The Void Pipe'''
 */
