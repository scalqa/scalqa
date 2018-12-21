package scalqa; package Stream; package Z; package consume; package aggregate

private[Stream] object reduce {

  def Opt[@specialized(DATA) A](src: Stream[A], op: Folding[A]): Opt[A] = {

    val f = new Reducer[A] { def reduce(x: A, y: A) = op(x, y) }

    src.apply(f)

    f.toOpt

  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
