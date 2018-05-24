package scalqa; package Any; package Enum; package The; package Java

class Companion[ENUM <: Java[ENUM, JAVA], JAVA <: java.lang.Enum[JAVA]] protected extends Enum.Companion[ENUM] with BiMap[JAVA, ENUM] {
  private var array = Array.get[AnyRef](0)

  private[Enum] override def register(v: ENUM): Int = super.register(v).I.run(if (v.java != null) {
    array.ensureCapacity(v.java.ordinal + 1, array = _, 1)
    array(v.java.ordinal) = v
  })

  def apply(b: JAVA): ENUM = array(b.ordinal).cast

  def undo(a: ENUM): JAVA = a.java

  import scala.language.implicitConversions

  implicit def zzGet(b: JAVA): ENUM = array(b.ordinal).cast

  implicit def zzUndo(a: ENUM): JAVA = a.java

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
