package scalqa; package J; package Output

class _library private[Output] (protected val This: Output) extends AnyVal {

  def asJavaOutputStream: java.io.OutputStream = This match {
    case i: Z.Base[_] => i.real
    case _            => Fail.toDo()
  }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
