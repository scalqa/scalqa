package scalqa; package J; package Input

class _library private[Input] (protected val This: Input) extends AnyVal {

  def buffer: Input = get(This.asBytes.readAll)

  def asJavaInputStream: java.io.InputStream = This match {
    case i: Z.Base => i.real
    case _         => Fail.toDo()
  }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
