package scalqa; package Pro; package O; package A

class Basic[A](source: => A, dependencies: ~[Any.O] = \/) extends Base[A] {

  dependencies.foreach(_.onObservableChange(() => fireChange))

  private var valueOpt: Opt[A] = \/

  def apply = valueOpt.orOpt { valueOpt = source; valueOpt }.value

  protected override def fireChange: Int = { valueOpt = \/; super.fireChange }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
