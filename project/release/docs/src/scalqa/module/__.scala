package scalqa; import module.*

class Module (val typOpt : Opt[Member], val valOpt : Opt[Member]):
  val main               : Member  = typOpt or valOpt.get
  val name               : String  = main.name.withOp.self.mapIf(_ == "TYPE", v => valOpt.map(_.name) or v)
  var inner              : Boolean = false
  def prefix             : String  = if(inner) "A" else "B"
  def label              : String  = {var l=name; val i=l.lastIndexOf("."); if(i>0) l.substring(i+1); if(inner) l = "#" + l; l}
  def dri                : DRI     = typOpt.map(_.dri) or valOpt.get.dri
  def dri2               : DRI     = valOpt.map(_.dri) or typOpt.get.dri
  override def toString  : String  = "Module("+typOpt.map(_.tag) + ", " + valOpt.map(_.tag) + ")"
  def children: Pack[Module] = (Val.Stream.void[Module]
                               .joinAll(valOpt.stream.flatMap(_.children.members.valStream.mapOpt(_.dri.moduleOpt)))
                               .joinAll(typOpt.stream.flatMap(_.children.members.valStream.mapOpt(_.dri.moduleOpt).peek(_.inner=true)))
                               .toLookupBy(_.main.id.moduleId).stream.sort(using if(name=="scalqa") Sorting.root else if(name=="Lang") Sorting.lang else Sorting.byName)
                              ).drop(_.dri.isPrivate).pack
object Module:
  def apply(m: Member)           : Module = if(m.kin.isDefLike) new Val(m) else if(m.kin.isTypeLike) new Typ(m) else Docs.fail(m.kin)
  def apply(s: Seq[Member])      : Module = s.size match{ case 1 => apply(s.head); case 2 => apply(s.head,s.tail.head); case 3 => apply(s.head,s.tail.head); case v => { s.foreach(println); Docs.fail("size="+v) }}
  def apply(m1:Member, m2:Member): Module =
    val id= m1.id.moduleId
    if(id!=m2.id.moduleId) Docs.fail("No id match")
    if     (m1.kin.isTypeLike && m2.kin.isDefLike ) Both(m1,m2)
    else if(m1.kin.isDefLike  && m2.kin.isTypeLike) Both(m2,m1)
    else Docs.fail("Error: "+m1.tag+" <> "+m2.tag)

  class Both private(v1: Member,v2: Member) extends Module(v1,v2)
  object Both:
    def apply(v1: Member,v2: Member): Both = if(!v1.dri.isTypeDef) new Both(v1,v2) else
      val t = v1.members.valStream.find(_.name == "DEF")
      val m = t.copy(name=v2.name,dri=v1.dri,members=v2.members)
      Registry.update(m)
      new Both(m,v2)

  // *********************************************************
  class Typ(v: Member) extends Module(v,\/)
  class Val(v: Member) extends Module(\/,v)

  object Root extends Module(\/,\/):
    private def ?(v: String): Opt[Module] = Registry.moduleOpt(Id("scalqa."+v))
    @fast override lazy val children: Pack[Module] = scalqa.Val.Stream( ?("Lang").get, ?("Gen").get, ?("J").get, ?("Val").get).joinAll(?("Fx")).sort.pack

  given ordering: Ordering[Module] = Sorting.default

