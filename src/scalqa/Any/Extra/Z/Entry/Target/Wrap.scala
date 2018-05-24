package scalqa; package Any; package Extra; package Z; package Entry; package Target

private[Entry] class Wrap(protected[Entry] val entry: Entry) extends Container {

  private[Entry] val _target = entry._target

}

private[Entry] object Wrap {

  def fireOnCancel(trgt: Any): Unit = trgt match {
    case w: OnCancel => { w.code(); fireOnCancel(w._target) }
    case w: Wrap     => fireOnCancel(w._target)
    case _           => ()
  }

  // **************************************************************************************
  class OnCancel(e: Entry, val code: () => Any) extends Wrap(e)

  // **************************************************************************************
  class CancelIf(e: Entry, b: () => Boolean) extends Wrap(e) {

    override def fire[T](f: T => Any) { if (b()) entry.cancel else super.fire(f) }

  }

  // **************************************************************************************
  class AfterEventCancelIf(e: Entry, b: () => Boolean) extends Wrap(e) {

    override def fire[T](f: T => Any) { super.fire(f); if (b()) entry.cancel }

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/