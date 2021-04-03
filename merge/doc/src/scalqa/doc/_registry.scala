package scalqa; package doc

class _registry:
  private var i = 0
  private var rootId_? : Opt[Module.Id] = \/
  private val modules = Lookup.M[Module.Id,Module]()
  private val members = Lookup.M[Member.Id,Member]()

  @fast lazy val rootModule            : Module      = rootId_?.map_?(modules.get_?) or J.illegalState("Root is not set")
  /**/       def module_?(v: Module.Id): Opt[Module] = modules.get_?(v)
  /**/       def member_?(v: Member.Id): Opt[Member] = members.get_?(v)

  def registerRoot(m: Member): Unit =
    val id = m.dri.moduleId
    rootId_? = id
    ("=" * 40 + "\nRoot Registered:" +- id).tp
    val api  = Module(m)
    m.members.~.map(_.name).print
    val root = m.members.find(_.name=="scalqa").get
    modules.put(id,api)
    modules.put(Module.Id("scalqa"),Module(root))

  def update(v: Member): Boolean =
    i+=1; if(i%100==0) print("."+i)
    val id = v.dri.memberId
    if(!id.real.startsWith("scalqa")) false
    else { members.put(id,v); true }

  def register(m: Member): Member =
    if(update(m) && m.kind.isClassLike && m.name != "__$package")
      try{
        val id = m.dri.moduleId
        val mod = module_?(id).drop(_.main.id == m.id).map(v => Module(v.main,m)) or Module(m)
        modules.put(id,mod)
      } catch {
        case v: Throwable =>
          "Failed to Register module: \n\t" + v.getMessage() tp()
          v.printStackTrace()
      }
    m
