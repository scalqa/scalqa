package scalqa; package api

import dotty.tools.scaladoc.tasty.comments.Comment
import dotty.tools.scaladoc.translators.{ ScalaSignatureProvider, InlineSignatureBuilder}


transparent trait _Member:
  self: Api.type =>
  extension (x: Member)
    def id          : Id          = x.dri.id
    def kin         : Kind        = if(x.dri.isTypeDef) new Kind.Type(true,true,Nil) else x.kind
    def module      : Module      = x.dri.moduleOpt or Module(x)
    def children    : Children    = Children(x)
    def tag         : String      = x.name+"(ilk="+x.kind.name+", id="+x.id+", ##="+ x.## +")"
    def companionOpt : Opt[DRI]    = Opt.fromScala(x.companion) orOpt Registry.moduleOpt(id.moduleId).mapOpt(m => m.typOpt.drop(_.id == x.id) orOpt m.valOpt.drop(_.id == x.id)).map(_.dri)


    def label       : String      = x.dri.label()

    def parent      : Member      = if(x.dri.anchor.nonEmpty) Registry.memberOpt(Id(x.dri.copy(anchor="")).moduleId) or J.illegalState("No member: "+x.dri.location)  else J.illegalState("No anchor")

    def parentOpt   : Opt[Member] = if(x.dri.anchor.nonEmpty) Registry.memberOpt(Id(x.dri.copy(anchor="")).moduleId) else VOID

    def deepDocs: Option[Comment] =
      var o = x.docs
      if(o.isEmpty) x.origin.overrideOpt.mapOpt(_.overridenMembers.stream.readOpt).map(_.dri).mapOpt(Registry.memberOpt).mapOpt(_.members.~~.findOpt(_.name == x.name)).forval(m => o = m.deepDocs)
      o

    def extendsSignature: Signature = ScalaSignatureProvider.rawSignature(x, InlineSignatureBuilder()).asInstanceOf[InlineSignatureBuilder].names.reverse.scalqaSignature(x)


