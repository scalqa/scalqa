package scalqa; package String; package Z

private[String] class allChars(val string: String) extends Pipe.The.IndexBase[Char](string.length) {

  protected def _apply(i: Int) = string.charAt(i)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/