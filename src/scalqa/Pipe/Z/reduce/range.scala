package scalqa; package Pipe; package Z; package reduce

private[Pipe] object range {

  def apply[A](src: Flow[A])(implicit o: Sorting[A]): Range[A] = src.foldAsOpt[Range[A]](\/, _ extendTo _, _ join _) orElse \/

  def maxOpt[A](src: Flow[A], o: Sorting[A]): Opt[A] = src.foldOpt((x, y) => if (o(x, y).isNotAsIs) x else y)

  def minOpt[A](src: Flow[A], o: Sorting[A]): Opt[A] = src.foldOpt((x, y) => if (o(x, y).isNotInverse) x else y)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
