package scalqa; import module.*

class Module (val id: Module.Id, val typ_? : Opt[Member], val val_? : Opt[Member]):
  val main               : Member  = typ_? or val_?.get
  val name               : String  = main.name.nameToOp.^.reviseIf(_ == "opaque", v => val_?.map(_.name) or v)
  var inner              : Boolean = false
  def prefix             : String  = if(inner) "A" else "B"
  def label              : String  = {var l=name; val i=l.lastIndexOf("."); if(i>0) l.substring(i+1); if(inner) l = "#" + l; l}
  def dri                : DRI     = typ_?.map(_.dri) or val_?.get.dri
  def dri2               : DRI     = val_?.map(_.dri) or typ_?.get.dri
  override def toString  : String  = "Module("+id+", "+typ_?.map(_.tag) + ", " + val_?.map(_.tag) + ")"
  def children: ><[Module] = ~~.void[Module]
                               .joinAll(val_?.~.flatMap(_.children.members.~.map_?(_.dri.module_?)))
                               .joinAll(typ_?.~.flatMap(_.children.members.~.map_?(_.dri.module_?).peek(_.inner=true)))
                               .toLookupBy(_.id).~.sort(using if(name=="scalqa") Sorting.root else Sorting.byName).><
object Module:
  val Id = module.Id;  type Id = module.Id.opaque.`type`

  def apply(m: Member)           : Module = if(m.kin.isDefLike) new Val(m) else if(m.kin.isTypeLike) new Typ(m) else Docs.fail(m.kin)
  def apply(s: Seq[Member])      : Module = s.size match{ case 1 => apply(s.head); case 2 => apply(s.head,s.tail.head); case 3 => apply(s.head,s.tail.head); case v => { s.foreach(println); Docs.fail("size="+v) }}
  def apply(m1: Member, m2: Member): Module =
    val id= m1.id.moduleId
    if(id!=m2.id.moduleId) Docs.fail("No id match")
    if     (m1.kin.isTypeLike && m2.kin.isDefLike ) Both(m1,m2)
    else if(m1.kin.isDefLike  && m2.kin.isTypeLike) Both(m2,m1)
    else Docs.fail("Error: "+m1.tag+" <> "+m2.tag)

  class Both private(v1: Member,v2: Member) extends Module(v1.id.moduleId,v1,v2)
  object Both:
    def apply(v1: Member,v2: Member): Both = if(!v1.dri.isOpaqueBase) new Both(v1,v2) else
      val t = v1.members.~.find(_.name == "`type`")
      val m = v1.copy(name=v2.name,kind=t.kind,dri=v1.dri.trimOpaqueBase,members=v2.members)
      Docs.update(m)
      new Both(m,v2)

  // *********************************************************
  class Typ(v: Member)            extends Module(v.id.moduleId,v,\/)
  class Val(v: Member)            extends Module(v.id.moduleId,\/,v)

  object Root extends Module(Module.Id("scalqa"),\/,\/):
    def ?(v: String): Opt[Module] = Docs.module_?(Module.Id("scalqa."+v))
    @fast override lazy val children: ><[Module] = ~~( ?("Lang").get, ?("Gen").get, ?("J").get, ?("Val").get).joinAll(?("Fx")).sort.><

  given ordering: Ordering[Module] = Sorting.default

