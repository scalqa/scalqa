package scalqa; package lang; package any; package `def`; package z; import language.implicitConversions

class PrimitiveDef[A <: AnyVal | Any.Opaque](val typeName: String) extends TypeName[A] with Doc[A] with Able.Doc:
  def value_tag(v: A): String  = v.toString
  def value_doc(v: A): Gen.Doc = Gen.Doc(typeName) += ("value",v.toString)
  def doc            : Gen.Doc = Gen.Doc(this) += ("typeName",typeName)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
