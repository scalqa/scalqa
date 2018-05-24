package scalqa; package Pipe; package Z; package foreach

private[Pipe] object drain {

  def apply[A](src: Flow[A]): Unit = foreach.apply[A](src, Bucket)

  // *************************************************************
  private object Bucket extends (Any => Any) {
    private var state = true
    @inline def apply(v: Any): Unit = state = !state
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/