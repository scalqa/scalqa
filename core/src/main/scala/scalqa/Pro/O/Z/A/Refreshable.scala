package scalqa; package Pro; package O; package Z; package A

private[O] class Refreshable[A](source: => A, dependencies: ~[Any.O]) extends O.A.Basic(source, dependencies) with Any.Able.Refresh {

  def refresh = fireChange

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
