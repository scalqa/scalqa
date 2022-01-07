package scalqa; package api

trait _Link:

  extension (x: String | Link)
    def label : String  = x match{ case s: String => s; case l: Link => l.label }

  extension (x: Link)
    def tag       : String   = "Link(name:"+x.name+", id=" + x.dri.id +")"
    def isPrivate : Boolean  = x.dri.isPrivate
    def label     : String   = if(x.name.contains(".")) x.name else x.dri.label()

    def lookupAnchorOpt : Opt[Link]=
      if(x.dri.anchor.isEmpty) VOID
      else
        x.dri.location match
          case "scalqa" if x.dri.anchor.startsWith( "VOID")  => Link( "VOID", Registry.memberOpt(Id("scalqa.gen.request.void")).get.dri)
          case s if s=="scalqa"                            => x.lookupOpt(s)
          case s if s.endsWith("$")                        => x.lookupOpt(s.dropLast(1), true)
          case s if s.endsWith(".g.companion.Containers")  => x.copy(name = x.name.remove(".G.Companion.Containers")).lookupOpt(s.remove(".companion.Containers"))
          case s if s.contains(".g.companion.")            => x.copy(name = x.name.remove(".G.Companion")).lookupOpt(s.remove(".companion"))
          case _ => VOID

    def lookupOpt(location: String, ignore:Boolean=false): Opt[Link] =
      val id = Id(location + "." +x.dri.anchor.takeBefore("-").lower)
      Registry.memberOpt(id)
        .fornil{ if(!ignore) x.name+" No id: "+id +"       " + x.dri.location tp() }
        .map(m => Link(x.name, m.dri))
