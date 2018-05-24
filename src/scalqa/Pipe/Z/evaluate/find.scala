package scalqa; package Pipe; package Z; package evaluate

private[Pipe] object find {

  def opt[A](src: Flow[A], f: A ⇒ Boolean): Opt[A] = src.sequential.dropWhile(f(_).not).firstOpt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/