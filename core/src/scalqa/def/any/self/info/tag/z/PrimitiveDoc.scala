package scalqa; package `def`; package any; package self; package info; package tag; package z; import language.implicitConversions

class PrimitiveTag[A <: Any.Raw | Opaque](val name: String) extends Type[A] with Doc[A]:
  def tag(v: A): String = v.toString
  def info(v: A): Info   = Info(name) += ("value",v.toString)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
