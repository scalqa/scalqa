package scalqa; package Pro

package object O {
  type The[A] = The._Class[A]

  def get[A](v: => A, dependenciesOpt: Opt[~[Any.O]] = \/): O[A] = new The[A](v, dependenciesOpt)

  def getNamed[A](name: String, v: => A, dependenciesOpt: Opt[~[Any.O]] = \/): O[A] with Able.Name = new The.Named[A](name, v, dependenciesOpt)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
