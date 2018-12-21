package scalqa; package Fx; package Selection

class _library[A] private[Selection] (protected val real: Selection[A]) extends AnyVal with Idx.Selection.O._library[A] {

  def selectFirst = real.real.selectFirst

  def clear = real.real.clearSelection

  def selectAt(i: Int) = real.real.select(i)

  def select(a: A): Unit = real.target.all.findIdxOpt(_ == a).apply(selectAt)

  def asMappedView[B](f: A => B): Selection[B] = new Selection[B](real.target.asMappedView(f), real.real)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
