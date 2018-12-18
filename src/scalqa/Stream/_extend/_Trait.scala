package scalqa; package Stream; package _extend

trait _Trait[A] extends Flow._extend._Trait[A] with _add[A] with _filter[A] with _flow[A] with _group[A] with _map[A] with _order[A] with _peek[A] with _trigger[A] with _zip[A] {
  self: Stream[A] =>

  override def unfold(f: Mapping[~[A], A]): ~[A] = Z.extend.flow.unfold(this, f)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
