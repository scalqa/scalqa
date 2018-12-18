package scalqa; package Stream; package Flow; package _extend

trait _Trait[A] extends _filter[A] with _flow[A] with _map[A] with _peek[A] {

  self: Flow[A] =>

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
