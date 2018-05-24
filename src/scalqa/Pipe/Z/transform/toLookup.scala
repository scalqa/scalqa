package scalqa; package Pipe; package Z; package transform

private[Pipe] class toLookup[KEY, A](src: Flow[A], f: A => KEY) extends Lookup.The[KEY, A] {

  src.synchronize.apply((v: A) => real += (f(v), v))

}

private[Pipe] object toLookup {

  def apply[KEY, A](src: Flow[A], f: A => KEY): Lookup[KEY, A] = new toLookup(src, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/