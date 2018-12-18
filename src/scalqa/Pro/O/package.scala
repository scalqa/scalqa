package scalqa; package Pro

package object O {

  def make[A](v: => A, dependencies: ~[Any.O] = \/): O[A] = new A.Basic[A](v, dependencies)

  def constant[A](v: A): O[A] = new Z.A.Constant(v)

  def refreshable[A](v: => A, dependencies: ~[Any.O] = \/): O[A] with Any.Able.Refresh = new Z.A.Refreshable[A](v, dependencies)

  def named[A](name: String, v: => A, dependencies: ~[Any.O] = \/): O[A] with Any.Able.Name = new Z.A.Named[A](name, v, dependencies)

  def namedRefreshable[A](name: String, v: => A, dependencies: ~[Any.O] = \/): O[A] with Any.Able.Name with Any.Able.Refresh = new Z.A.Named.Refreshable[A](name, v, dependencies)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
