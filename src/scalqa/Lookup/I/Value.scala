package scalqa; package Lookup; package I

import scala.collection.immutable.Map

class Value[A, B] private (private val real: Map[A, B]) extends I[A, B] with Any.Able.Void {

  def size = real.size

  def allPairs: ~[(A, B)] = real.iterator

  def getOpt(key: A): Opt[B] = Opt.fromOption(real.get(key))

  override def isVoid = real == Value.VoidMap

  def +(v: (A, B)) = new Value(real + v)
  def +~(v: ~[(A, B)]): Value[A, B] = v.foldAs(this)(_ + _)

  def -(v: A) = new Value(real - v)
  def -~(v: ~[A]): Value[A, B] = v.foldAs(this)(_ - _)

  def asScalaMapView: Map[A, B] = real

}

object Value {

  private val Void = new Value[Any, Any](VoidMap)

  def make[A, B](a: ~[(A, B)]): Value[A, B] = new Value(Map(a.to[Seq]: _*))

  implicit def zzMake[A, B](v: \/): Value[A, B] = Void.asInstanceOf[Value[A, B]];

  // ******************************************************************************************************
  private[Lookup] object VoidMap extends scala.collection.immutable.AbstractMap[Any, Any] with Void {
    def +[A](v: (Any, A)) = Map(v)
    def -(key: Any) = this
    def get(key: Any) = scala.None
    def iterator = Iterator.empty
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
