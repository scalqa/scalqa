package scalqa; package Fx; package Style; package Pseudo

import javafx.css.{ PseudoClass => JClass }

class Class private (val real: JClass) extends AnyVal with A.Delegate.Data[Class, JClass] {
  protected def setup = Class

  def name: String = real.getPseudoClassName

}

object Class extends A.Delegate.Data.Setup[Class, JClass] {

  def make(v: JClass) = new Class(v)

  def make(s: String): Class = make(JClass.getPseudoClass(s))

  implicit def zzMake(s: String) = make(s)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
