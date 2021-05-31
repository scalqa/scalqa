package scalqa;

object Id extends String.Custom.Type[Id]("Id"):
  def apply(x: String)   : Id = x.lower.asOpaque[Id]
  def apply(v: DRI)      : Id  = apply(v.tag match{ case t if t.endsWith("$$opaque$.type") => t.dropLast(14); case t => t})
  def apply(x: Signature): Id =  apply(x.collect{case v:String => v; case v:Link => v.dri.id.real}.takeWhile(_ != "[").mkString)

  extension(x: Id)
    def mid        : String  = x.real.^.reviseIf(_.endsWith("$"),_.dropLast(1))

  object opaque:
    opaque type `type` <: Opaque.String = String & Opaque.String

