package scalqa; package Concurrent; package Control; package The

abstract class Base protected extends java.util.concurrent.atomic.AtomicReference[Index.Val[() => Boolean]](\/) with Control {
  private var _onCancel: Index.Val[() => Any] = \/

  def cancel: Boolean = get.I.to(l => if (l == Base.Cancelled) false else if (compareAndSet(l, Base.Cancelled)) { fireCancel; true } else cancel)

  def isCancelled: Boolean = get == Base.Cancelled

  protected def fireCancel: Unit = { _onCancel.all(_()); _onCancel = \/ }

  def onCancel(f: () => Any): this.type = { _onCancel += f; this }

  def cancelIf(f: () => Boolean): this.type = { get.I.to(l => if (!compareAndSet(l, l + f)) cancelIf(f)); this }

  protected def _notCancelled: Boolean = get.I.to(l => l != Base.Cancelled && !l.all.findOpt(_()).run(cancel))

}

private object Base {
  val Cancelled = (() => true).I.~.to[Index.Val]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
