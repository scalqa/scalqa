package scalqa; package api

import dotty.tools.scaladoc.tasty.comments.Comment

transparent trait _Member:
  self: Api.type =>
  extension (x: Member)
    def id          : Id          = x.dri.id
    def kin         : Kind        = if(x.dri.isTypeDef) new Kind.Type(true,true,Nil) else x.kind
    def module      : Module      = x.dri.module_? or Module(x)
    def children    : Children    = Children(x)
    def tag         : String      = x.name+"(ilk="+x.kind.name+", id="+x.id+", ##="+ x.## +")"
    def companion_? : Opt[DRI]    = Opt.fromScala(x.companion) or_? Registry.module_?(id.moduleId).map_?(m => m.typ_?.drop(_.id == x.id) or_? m.val_?.drop(_.id == x.id)).map(_.dri)


    def label       : String      = x.dri.label()

    def parent      : Member      = if(x.dri.anchor.nonEmpty) Registry.member_?(Id(x.dri.copy(anchor="")).moduleId) or J.illegalState("No member: "+x.dri.location)  else J.illegalState("No anchor")

    def deepDocs: Option[Comment] =
      var o = x.docs
      if(o.isEmpty) x.origin.override_?.map_?(_.overridenMembers.~.read_?).map(_.dri).map_?(Registry.member_?).map_?(_.members.~.find_?(_.name == x.name)).forval(m => o = m.deepDocs)
      o


