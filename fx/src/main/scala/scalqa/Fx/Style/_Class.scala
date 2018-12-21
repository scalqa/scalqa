package scalqa; package Fx; package Style

class _Class(override val real: String) extends AnyVal with Any.Datum.String[_Class] {
  protected def setup = _Class

  override def +(v: Any): Style = Map(real + ';' + v)

  override def +~(v: ~[Any]): Style = Map(v.foldAs(real)(_ + ';' + _))

}

object _Class extends Any.Datum.String.Setup[_Class] {

  def make(v: String): Style = new Style(v)

  implicit def zzMake(v: String): Fx.Style = new Style(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
