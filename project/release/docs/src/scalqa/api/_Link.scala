package scalqa; package api

trait _Link:

  extension (x: String | Link)
    def label : String  = x match{ case s: String => s; case l: Link => l.label }

  extension (x: Link)
    def tag       : String   = "Link(name:"+x.name+", id=" + x.dri.id +")"
    def isPrivate : Boolean  = x.dri.isPrivate
    def label     : String   = if(x.name.contains(".")) x.name else x.dri.label()

    def lookupAnchor_? : Opt[Link]=
      if(x.dri.anchor.isEmpty) \/
      else
        x.dri.location match
          case "scalqa" if x.dri.anchor.startsWith("\\/")  => Link("\\/", Registry.member_?(Id("scalqa.gen.request.void")).get.dri)
          case s if s=="scalqa"                            => x.lookup_?(s)
          case s if s.endsWith("$")                        => x.lookup_?(s.dropLast(1), true)
          case s if s.endsWith(".g.companion.Containers")  => x.copy(name = x.name.remove(".G.Companion.Containers")).lookup_?(s.remove(".companion.Containers"))
          case s if s.contains(".g.companion.")            => x.copy(name = x.name.remove(".G.Companion")).lookup_?(s.remove(".companion"))
          case _ => \/

    def lookup_?(location: String, ignore:Boolean=false): Opt[Link] =
      val id = Id(location + "." +x.dri.anchor.takeBefore("-").lowerNoOp)
      Registry.member_?(id)
        .fornil{ if(!ignore) x.name+" No id: "+id +"       " + x.dri.location tp() }
        .map(m => Link(x.name, m.dri))
