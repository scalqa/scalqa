package scalqa; package J; package Json; package Array

trait _Trait extends Data with Index[Any] {

  def string(idx: Int): String = this(idx).toString

  def obj(idx: Int): AnyRef = this(idx).cast[AnyRef]

  def array(idx: Int): Array = this(idx).cast[Array]

  def double(idx: Int) = string(idx).toDouble

  def boolean(idx: Int) = string(idx).toBoolean

  def long(idx: Int) = string(idx).toLong

  def int(idx: Int) = string(idx).toInt

  override def toString = format(this)

}

object _Trait extends Able.Void.Companion[Array](new Index.Z.The.Void[Nothing] with Array { protected def _add(t: Any) = Fail() })

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
