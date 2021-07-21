package scalqa; package gen; package event; package store; import language.implicitConversions

transparent trait _activation:
  self : Store =>

  def onActivateDeactivate[U](f: Boolean => U) : Event.Control = setupEvent(Activation.Events, f)
  def onActivateRun(f: => Unit)                : Event.Control = onActivateDeactivate(b => if (b) f)
  def onDeactivateRun(f: => Unit)              : Event.Control = onActivateDeactivate(b => if (!b) f)

  def activate(activeRule: () => Boolean) : Unit =
    if (activeRule())
      val b = isActive
      add(Activation.Status, activeRule)
      if (!b) fire(true)

  def isActive: Boolean =
    var a = false
    var e = get(Activation.Status)
    val s = !e.isVoid
    while (!a && !e.isVoid)
      val v = e.value.cast[() => Boolean]
      if (v != null) a = v()
      if (!a) e.cancel
      e = e.next
    if (s != a) fire(false)
    a

  private def fire[U](b: Boolean) =
    var e = get(Activation.Events)
    var c = 0
    while (!e.isVoid)
      val f = e.value.cast[Boolean => U]
      if (f != null) try { f(b); c += 1 } catch { case Event.CancelRequest => e.cancel }
      e = e.next
    if (c > 1000) J.illegalState("Too many " +c)
    c

private object Activation:
  object Status
  object Events

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
