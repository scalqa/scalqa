package scalqa; package Pro; package O; package The

class _Class[A](source: => A) extends Base[A] {
  def this(source: => A, dependenciesOpt: Opt[~[Any.O]]) = { this(source); dependenciesOpt(depend) }

  private var valueOpt: Opt[A] = \/

  def apply = valueOpt.orOpt { valueOpt = source; valueOpt }.value

  protected override def fireObservableChangeEvent = { valueOpt = \/; super.fireObservableChangeEvent }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
