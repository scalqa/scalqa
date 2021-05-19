package scalqa

import dotty.tools.{ scaladoc as SD }

type Member = SD.Member
type Id     = scalqa.Id.opaque.`type`

export SD.{ DRI, Kind, Origin, Signature, Classlike, Link, ExtensionTarget}

given xxDoc: Api.type = Api

given stringOrdering: Ordering[String]  with
  extension(inline x: String) inline def mk: String = x.replace("~"," ").replace("_",".").toLowerCase
  def compare(x:String,y:String) = x.mk.compareTo(y.mk)

given memberOrdering:  Ordering[Member]  with
  extension(inline x: Member) inline def typ = if(x.kind.isType) 0 else 1
  def compare(x:Member,y:Member) = { var i=stringOrdering.compare(x.name,y.name); if(i!=0) i else x.typ - y.typ }



