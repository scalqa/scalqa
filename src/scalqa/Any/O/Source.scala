package scalqa; package Any; package O

trait Source extends O with Able.Refresh with Any.Extra.Event0 {

  protected def onObservableChange(f: () => Any) = _onEvent0(Source.ObservableChangeEventId, f)

  protected def fireObservableChangeEvent: Int = _fireEvent0(Source.ObservableChangeEventId)

  protected def depend(dependencies: ~[O]): Unit = dependencies.apply(_.onObservableChange(() => fireObservableChangeEvent))

  def refresh: Any = fireObservableChangeEvent

}

private object Source { object ObservableChangeEventId }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Source ->
 *
 *   [[Source]] is a generic base to build observable objects
 *
 *   Note. All methods are protected
 *
 *    Method ''refresh'' sends a generic event to all listeners.
 *
 *
 * @def fireObservableChangeEvent -> Event distribution
 *
 *     Notifies all the event liteners
 *
 *     Returns notified listener count
 *
 */
