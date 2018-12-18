package scalqa; package Stream; package Flow; package _consume

trait _Trait[A] extends _aggregate[A] with _convert[A] with _evaluate[A] with _foreach[A] {
  self: Flow[A] =>
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
