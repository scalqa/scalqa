package scalqa; package J; package Json; package Object; package W

trait _this extends Lookup.W[String, Any] with Able.Add[(String, Any)] {

  def put(name: String, a: Any): Unit

  @inline protected def _add(v: (String, Any)) = put(v._1, v._2)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _this -> '''Only Writable Methods'''
 */
