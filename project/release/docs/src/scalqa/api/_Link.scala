package scalqa; package api

trait _Link:

  extension (x: Link)
    def tag           : String      = "Link(name:"+x.name+", id=" + x.dri.id +")"
    def isPrivate     : Boolean     = x.dri.isPrivate
    def asLabel(om: Opt[Member] = \/, heading: Boolean = false): String = if(x.name.contains(".")) x.name else x.dri.label(x.name,om,heading)

    def improve(m: Member, heading: Boolean): Link =
      var n = x.dri.label(x.name)
      if(m.name != "M" && m.name != "O" && m.name != "OM") n = n.replace("Observable","O").replace("Mutable","M")
      var l = x.copy(name=n)
      val d = l.dri
      if(d.anchor.nonEmpty)
        def useBase(id: String, reviseLabel: String => String): Unit =
          Registry.member_?(Id(id + "." +d.anchor.takeBefore("-").nameToId)).forval(m=> l = Link(reviseLabel(d.label("")),m.dri))

        d match
          case d if d.location == "scalqa"                          => useBase("scalqa",v => v)
          case d if d.location.endsWith("$")                        => useBase(d.location.dropLast(1), v => v)
          case d if d.location.endsWith(".g.Containers")            => useBase(d.location.dropLast(11), _.remove(".G.Containers"))
//          case d if d.location.contains(".g.containers.companion.") => useBase(d.location.remove("containers.companion."), _.remove(".G.Containers.Companion"))
          case d => l

      l