package scalqa; package Pipe; package _extend

trait _Trait[A] extends Flow._extend._Trait[A] with _filter._Trait[A]
  with _process[A] with _convert[A] with _group[A] with _reproduce[A] with _order[A] with _flow[A] with _add[A] with _trigger[A] with _zip[A]
/*________________________________________________________________________
                             _____
      _________ ____   _   /  __/ ____     Scala Custom API
     /  __/ __// _  | / /  / /    / _  |    (c) 2018, Evgeny Dolgy  and
   __\  \/ /__/ __  |/ /__/ /___ / __  |              Scalqa project at
  /_____/\___/_/  |_/____/\_____/_/  |_|              github.com/scalqa
________________________________________________________________________*/
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
