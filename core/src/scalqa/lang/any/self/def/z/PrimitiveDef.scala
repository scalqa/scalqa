package scalqa; package lang; package any; package self; package `def`; package z; import language.implicitConversions

class PrimitiveDef[A <: Any.Raw | Opaque](val name: String) extends Def.Name[A] with Def.Doc[A]:
  def tag(v: A): String    = v.toString
  def doc(v: A): Self.Doc  = Self.Doc(name) += ("value",v.toString)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
