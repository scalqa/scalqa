package scalqa; package Any; package Extra; package Z; package Entry; package Target

private[Entry] trait Container {

  private[Entry] def entry: Entry

  private[Entry] def _target: Any

  def value: Any = _target match {
    case vc: Container => vc.value
    case v             => v
  }

  def fire[T](f: T => Any): Unit = _target match {
    case vc: Container => vc.fire(f)
    case t             => try { f(t.cast) } catch { case Any.Event.CancelException => entry.cancel }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/