package scalqa; package gen; package `given`; package z; import language.implicitConversions

class PrimitiveTag[A <: Any.Raw | Opaque](val typeName: String) extends `given`.TypeTag[A] with Given.DocTag[A]:

  def tag(v: A): String    = v.toString
  def doc(v: A): Doc       = Doc(typeName) += ("value",v.toString)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
