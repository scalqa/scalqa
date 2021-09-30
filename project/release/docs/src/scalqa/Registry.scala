package scalqa

import dotty.tools.scaladoc.renderers.HtmlRenderer

object Registry:
  private var i = 0
  private var htmlRenderer: HtmlRenderer = null
  private var rootId_? : Opt[Id] = \/
  private val modules = Lookup.M[Id,Module]()
  private val members = Lookup.M[Id,Member]()

  @fast lazy val rootModule       : Module      = rootId_?.map_?(modules.get_?) or J.illegalState("Root is not set")
  /**/       def module_?(v: Id)  : Opt[Module] = modules.get_?(v)
  /**/       def member_?(v: Id)  : Opt[Member] = members.get_?(v)
  /**/       def member_?(v: DRI) : Opt[Member] = htmlRenderer.effectiveMembers.get(v)

  def registerRoot(m: Member): Unit =
    val id = m.dri.id.moduleId
    rootId_? = id
    println("=" * 40 + "\nRoot Registered:" +- id)
    val api  = Module(m)

    val root = m.members.find(_.name=="scalqa").get
    modules.put(id,api)
    modules.put(Id("scalqa"),Module(root))

  def update(v: Member): Boolean =
    i+=1; if(i%100==0) print("."+i)
    val id = v.dri.id
    if(!id.real.startsWith("scalqa")) return false
    members.put(id,v)
    def put(revise: String => String) = Id(revise(id.toString)).?.drop(_ == id).forval(members.put(_,v))
    put(_.replace("observable","o").replace("mutable","m"))
    put(_.replace(".val.","."))
    put(_.replace(".lang.","."))
    put(_.replace(".gen.","."))
    put(_.replace(".gen.calendar.","."))
    put(_.replace(".gen.time.","."))
    put(_.replace(".gen.request.","."))
    put(_.replace(".gen.math.","."))
    put(_.replace(".gen.util.","."))
    true

  def register(m: Member): Member =
    if(update(m) && m.kind.isClassLike && !m.name.contains("package"))
      try{
        val id = m.dri.id.moduleId
        val moduleId = modules.get_?(id).drop(_.main.id == m.id).map(v => Module(v.main,m)) or Module(m)
        modules.put(id,moduleId)
      } catch {
        case v: Throwable =>
          println("Failed to Register module: \n\t" + v.getMessage())
          v.printStackTrace()
      }
    m

  def register(v: HtmlRenderer) = htmlRenderer= v
