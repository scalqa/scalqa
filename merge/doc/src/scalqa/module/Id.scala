package scalqa; package module

import Module.Id

object Id extends String.Custom.Type[Module.Id]("Module.Id"):

  def apply(v: String) : Id = v.asOpaque[Id]

  @tn("applyId") def apply(x: Member.Id) : Id =
    var n=x.toString
    if(n.endsWith("$$opaque$")) n=n.dropLast(9)
    if(n.endsWith("$"))         n=n.dropLast(1)
    n = n.replace("$$",".")
    apply(n)

  object opaque:
    opaque type `type` <: Opaque.String = String & Opaque.String

