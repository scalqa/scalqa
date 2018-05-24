package scalqa; package Lookup

package object Val {

  private[Lookup] object ScalaVoid extends scala.collection.immutable.Map[Any, Any] with Void {
    def +[B1](v: (Any, B1)) = Map(v);
    def -(key: Any) = this;
    def get(key: Any) = scala.None;
    def iterator = Iterator.empty
  }

  def get[A, B](a: ~[(A, B)]): Val[A, B] = new Z.The(Map(a.as[Seq]: _*))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
