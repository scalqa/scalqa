package scalqa; package Stream; package A

abstract class Indexed[A] protected extends Base[A] with Specialized.Indexed[A] {

  def pump = _pumpIndexed

  override def foreach(f: Consumer[A]) = _consumeIndexed(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
