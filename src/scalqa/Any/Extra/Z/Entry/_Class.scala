package scalqa; package Any; package Extra; package Z; package Entry

private[Extra] class _Class(chld: Entry, private var _scope: AnyRef, protected[Entry] var _target: Any) extends java.util.concurrent.atomic.AtomicReference[_Class](chld)
    with Target.Container with Extra.Entry with Concurrent.Control with scalqa.Able.Void {

  @inline def isCancelled = _scope == null

  @inline def scope = _scope

  @inline def child: Entry = { val c = get; if (!c.isCancelled) c else { val cc = c.child; if (compareAndSet(c, cc)) cc else child } }

  def cancelIf(b: () ⇒ Boolean) = { if (!isCancelled) _target = new Target.Wrap.CancelIf(this, b); this }

  def onCancel(on: () => Any) = { if (!isCancelled) _target = new Target.Wrap.OnCancel(this, on); this }

  def cancel: Boolean = if (isCancelled) false else { var b = false; synchronized { if (!isCancelled) { _scope = null; b = true } }; if (b) Target.Wrap.fireOnCancel(_target); b }

  def all(scope: AnyRef): ~[Entry] = new all(this, scope)

  protected def info = \/.info ~ ("scope", scope.Class.isSingleton ? (scope.Class, scope)) ~ ("value", value) ~~ isCancelled.opt((\/, "isCancelled"))

  def entry = this

}

private object _Class extends Able.Void.Companion[Entry](Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/