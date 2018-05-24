package scalqa; package Byte

class Size(protected val real: Long) extends AnyVal with Long.Like{
  protected override type THIS = Size
  
  protected def companion = Size

  override def toString = real.brief + 'B'

}

object Size extends Long.Like.Companion[Size] {

  def get(v: Long) = new Size(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
