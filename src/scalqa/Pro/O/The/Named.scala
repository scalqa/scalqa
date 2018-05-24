package scalqa; package Pro; package O; package The

class Named[A](val name: String, source: => A) extends The(source) with Able.Name {
  def this(name: String, source: => A, dependenciesOpt: Opt[~[Any.O]]) = { this(name, source); dependenciesOpt(depend) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
