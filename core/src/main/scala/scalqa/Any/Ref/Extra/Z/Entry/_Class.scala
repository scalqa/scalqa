package scalqa; package Any; package Ref; package Extra; package Z; package Entry

private[Extra] class _Class(chld: Entry, private var _scope: AnyRef, protected[Entry] var _this: Any) extends java.util.concurrent.atomic.AtomicReference[_Class](chld)
  with Target.Container with Extra.Entry with EventControl with Any.Able.Void {

  @inline final def isCancelled = _scope == null

  @inline final def scope = _scope

  def child: Entry = { val c = get; if (!c.isCancelled) c else { val cc = c.child; if (compareAndSet(c, cc)) cc else child } }

  def cancelIf(b: () ⇒ Boolean) = { if (!isCancelled) _this = new Target.Wrap.CancelIf(this, b); this }

  def onCancel(on: () => Any) = { if (!isCancelled) _this = new Target.Wrap.OnCancel(this, on); this }

  def cancel: Boolean = if (isCancelled) false else {
    var b = false;
    synchronized { if (!isCancelled) { _scope = null; b = true } };
    if (b) Target.Wrap.fireOnCancel(_this);
    b
  }

  def all(scope: AnyRef): ~[Entry] = stream(this, scope)

  def toInfo = new Pro.Info(this) += (("scope", if (scope.I.Class.isSingleton) scope.I.Class else scope)) += (("value", value)) +~= isCancelled.toOpt(("", "isCancelled")).all

  def entry = this

}

private object _Class extends Util.Void.Setup[Entry](Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
