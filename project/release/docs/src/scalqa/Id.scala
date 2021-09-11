package scalqa;

object Id extends String.Opaque.Base[Id]("Id"):
  def apply(x: String)   : Id = x.lower.toOpaque
  def apply(v: DRI)      : Id  = apply(v.tag match{ case t if t.endsWith("$$TYPE$.DEF") => t.dropLast(11); case t => t})
  def apply(x: Signature): Id =  apply(x.collect{case v:String => v; case v:Link => v.dri.id.real}.takeWhile(_ != "[").mkString)

  extension(x: Id)
    /**/        def mid            : String = x.real.^.reviseIf(_.endsWith("$"),_.dropLast(1))
    @tn("join") def +(v: Id|String): Id     = {val s=v.cast[String]; apply(if(x.real.isVoid) s else if(s.isVoid) x.real else x.real + ';' + s)}

  object TYPE:
    opaque type DEF <: String.Opaque = String & String.Opaque

