package scalqa; package Custom; package String; package Z

private[String] class allChars(val string: String) extends Stream[Char] with Stream.A.Specialized.Indexed[Char] {

  @inline override def _apply(i: Int) = string.charAt(i)

  @inline override def _size = string.length

  @inline def pump = _pumpIndexed

  @inline def foreach(f: Stream.Consumer[Char]) = _consumeIndexed(f)

  @inline override def ilkOpt = Ilk.Chars

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
