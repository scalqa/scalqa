package scalqa; package module

import Module.Id

object Id extends String.Custom.Type[Module.Id]("Module.Id"):

  def apply(v: String) : Id =
    var n=v
    if(n.endsWith("$$opaque$")) n=n.dropLast(9)
    n = n.replace("$$",".")
    if(n.endsWith(".opaque") && !n.endsWith("any.opaque") && !v.contains("delegate.opaque"))
      n = n.dropLast(7)
    n.asOpaque[Id]

  @tn("applyId") def apply(x: Member.Id) : Id =
    var n=x.toString
    if(n.endsWith("$")) n=n.dropLast(1)
    apply(n)

  object opaque:
    opaque type `type` <: Opaque.String = String & Opaque.String

