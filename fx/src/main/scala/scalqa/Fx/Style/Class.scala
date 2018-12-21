package scalqa; package Fx; package Style

class Class(val real: String) extends AnyVal with Any.Datum.String[Class] {
  protected def setup = Class

  override def +(v: Any): Class = real + ';' + v
  override def +~(v: ~[Any]): Class = v.foldAs(real)(_ + ';' + _)

}

object Class extends Any.Datum.String.Setup[Class] {

  def make(v: String) = new Class(v)

  implicit def zzMake(v: String): Class = new Class(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
