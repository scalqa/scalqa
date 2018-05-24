package scalqa; package Pipe; package Z

private[Pipe] class Buffer[A] extends Index.Z.The.Stack[A] {
  def this(p: Pipe[A]) = { this; p.apply(add) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/