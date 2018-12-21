package scalqa; package Util; package Enum; package A; package Java

class Setup[ENUM <: Java[ENUM, JAVA], JAVA <: java.lang.Enum[JAVA]] protected extends Enum.Setup[ENUM] with BiMap[JAVA, ENUM] {
  private var array = new Array[AnyRef](0)

  private[Enum] override def register(v: ENUM): Int = {
    val i = super.register(v)
    if (v.real != null) {
      if (array.length <= v.real.ordinal) array = array.copyResize(v.real.ordinal + 1)
      array(v.real.ordinal) = v
    }
    i
  }

  def apply(b: JAVA): ENUM = array(b.ordinal).asInstanceOf[ENUM]

  def undo(a: ENUM): JAVA = a.real

  implicit def zzMake(b: JAVA): ENUM = array(b.ordinal).asInstanceOf[ENUM]

  implicit def zzUndo(a: ENUM): JAVA = a.real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
