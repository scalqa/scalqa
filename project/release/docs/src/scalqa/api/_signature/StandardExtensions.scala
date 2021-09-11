package scalqa; package api; package _signature

object StandardExtensions:

    def apply(m:Member, x:Signature): Signature = if(x.isEmpty) x else
      var s: Signature = x.dropGenericDef("A")
      val n = m.name
      n.lower match
        case "map" | "flatten" | "flatmap" | "collect"                => s.prepended("[T]")
        case "map_?"                                                  => s.prepended("[T,OPT<:Any.Opt[T]]")
        case "mix"                                                    => s.prepended("[B,T]")
        case _ if n.endsWith("By")||n.endsWith("As")||n.endsWith("AS")=> s.prepended("[B]")
        case "foreach" | "foreachindexed" | "fornil" | "forval"       => s.prepended("[U]")
        case "process"                                                => s.prepended("[U,W]")
        case _ if n.endsWith("Few")                                   => s.prepended("[B,C,D,E,F]")
        case "transpose" | "zip" | "zipall" | "zipkey"
             | "zipvalue" | "takeType"                                => s.prepended("[B]")
        case "unzip"                                                  => s.prepended("[B,C]")
        case v if v.startsWith("peek")                                => s.prepended("[U]")
        case "raw"                                                    => s
        case _                                                        => s

