package scalqa; package Any; package Collection; package Z

private[Collection] class MappedView[A, B](real: Any.Collection[A], f: A => B) extends Any.Collection[B] {

  def all: ~[B] = real.all.map(f(_))

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
