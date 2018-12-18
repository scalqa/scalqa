package scalqa; package App; package Event; package A

abstract class Base protected extends java.util.concurrent.atomic.AtomicReference[Array[() => Boolean]](Base.Void) with Event {
  private var _onCancel: Refs[() => Any] = \/

  def isCancelled: Boolean = get == Base.Cancelled

  def onCancel(f: () => Any): this.type = { _onCancel += f; this }

  protected def fireCancel: Unit = { _onCancel.all.foreach(_()); _onCancel = \/ }

  def cancel: Boolean = {
    val a = get;
    if (a eq Base.Cancelled) false
    else if (compareAndSet(a, Base.Cancelled)) { fireCancel; true }
    else cancel
  }

  def cancelIf(f: () => Boolean): this.type = {
    val a = get
    if (!compareAndSet(a, a :+ f)) cancelIf(f);
    this
  }

  protected def isActive: Boolean = {
    var a = get;
    if (a eq Base.Cancelled) false
    var i = 0
    while (i < a.length) {
      if (a(i).apply) return cancel
      i += 1
    }
    true
  }
}

private object Base {
  val Void = new Array[() => Boolean](0)
  val Cancelled = new Array[() => Boolean](1)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
