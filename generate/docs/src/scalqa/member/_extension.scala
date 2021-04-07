package scalqa; package member; import language.implicitConversions

transparent trait _extension:
  self: Api.type =>
  extension (x: Member)
    def id          : Member.Id   = x.dri.memberId
    def scalqaName  : String      = if(x.dri.tag == "scalqa.val.Stream$") "~~" else x.dri.scalqaName
    def kin         : Kind        = if(x.id.isOpaqueBase) new Kind.Type(true,true,Nil) else x.kind
    def module      : Module      = Docs.module_?(x.dri.moduleId) or Module(x)
    def children    : Children    = Children(x)
    def tag         : String      = x.name+"(ilk="+x.kind.name+", id="+x.id+", ##="+ x.## + (if(x.dri.isOpaque) " opaque" else "")  +")"
    def companion_? : Opt[DRI]    = Opt.fromScala(x.companion) or_? Docs.module_?(id.moduleId).map_?(m => m.typ_?.drop(_.id == x.id) or_? m.val_?.drop(_.id == x.id)).map(_.dri)


object Member:
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  val Id = member.Id;         type Id    = member.Id.opaque.`type`
