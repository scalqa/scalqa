package scalqa; package Stream; package Z; package extend; package flow

package object preview {

  def apply[@specialized(DATA) A](s: Stream[A]): Stream[A] with Preview[A] = s match {
    case v: Stream[_] with Preview[_] => v.asInstanceOf[Stream[A] with Preview[A]]
    case v => default(v)
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
